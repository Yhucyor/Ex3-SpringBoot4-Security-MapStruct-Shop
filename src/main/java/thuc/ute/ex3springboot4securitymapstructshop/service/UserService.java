package thuc.ute.ex3springboot4securitymapstructshop.service;

import org.springframework.data.domain.Page;
import thuc.ute.ex3springboot4securitymapstructshop.dto.UserDTO;

public interface UserService {
    Page<UserDTO> findAll(String keyword, int page, int size);
    UserDTO findById(Long id);
    UserDTO create(UserDTO dto);
    UserDTO update(Long id, UserDTO dto);
    void delete(Long id);
    long countUsers();
    long countProducts(Long userId);
}