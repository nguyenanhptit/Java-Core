package com.thuannd.config;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.xslt.XsltView;
import org.springframework.web.servlet.view.xslt.XsltViewResolver;

import com.thuannd.dao.StudentDAO;
import com.thuannd.dao.impl.StudentDAOImpl;

@Configuration
@ComponentScan(basePackages = "com.thuand")
@EnableWebMvc
public class MVCConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	ServletContext servletContext;

	// config file jsp
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setOrder(1);
		resolver.setPrefix("/student/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	// config to connect databases
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.apache.derby.jdbc.EmbeddedDriver");
		dataSource.setUrl("jdbc:derby:C:/Java/sampledb2;create=true");
		dataSource.setUsername("");
		dataSource.setPassword("");
		return dataSource;
	}

	// apache titles
	@Bean
	public ViewResolver titlesViewResolver() {
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setViewClass(TilesView.class);
		return viewResolver;
	}

	// apache tiles
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions("/titles/definitions.xml");
		tilesConfigurer.setCheckRefresh(true);
		return tilesConfigurer;
	}

	// upload file
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getCommonsMultipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setMaxUploadSize(100000);
		return commonsMultipartResolver;
	}

	// view in xslt by XSLTView Resolver
	@Bean
	public XsltViewResolver getXSLTViewResolver() {
		XsltViewResolver resolver = new XsltViewResolver();
		//resolver.setOrder(1);
		resolver.setViewClass(XsltView.class);
		resolver.setSourceKey("data");
		resolver.setSuffix(".xsl");
		resolver.setPrefix("/xsl/");
		return resolver;
	}

	// view in xslt by XSLTView
	/*
	 * @Bean public XsltView getXsltView() { XsltView xsltView = new XsltView();
	 * xsltView.setSourceKey("data"); xsltView.setUrl("/xsl/ClazzView.xsl");
	 * 
	 * return xsltView; }
	 */

	// view in excel
	@Bean
	public XmlViewResolver getXmlViewResolver() {
		XmlViewResolver resolver = new XmlViewResolver();
		resolver.setOrder(1);
		resolver.setLocation(new ServletContextResource(servletContext, "/WEB-INF/views.xml"));
		return resolver;
	}

	@Bean
	public StudentDAO getStudentDAO() {
		return new StudentDAOImpl(getDataSource());
	}
}
