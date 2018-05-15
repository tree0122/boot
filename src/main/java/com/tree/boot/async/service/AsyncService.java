package com.tree.boot.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;

@Service
@Slf4j
public class AsyncService {

    public Callable<String> getById(String id){
        try {
            log.info("id is: {}", id);
            Thread.sleep(5000);

            return new Callable<String>() {
                @Override
                public String call() throws Exception {
                    log.info("in callable, id is: {}", id);
                    return id;
                }
            };

        } catch (InterruptedException e) {
            log.error("error,  exception :" , e);
        }
        return null;
    }
}
