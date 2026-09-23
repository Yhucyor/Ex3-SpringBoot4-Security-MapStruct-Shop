package thuc.ute.ex3springboot4securitymapstructshop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import thuc.ute.ex3springboot4securitymapstructshop.dto.CategoryDTO;
import thuc.ute.ex3springboot4securitymapstructshop.entity.Category;
import thuc.ute.ex3springboot4securitymapstructshop.mapper.CategoryMapper;
import thuc.ute.ex3springboot4securitymapstructshop.repository.CategoryRepository;
import thuc.ute.ex3springboot4securitymapstructshop.service.CategoryService;
import thuc.ute.ex3springboot4securitymapstructshop.service.CloudinaryService;
import thuc.ute.ex3springboot4securitymapstructshop.service.CloudinaryUploadResult;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final CloudinaryService cloudinaryService;

    @Override
    @Transactional(readOnly = true)
    public Page<CategoryDTO> findAll(String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(
                Math.max(page, 0), Math.max(size, 1),
                Sort.by(Sort.Direction.ASC, "name")
        );
        Page<Category> categoryPage = (keyword == null || keyword.isEmpty())
                ? categoryRepository.findAll(pageable)
                : categoryRepository.findByNameContainingIgnoreCase(keyword, pageable);
        
        return categoryPage.map(categoryMapper::toDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDTO> findAllActive() {
        return categoryRepository.findByEnabledTrueOrderByNameAsc()
                .stream()
                .map(categoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("Danh mục không tồn tại"));
    }

    @Override
    @Transactional
    public CategoryDTO create(CategoryDTO dto, MultipartFile image) {
        if (categoryRepository.existsByNameIgnoreCase(dto.getName())) {
            throw new IllegalArgumentException("Tên danh mục đã tồn tại");
        }

        Category category = categoryMapper.toEntity(dto);

        if (image != null && !image.isEmpty()) {
            CloudinaryUploadResult result = cloudinaryService.upload(image);
            category.setImageUrl(result.url());
            category.setImagePublicId(result.publicId());
        }

        return categoryMapper.toDTO(categoryRepository.save(category));
    }

    @Override
    @Transactional
    public CategoryDTO update(Long id, CategoryDTO dto, MultipartFile image) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Danh mục không tồn tại"));

        if (!category.getName().equalsIgnoreCase(dto.getName()) && 
            categoryRepository.existsByNameIgnoreCase(dto.getName())) {
            throw new IllegalArgumentException("Tên danh mục đã tồn tại");
        }

        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        category.setEnabled(dto.isEnabled());

        if (image != null && !image.isEmpty()) {
            // Delete old image if it exists
            if (category.getImagePublicId() != null && !category.getImagePublicId().isEmpty()) {
                cloudinaryService.delete(category.getImagePublicId());
            }
            // Upload new image
            CloudinaryUploadResult result = cloudinaryService.upload(image);
            category.setImageUrl(result.url());
            category.setImagePublicId(result.publicId());
        }

        return categoryMapper.toDTO(categoryRepository.save(category));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Danh mục không tồn tại"));
        
        if (category.getImagePublicId() != null && !category.getImagePublicId().isEmpty()) {
            cloudinaryService.delete(category.getImagePublicId());
        }
        
        categoryRepository.delete(category);
    }

    @Override
    @Transactional(readOnly = true)
    public long countCategories() {
        return categoryRepository.count();
    }
}
