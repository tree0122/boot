package com.tree.boot.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

@Service
@Slf4j
public class AsyncService {

    public Callable<String> getById(String id){
        try {
            log.info("threadId: {}, id is: {}", Thread.currentThread().getId(), id);
            Thread.sleep(5000);

            return new Callable<String>() {
                @Override
                public String call() throws Exception {
                    log.info("in callable, threadId: {}, id is: {}", Thread.currentThread().getId(), id);
                    return id;
                }
            };

        } catch (InterruptedException e) {
            log.error("error,  exception :" , e);
        }
        return null;
    }


    public DeferredResult<String> getByCookie(Integer time){
        DeferredResult<String> result = new DeferredResult<>(5000L);
        log.info("deferredResult 开始, threadId: {}", Thread.currentThread().getId());

        result.onTimeout( () -> {
            log.info("deferredResult 超时, threadId: {}", Thread.currentThread().getId());
            result.setResult("timeout");
        });

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        result.setResult("完成");
        return result;
    }
}
