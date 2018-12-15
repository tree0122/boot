package com.tree.boot.async.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;

import javax.annotation.PostConstruct;

//@Configuration
public class AsyncConfig implements ApplicationContextAware, BeanFactoryAware {

    private ApplicationContext applicationContext;

    private BeanFactory beanFactory;

    @PostConstruct
    public void init() {
        WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter bean = applicationContext.getBean(WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter.class);
        bean.configureAsyncSupport(asyncSupportConfigurer());
    }

    @Bean
    public AsyncSupportConfigurer asyncSupportConfigurer() {
        AsyncSupportConfigurer configurer = new AsyncSupportConfigurer();
        configurer.setDefaultTimeout(30 * 1000)
                .setTaskExecutor(new SimpleAsyncTaskExecutor());
        return configurer;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
