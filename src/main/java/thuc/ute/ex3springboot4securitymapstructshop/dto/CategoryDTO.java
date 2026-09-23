package thuc.ute.ex3springboot4securitymapstructshop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO {

    private Long id;

    @NotBlank(message = "Tên danh mục không được để trống")
    @Size(
            max = 200,
            message = "Tên danh mục không được vượt quá 200 ký tự"
    )
    private String name;

    @Size(
            max = 1000,
            message = "Mô tả không được vượt quá 1000 ký tự"
    )
    private String description;

    private String imageUrl;

    private String imagePublicId;

    private boolean enabled;

    private long productCount;
}