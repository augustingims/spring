package com.teamdev.app.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class ThymeleafWebMvcConfig implements WebMvcConfigurer{

		private final long MAX_AGE_SECS = 3600;
	
	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	                .allowedOrigins("*")
	                .allowedMethods("HEAD", "OPTIONS", "GET", "POST", "PUT", "PATCH", "DELETE")
	                .maxAge(MAX_AGE_SECS);
	    }
	    
	  @Bean
	  public ViewResolver viewResolver() {
	    ThymeleafViewResolver resolver = new ThymeleafViewResolver();
	    resolver.setTemplateEngine(templateEngine());
	    resolver.setCharacterEncoding("UTF-8");
	    return resolver;
	  }

	  @Bean
	  public ISpringTemplateEngine templateEngine() {
	    SpringTemplateEngine engine = new SpringTemplateEngine();
	    engine.setEnableSpringELCompiler(true);
	    engine.setTemplateResolver(templateResolver());
	    engine.setDialect(new LayoutDialect());
	    return engine;
	  }

	  private ITemplateResolver templateResolver() {
	    SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
	    resolver.setTemplateMode(TemplateMode.HTML);
	    resolver.setCharacterEncoding("UTF-8");
	    resolver.setCacheable(false);
	    resolver.setPrefix("classpath:/templates/");
	    resolver.setSuffix(".html");
	    return resolver;
	  }
	  
	//1.
		@Bean
		public LocaleResolver localResolver() {
			CookieLocaleResolver resolver = new CookieLocaleResolver();
			resolver.setDefaultLocale(new Locale("en"));
			resolver.setCookieName("spring_locale");
			resolver.setCookieMaxAge(4800);
			return resolver;
		}
		//2.
		@Bean
		public LocaleChangeInterceptor localeChangeInterceptor() {
			LocaleChangeInterceptor lang = new LocaleChangeInterceptor();
			lang.setParamName("lang");
			return lang;
		}
		//3.
		@Override
		public void addInterceptors(InterceptorRegistry registry) {
			// TODO Auto-generated method stub
	        registry.addInterceptor(localeChangeInterceptor());
		}
		//4.
		@Bean
		public MessageSource messageSource() {
			ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
			source.setBasename("classpath:/i18n/messages/message");
			source.setDefaultEncoding("UTF-8");
			source.setUseCodeAsDefaultMessage(true);
			source.setCacheSeconds(0);
			return source;
		}
}
