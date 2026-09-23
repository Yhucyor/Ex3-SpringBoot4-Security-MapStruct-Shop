package thuc.ute.ex3springboot4securitymapstructshop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import thuc.ute.ex3springboot4securitymapstructshop.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository
        extends JpaRepository<Category, Long> {

    Page<Category> findByNameContainingIgnoreCase(
            String keyword,
            Pageable pageable
    );

    List<Category> findByEnabledTrueOrderByNameAsc();

    Optional<Category> findByNameIgnoreCase(String name);

    boolean existsByNameIgnoreCase(String name);
}