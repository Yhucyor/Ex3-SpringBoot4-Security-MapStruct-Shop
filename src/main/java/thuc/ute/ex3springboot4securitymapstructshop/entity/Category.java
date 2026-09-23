package thuc.ute.ex3springboot4securitymapstructshop.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "categories",
        indexes = {
                @Index(
                        name = "idx_categories_name",
                        columnList = "name"
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            nullable = false,
            unique = true,
            length = 200,
            columnDefinition = "nvarchar(200)"
    )
    private String name;

    @Column(
            length = 1000,
            columnDefinition = "nvarchar(1000)"
    )
    private String description;

    @Column(length = 1000)
    private String imageUrl;

    @Column(length = 500)
    private String imagePublicId;

    @Builder.Default
    @Column(nullable = false)
    private boolean enabled = true;

    @Builder.Default
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList<>();
}