package com.tree.boot.async.controller;

import com.tree.boot.async.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.AsyncContext;
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
    public Callable<String> call(HttpServletRequest request, HttpServletResponse response){
        String sessionId = request.getSession().getId();

        AsyncContext asyncContext = request.getAsyncContext();

        log.info("sessionId is: {}", sessionId);

        return asyncService.getById(sessionId);
    }
}
