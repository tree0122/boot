package com.tree.boot.elasticsearch.service.single;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryAction;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 */
@Service
@Slf4j
public class Index {

    @Autowired
    private TransportClient client;

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    public void restHigh() {
        IndexRequest request = new IndexRequest("posts", "doc", "1");
        String json = json();
        request.source(json, XContentType.JSON);

        ActionFuture<IndexResponse> future = client.index(request);
        IndexResponse response = future.actionGet();
        log.info("response: {}", response);
    }

    public void put() {
        IndexResponse response = client.prepareIndex("twitter", "tweet", "3")
                .setSource(esHelper())
                .get();
        log.info("response: {}", response);

    }

    public void get() {
        GetResponse response = client.prepareGet("twitter", "tweet", "2")
                .get();
        Map<String, Object> map = response.getSourceAsMap();

        log.info("map: {}", map);
    }

    public void del() {
        DeleteResponse response = client.prepareDelete("twitter", "tweet", "2")
                .get();

        log.info("response: {}", response);
    }

    public long delByQuery() {
//        QueryBuilders.
//        AggregationBuilders.geoBounds("1").
        BulkByScrollResponse response = DeleteByQueryAction.INSTANCE
                .newRequestBuilder(client)
                .filter(QueryBuilders.matchQuery("postDate", "2018"))
                .source("twitter")
                .get();

        log.info("response: {}", response);

        return response.getDeleted();
    }

    private String json() {
        String json = "{" +
                "\"user\":\"kimchy\"," +
                "\"postDate\":\"2013-01-30\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";
        return json;
    }

    private Map map() {
        HashMap<Object, Object> map = Maps.newHashMap();
        map.put("user", "kimchy");
        map.put("postDate", new Date());
        map.put("message", "trying out Elasticsearch");
        return map;
    }

    // todo
    private byte[] serializeObj() {
//        JSON.toJSONBytes();
        return null;
    }

    private XContentBuilder esHelper() {
        XContentBuilder builder = null;
        try {
            builder = XContentFactory.jsonBuilder()
                    .startObject()
                    .field("user", "kimchy")
                    .field("postDate", new Date())
                    .field("message", "trying out Elasticsearch")
                    .endObject();
        } catch (IOException e) {
            log.error("es helper error");
        }
        return builder;
    }

}
