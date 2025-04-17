package com.ching.aitools.controller;

import com.ching.aitools.common.R;
import com.ching.aitools.model.domain.Tool;
import com.ching.aitools.model.dto.ToolListDto;
import com.ching.aitools.model.dto.ToolObjectDto;
import com.ching.aitools.service.ToolService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tools")
public class ToolsController {
    @Resource
    private ToolService toolsService;

    @PostMapping("/addOrUpdateTool")
    public R addOrUpdateTool(@RequestBody ToolObjectDto toolParam) {
        toolsService.addOrUpdateTool(toolParam);
        return R.ok();
    }
    @PostMapping("/list")
    public R<PageInfo<Tool>> list(@RequestBody ToolListDto toolListDto) {
        return R.ok(toolsService.getToolList(toolListDto));
    }

    @GetMapping("/getToolById")
    public R<Tool> getToolById(Integer toolId) {
        return R.ok(toolsService.getToolDetail(toolId));
    }

    @DeleteMapping("/deleteToolById/{toolId}")
    public R deleteToolById(@PathVariable Integer toolId) {
        toolsService.deleteToolById(toolId);
        return R.ok();
    }
}
