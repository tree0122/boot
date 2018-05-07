package com.tree.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
public class HelloWorldController {

    @RequestMapping("hello1")
    public String hello1(){
        log.info("=== hello log date: {} ===", LocalDateTime.now());
        return "hello world";
    }
}
