package com.mind_map;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mind_map.entity.Node;
import com.mind_map.entity.Theme;
import com.mind_map.entity.User;
import com.mind_map.service.NodeService;
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

	@Autowired
	private NodeService nodeService;

	@Test
	void contextLoads() {
		Theme theme = new Theme();
		LambdaQueryWrapper<Theme> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(Theme::getId, 2);
		themeService.remove(queryWrapper);
	}

	@Test
	void saveTheme(){
		Theme theme = new Theme();
		theme.setUid(1);
		theme.setTheme("test2");
		themeService.save(theme);
	}

	@Test
	void updateTheme(){
		Theme theme = new Theme();
		theme.setId(3);
		theme.setUid(2);
		theme.setTheme("testUpdate");
		themeService.updateById(theme);
	}

	@Test
	void saveNode(){
		Node node = new Node();
		node.setName("mindmap");
		node.setRid(1);
		node.setPid(0);
		node.setLevel(0);
		nodeService.save(node);
	}

	@Test
	void listTest(){
		User user = new User();
		user.setUsername("ahahha");
		user.setPassword("123456");
		userService.save(user);
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
