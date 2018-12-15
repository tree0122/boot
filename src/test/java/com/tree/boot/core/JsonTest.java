package com.tree.boot.core;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

public class JsonTest {

    @Test
    public void test1() {
        String s = "[\"car\", \"bike\"]";
//        String s = "[car, bike]";
        List<String> list = JSON.parseArray(s, String.class);
        System.out.println(list);
    }

    @Test
    public void test2() {
        double d1 = 0.0D;
        double d2 = 0.00D;
        System.out.println(Double.compare(d1, d2));
        System.out.println(Double.compare(d1, 0L));
    }
}
