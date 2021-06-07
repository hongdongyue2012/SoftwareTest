package com.hziee.softwaretest.util;


import org.springframework.context.ApplicationContext;

import java.util.Arrays;

/**
 * Spring 辅助类
 */
public class SpringUtil {
	public static ApplicationContext applicationContext = null;

	/**
	 * 设置应用程序上下文
	 * @param applicationContext 传入应用程序上下文
	 */
	public static void setApplicationContext(ApplicationContext applicationContext) {
		SpringUtil.applicationContext = applicationContext;
	}

	/**
	 * 打印可用的Bean
	 */
	public static void printBean() {
		String[] beanNames = applicationContext.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}
}
