package thuc.ute.ex3springboot4securitymapstructshop.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import thuc.ute.ex3springboot4securitymapstructshop.dto.CategoryDTO;
import thuc.ute.ex3springboot4securitymapstructshop.service.CategoryService;

@Controller
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    
    private final CategoryService categoryService;

    @GetMapping
    public String list(@RequestParam(defaultValue = "") String keyword,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "10") int size,
                       Model model) {
        Page<CategoryDTO> categoryPage = categoryService.findAll(keyword, page, size);
        model.addAttribute("categories", categoryPage);
        model.addAttribute("keyword", keyword);
        model.addAttribute("size", size);
        return "categories/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setEnabled(true);
        model.addAttribute("categoryDTO", categoryDTO);
        model.addAttribute("mode", "create");
        return "categories/form";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("categoryDTO") CategoryDTO dto,
                         BindingResult result,
                         @RequestParam(value = "image", required = false) MultipartFile image,
                         Model model,
                         RedirectAttributes redirect) {
        if (result.hasErrors()) {
            model.addAttribute("mode", "create");
            return "categories/form";
        }

        try {
            categoryService.create(dto, image);
            redirect.addFlashAttribute("success", "Thêm danh mục thành công");
            return "redirect:/categories";
        } catch (IllegalArgumentException e) {
            result.rejectValue("name", "error.categoryDTO", e.getMessage());
            model.addAttribute("mode", "create");
            return "categories/form";
        }
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("categoryDTO", categoryService.findById(id));
        model.addAttribute("mode", "edit");
        return "categories/form";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id,
                       @Valid @ModelAttribute("categoryDTO") CategoryDTO dto,
                       BindingResult result,
                       @RequestParam(value = "image", required = false) MultipartFile image,
                       Model model,
                       RedirectAttributes redirect) {
        if (result.hasErrors()) {
            model.addAttribute("mode", "edit");
            return "categories/form";
        }

        try {
            categoryService.update(id, dto, image);
            redirect.addFlashAttribute("success", "Cập nhật danh mục thành công");
            return "redirect:/categories";
        } catch (IllegalArgumentException e) {
            result.rejectValue("name", "error.categoryDTO", e.getMessage());
            model.addAttribute("mode", "edit");
            return "categories/form";
        }
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        categoryService.delete(id);
        redirect.addFlashAttribute("success", "Xóa danh mục thành công");
        return "redirect:/categories";
    }
}
