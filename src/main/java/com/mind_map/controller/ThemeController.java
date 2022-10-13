package com.mind_map.controller;

import com.mind_map.common.R;
import com.mind_map.entity.Theme;
import com.mind_map.service.ThemeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/theme")
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @GetMapping
    public R<List<Theme>> list(){
        log.info("theme list method");
        List<Theme> themes = themeService.list();
        return R.success(themes);
    }

}
