package thuc.ute.ex3springboot4securitymapstructshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import thuc.ute.ex3springboot4securitymapstructshop.dto.CategoryDTO;
import thuc.ute.ex3springboot4securitymapstructshop.entity.Category;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CategoryMapper {

    CategoryDTO toDTO(Category category);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "products", ignore = true)
    Category toEntity(CategoryDTO dto);
}