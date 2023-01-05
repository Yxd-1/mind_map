package com.mind_map.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mind_map.common.R;
import com.mind_map.entity.Theme;
import com.mind_map.service.ThemeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/theme")
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    /**
     * 返回未被删除的主题
     * @return
     */
    @GetMapping
    public R<List<Theme>> list(HttpServletRequest request){
        log.info("theme list method");
        String token = request.getParameter("token");
        LambdaQueryWrapper<Theme> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Theme::getDelete, 0);
        List<Theme> themes = themeService.list(queryWrapper);
        return R.success(themes);
    }

    /**
     * 返回被删除的主题
     * @return
     */
    @GetMapping("/trashBin")
    public R<List<Theme>> listTrashBin(){
        log.info("trash bin list method");
        LambdaQueryWrapper<Theme> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Theme::getDelete, 1);
        List<Theme> themes = themeService.list(queryWrapper);
        return R.success(themes);
    }


    /**
     * 保存新建的主题
     * @param theme
     * @return
     */
    @PostMapping
    public R<String> save(@RequestBody Theme theme){
        themeService.save(theme);
        return R.success("success");
    }

}
