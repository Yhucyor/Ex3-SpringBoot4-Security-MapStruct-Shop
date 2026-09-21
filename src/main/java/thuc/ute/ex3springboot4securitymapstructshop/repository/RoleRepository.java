package thuc.ute.ex3springboot4securitymapstructshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thuc.ute.ex3springboot4securitymapstructshop.entity.Role;

import java.util.Optional;
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}