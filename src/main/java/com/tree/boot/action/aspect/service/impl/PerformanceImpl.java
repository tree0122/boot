package com.tree.boot.action.aspect.service.impl;

import com.tree.boot.action.aspect.service.Performance;
import org.springframework.stereotype.Service;

@Service
public class PerformanceImpl implements Performance {
    @Override
    public void perform() {
        System.out.println("performance");
    }
}
