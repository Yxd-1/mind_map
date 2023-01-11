package com.mind_map.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mind_map.common.R;
import com.mind_map.common.UserLoginToken;
import com.mind_map.entity.Theme;
import com.mind_map.service.ThemeService;
import com.mind_map.utils.JwtTokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/themes")
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    /**
     * 返回未被删除的主题
     * @return
     */
    @UserLoginToken
    @GetMapping
    public R<List<Theme>> list(HttpServletRequest request){
        log.info("theme list method");
        String token = request.getHeader("token");
        Integer id = (Integer) JwtTokenUtils.getTokenBody(token).get("id");
        LambdaQueryWrapper<Theme> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(Theme::getDeleted, 0);
        queryWrapper.eq(Theme::getUid, id);
        queryWrapper.orderByDesc(Theme::getUpdateTime);
        List<Theme> themes = themeService.list(queryWrapper);
        return R.success(themes);
    }

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @UserLoginToken
    @GetMapping("/page")
    public R<Page<Theme>> page(int page, int pageSize, String name, HttpServletRequest request){
        log.info("theme page method");
        Page<Theme> pageInfo = new Page<>(page, pageSize);
        String token = request.getHeader("token");
        Integer id = (Integer) JwtTokenUtils.getTokenBody(token).get("id");
        LambdaQueryWrapper<Theme> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Theme::getUid, id);
        queryWrapper.like(name != null, Theme::getTheme, name);
        queryWrapper.orderByDesc(Theme::getUpdateTime);
        themeService.page(pageInfo, queryWrapper);

        return R.success(pageInfo);
    }

    /**
     * 返回被删除的主题
     * @return
     */
    @UserLoginToken
    @GetMapping("/trashBin")
    public R<List<Theme>> listTrashBin(HttpServletRequest request){
        log.info("trash bin list method");
        String token = request.getHeader("token");
        Integer id = (Integer) JwtTokenUtils.getTokenBody(token).get("id");
        LambdaQueryWrapper<Theme> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Theme::getDeleted, 1);
        queryWrapper.orderByDesc(Theme::getUpdateTime);
        queryWrapper.eq(Theme::getUid, id);
        List<Theme> themes = themeService.list(queryWrapper);
        return R.success(themes);
    }

    /**
     * 保存新建的主题
     * @param theme
     * @return
     */
    @UserLoginToken
    @PostMapping
    public R<String> save(@RequestBody Theme theme, HttpServletRequest request){
        log.info("theme save method");
        // 得到用户的id
        String token = request.getHeader("token");
        Integer id = (Integer) JwtTokenUtils.getTokenBody(token).get("id");
        // 在前端进行限制，主题名字等不能为空，长度也应有限
        theme.setUid(id);
        themeService.save(theme);
        return R.success("success");
    }

    @UserLoginToken
    @PutMapping
    public R<String> update(@RequestBody Theme theme){
        log.info("theme update method");
        themeService.updateById(theme);
        return R.success("success");
    }

    @UserLoginToken
    @DeleteMapping
    public R<String> delete(HttpServletRequest request){
        log.info("theme delete method");
        Integer id = Integer.valueOf(request.getParameter("id"));
        themeService.removeById(id);

        return R.success("success");
    }

}
