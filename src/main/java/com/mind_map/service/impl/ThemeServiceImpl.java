package com.mind_map.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mind_map.entity.Theme;
import com.mind_map.mapper.ThemeMapper;
import com.mind_map.service.ThemeService;
import org.springframework.stereotype.Service;

@Service
public class ThemeServiceImpl extends ServiceImpl<ThemeMapper, Theme> implements ThemeService {
}
