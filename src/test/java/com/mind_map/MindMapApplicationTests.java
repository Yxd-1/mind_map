package com.mind_map;

import com.mind_map.entity.Theme;
import com.mind_map.entity.User;
import com.mind_map.service.ThemeService;
import com.mind_map.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootTest
class MindMapApplicationTests {

	@Autowired
	private ThemeService themeService;

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
		Theme theme = new Theme();
		theme.setId(2);
		theme.setName("测试主题");
		theme.setChildren(7);
		theme.setParent(0);
		themeService.save(theme);
	}

	@Test
	void listTest(){

	}


	//注入redis客户端
	@Autowired
	private StringRedisTemplate redisTemplate;
	@Test
	void test() throws InterruptedException {
		//添加key为name，value为lisi的数据，该数据6秒后过期
		/**
		 *	参数1：key值
		 *	参数2：value值
		 *	参数3：过期时间
		 *	参数4：时间单位
		 */
		redisTemplate.opsForValue().set("name","lisi",20, TimeUnit.SECONDS);
		//从数据库中获取对应key的value
		String value = redisTemplate.opsForValue().get("name");
		System.out.println(value);

		Thread.sleep(6_000);
		value = redisTemplate.opsForValue().get("name");
		System.out.println(value);
	}


}
