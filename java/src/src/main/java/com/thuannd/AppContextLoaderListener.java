package com.thuannd;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;

public class AppContextLoaderListener extends ContextLoaderListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("--------> da huy ung dung");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("--------> da khoi tao ung dung");
	}

}
