package com.ching.aitools.model.dto;

import com.ching.aitools.model.domain.Tool;
import lombok.Data;

@Data
public class ToolObjectDto extends Tool implements java.io.Serializable {

    Integer[] category;
}
