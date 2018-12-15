package com.tree.boot.aspect;

import com.tree.boot.action.aspect.service.Performance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AspectTest {
    @Autowired
    private Performance performance;

    @Test
    public void test1(){
        performance.perform();
    }
}
