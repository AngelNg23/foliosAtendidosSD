package com.telcel.dashboard.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.ISpringTemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

/**
 *
 * @author Angel
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.telcel.dashboard")
public class MvcWebConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {

  @Autowired
  private ApplicationContext contexto;
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
    return engine;
  }

  // la carpeta donde se van a ubicar los ficheros html
  private ITemplateResolver templateResolver() {
    // que resolutor de plantillas uso
    SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
    // contexto con todos los objetos de spring
    resolver.setApplicationContext(contexto);
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".html");

    resolver.setCacheable(false);
    resolver.setTemplateMode(TemplateMode.HTML);
    return resolver;
  }
  @Override
  public void setApplicationContext(ApplicationContext contexto) throws BeansException {
    
    this.contexto=contexto;  
  }
  @Override
  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
      registry.addResourceHandler("/resources/**").addResourceLocations("WEB-INF/resources/");
  }

}