package bitc.fullstack405.fun_spring.controller;

import bitc.fullstack405.fun_spring.entity.CategoryEntity;
import bitc.fullstack405.fun_spring.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("category/{categoryId}")
    public Object getCategory(@PathVariable(name = "categoryId") int categoryId) {
        CategoryEntity category = categoryService.getCategory(categoryId);

        return category;
    }
}
