package com.fzrj.architect.labor;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @className:com.fzrj.architect.labor.Application
 * @description:服务启动类
 * @version:v1.0.0
 * @date:2017年6月22日 上午11:16:33
 * @author:WangHao
 */
@SpringBootApplication
@Controller
public class Application
{
	public static void main(String[] args)
	{
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames)
		{
			System.out.println(beanName);
		}

	}
	
	@RequestMapping("/gen")
	public String gen()
	{
		return "index";
	}
}
