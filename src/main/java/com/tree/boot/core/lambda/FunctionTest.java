package com.tree.boot.core.lambda;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class FunctionTest {

    @Test
    public void test1(){
        ArrayList<Integer> list = Lists.newArrayList(1, 4, 2);
        Collections.sort(list, (o1, o2) -> o2.compareTo(o1));
        System.out.println(list);
    }
}
