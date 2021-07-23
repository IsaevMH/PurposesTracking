package org.purposetracking.controller;

import org.purposetracking.model.Category;
import org.purposetracking.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category/all")
    public String showCategories(ModelMap map) {
        List<Category> categories = categoryService.getAll();
        map.put("categories", categories);
        return "categories-page";
    }

    @GetMapping("/category/new")
    public String showCtreationForm(ModelMap map) {
        Category category = new Category();
        map.put("category", category);
        return "category-new";
    }

    @PostMapping("/category/new")
    public String createCategory(Category category, ModelMap map) {
        categoryService.save(category);
        map.put("categories", category);
        return showCategories(map);
    }

    @GetMapping("/category/modify/{id}")
    public String showModificationForm(@PathVariable long id, ModelMap map) {
        Category category = categoryService.get(id);
        map.put("category", category);
        return "category-modify";
    }

    @PostMapping("/category/modify")
    public String modifyCategory(@ModelAttribute Category category, ModelMap map) {
        categoryService.save(category);
        map.put("category", category);
        return showCategories(map);
    }

    @GetMapping("/category/remove/{id}")
    public String removeCategory(@PathVariable long id, ModelMap map) {
        Category category = categoryService.get(id);
        categoryService.delete(category);
        map.put("category", category);
        return showCategories(map);
    }
}
