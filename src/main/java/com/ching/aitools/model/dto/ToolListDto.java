package com.ching.aitools.model.dto;

import lombok.Data;

@Data
public class ToolListDto {
    String toolName;

    Integer pageSize;

    Integer pageNumber;
}
