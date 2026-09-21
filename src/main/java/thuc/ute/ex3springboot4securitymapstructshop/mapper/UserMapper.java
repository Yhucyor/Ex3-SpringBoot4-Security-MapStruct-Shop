package thuc.ute.ex3springboot4securitymapstructshop.mapper;

import org.mapstruct.*;
import thuc.ute.ex3springboot4securitymapstructshop.dto.UserDTO;
import thuc.ute.ex3springboot4securitymapstructshop.entity.User;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    @Mapping(target = "roleName", source = "role.name")
    UserDTO toDTO(User entity);
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "products", ignore = true)
    @Mapping(target = "password", ignore = true)
    User toEntity(UserDTO dto);
}