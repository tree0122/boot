package com.tree.boot.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("hello")
    @PreAuthorize("hasRole('ADMIN')")
    public String hello(){
        return "hello";
    }

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("manage")
    @PreAuthorize("hasPermission('manage', '')")
    public String manage(HttpServletRequest request){

        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return "hello";
    }


}
