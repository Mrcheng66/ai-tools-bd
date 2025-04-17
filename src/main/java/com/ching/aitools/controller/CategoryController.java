package com.ching.aitools.controller;

import com.ching.aitools.common.R;
import com.ching.aitools.model.domain.Category;
import com.ching.aitools.model.dto.CategoryListDto;
import com.ching.aitools.model.dto.NewCategoryDto;
import com.ching.aitools.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @GetMapping("/list")
    public R list(CategoryListDto categoryListDto) {
        List<Category> treeList = categoryService.getTreeList(categoryListDto);
        return R.ok(treeList);
    }

    @PostMapping("/addCategory")
    public R addCategory(@RequestBody NewCategoryDto newCategoryDto){
        categoryService.updateOrAddCategory(newCategoryDto);
        return R.ok();
    }
}
