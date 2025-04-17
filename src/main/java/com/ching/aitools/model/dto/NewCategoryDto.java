package com.ching.aitools.model.dto;

import lombok.Data;

@Data
public class NewCategoryDto {

    // 分类名称
    public String categoryName;

    // 父级id
    public String parentId;

    // 分类id
    public String categoryId;
}
