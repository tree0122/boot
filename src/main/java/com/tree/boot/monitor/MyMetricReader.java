package com.tree.boot.monitor;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.boot.actuate.metrics.reader.MetricReader;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;

@Component
public class MyMetricReader implements MetricReader {

    private static Map<String, Integer> map = Maps.newConcurrentMap();

    static {
        map.put("counter.user.num", 10);
    }

    @Override
    public Metric<?> findOne(String metricName) {
        Metric<Integer> metric = new Metric<>(metricName, map.get(metricName));
        return metric;
    }

    @Override
    public Iterable<Metric<?>> findAll() {
        ArrayList<Metric<?>> list = Lists.newArrayList();
        list.add(findOne("counter.user.num"));
        return list;
    }

    @Override
    public long count() {
        return map.size();
    }

}
