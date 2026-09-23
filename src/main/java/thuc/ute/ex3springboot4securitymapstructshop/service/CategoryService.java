package thuc.ute.ex3springboot4securitymapstructshop.service;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;
import thuc.ute.ex3springboot4securitymapstructshop.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    Page<CategoryDTO> findAll(String keyword, int page, int size);
    List<CategoryDTO> findAllActive();
    CategoryDTO findById(Long id);
    CategoryDTO create(CategoryDTO dto, MultipartFile image);
    CategoryDTO update(Long id, CategoryDTO dto, MultipartFile image);
    void delete(Long id);
    long countCategories();
}
