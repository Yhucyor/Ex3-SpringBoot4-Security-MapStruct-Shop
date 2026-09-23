package thuc.ute.ex3springboot4securitymapstructshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import thuc.ute.ex3springboot4securitymapstructshop.service.CategoryService;
import thuc.ute.ex3springboot4securitymapstructshop.service.ProductService;
import thuc.ute.ex3springboot4securitymapstructshop.service.UserService;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final UserService userService;
    private final ProductService productService;
    private final CategoryService categoryService;
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("userCount", userService.countUsers());
        model.addAttribute("productCount", productService.countProducts());
        model.addAttribute("categoryCount", categoryService.countCategories());
        return "home";
    }
}