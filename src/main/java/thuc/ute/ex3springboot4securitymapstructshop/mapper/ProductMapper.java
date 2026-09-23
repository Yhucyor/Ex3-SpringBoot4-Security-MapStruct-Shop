package thuc.ute.ex3springboot4securitymapstructshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import thuc.ute.ex3springboot4securitymapstructshop.dto.ProductDTO;
import thuc.ute.ex3springboot4securitymapstructshop.entity.Product;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ProductMapper {

    /*
     * Chuyển Product Entity thành ProductDTO
     */
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target = "categoryName", source = "category.name")
    @Mapping(target = "image", ignore = true)
    ProductDTO toDTO(Product entity);

    /*
     * Chuyển ProductDTO thành Product Entity
     *
     * User và Category sẽ được tìm trong Service
     * thông qua userId và categoryId.
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Product toEntity(ProductDTO dto);
}