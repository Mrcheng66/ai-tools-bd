package com.ching.aitools.controller;

import com.ching.aitools.common.R;
import com.ching.aitools.model.domain.Articles;
import com.ching.aitools.service.ArticlesService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/article")
public class ArticleController {
    @Resource
    private ArticlesService articleService;

    @PostMapping("/addOrUpdate")
    public R<Articles> addOrUpdate(@RequestBody Articles articles) {
        Articles articles1 = articleService.saveOrUpdateArticle(articles);
        return R.ok(articles1);
    }
}
