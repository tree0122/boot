package com.tree.boot.elasticsearch.service.single;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
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

    public void request(){
        IndexRequest request = new IndexRequest("posts", "doc", "1");
        String json = json();
        request.source(json, XContentType.JSON);

        ActionFuture<IndexResponse> future = client.index(request);
        IndexResponse response = future.actionGet();
        log.info("response: {}", response);
    }

    private String json(){
        String json = "{" +
                "\"user\":\"kimchy\"," +
                "\"postDate\":\"2013-01-30\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";
        return json;
    }

    private Map map(){
        HashMap<Object, Object> map = Maps.newHashMap();
        map.put("user","kimchy");
        map.put("postDate",new Date());
        map.put("message","trying out Elasticsearch");
        return map;
    }

    // todo
    private byte[] serializeObj(){
//        JSON.toJSONBytes();
        return null;
    }

    private String esHelper() throws IOException {
        XContentBuilder builder = XContentFactory.jsonBuilder()
                .startObject()
                    .field("user", "kimchy")
                    .field("postDate", new Date())
                    .field("message", "trying out Elasticsearch")
                .endObject();
        return builder.string();
    }

}
