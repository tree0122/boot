package com.tree.boot.core.lambda;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class FunctionTest {

    public void test1(){
        ArrayList<Integer> list = Lists.newArrayList(1, 4, 2);
        Collections.sort(list, (o1, o2) -> o2.compareTo(o1));
        System.out.println(list);
    }

    public void test2(){
        String reduce = Stream.of(3, 4, 5)
                .map(i -> i + "")
                .reduce("", (o1, o2) -> o1 + "," + o2);
        System.out.println(reduce);
    }
}
