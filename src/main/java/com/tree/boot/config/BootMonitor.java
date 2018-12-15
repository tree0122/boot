package com.tree.boot.config;

import com.tree.boot.monitor.MyMetricReader;
import org.springframework.boot.actuate.autoconfigure.ExportMetricReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BootMonitor {

    @Bean
    @ExportMetricReader
    public MyMetricReader myMetricReader() {
        return new MyMetricReader();
    }

}
