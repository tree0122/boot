package com.tree.boot.elasticsearch;

import com.tree.boot.elasticsearch.service.single.Index;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IndexTest {
    @Autowired
    private Index index;

    @Test
    public void put() {
        index.put();
    }

    @Test
    public void get() {
        index.get();
    }

    @Test
    public void del() {
        index.del();
    }

    @Test
    public void delByQuery() {
        index.delByQuery();
    }
}
