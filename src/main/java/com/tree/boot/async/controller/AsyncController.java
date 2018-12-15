package com.tree.boot.async.controller;

import com.tree.boot.async.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import javax.servlet.AsyncContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.Callable;

@RestController
@RequestMapping("async")
@Slf4j
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("call")
    public Callable<String> call(HttpServletRequest request, HttpServletResponse response) {
        String sessionId = request.getSession().getId();

//        AsyncContext asyncContext = request.getAsyncContext();

        log.info("threadId: {}, sessionId is: {}", Thread.currentThread().getId(), sessionId);

        Callable<String> call = asyncService.getById(sessionId);

        return call;
    }

    @RequestMapping("defer")
    public DeferredResult<String> defer(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();

        String time = request.getParameter("time");

        log.info("threadId: {}, cookies are: {}", Thread.currentThread().getId(), cookies[0]);


        return asyncService.getByCookie(Integer.parseInt(time) * 1000);
    }
}
