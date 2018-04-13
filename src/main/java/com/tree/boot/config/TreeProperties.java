package com.tree.boot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class TreeProperties {
    @Value("${com.tree.name}")
    private String name;

    @Value("${com.tree.sex}")
    private String sex;

    @PostConstruct
    public void init(){
        System.out.println(name + "=====" + sex);
    }

}
