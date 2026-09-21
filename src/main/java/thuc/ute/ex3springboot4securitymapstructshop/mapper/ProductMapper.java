package thuc.ute.ex3springboot4securitymapstructshop.mapper;

import org.mapstruct.*;
import thuc.ute.ex3springboot4securitymapstructshop.dto.ProductDTO;
import thuc.ute.ex3springboot4securitymapstructshop.entity.Product;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "image", ignore = true)
    ProductDTO toDTO(Product entity);
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Product toEntity(ProductDTO dto);
}