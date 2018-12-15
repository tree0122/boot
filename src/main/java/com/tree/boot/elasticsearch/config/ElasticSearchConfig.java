package com.tree.boot.elasticsearch.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
@ConfigurationProperties(prefix = "elasticsearch.client")
@Slf4j
@Data
public class ElasticSearchConfig {

    private String host;

    private Integer port;

    private String clusterName;

    private Boolean transportSniff;

    /**
     * client
     * <p>
     * https://www.elastic.co/guide/en/elasticsearch/client/java-api/6.0/java-docs-index.html
     *
     * @return
     */
    @Bean
    public TransportClient transportClient() {
        try {
            Settings settings = Settings.builder()
                    .put("cluster.name", clusterName)
                    .put("client.transport.sniff", transportSniff)
                    .build();
            return new PreBuiltTransportClient(settings)
                    .addTransportAddress(new TransportAddress(InetAddress.getByName(host), port));

        } catch (UnknownHostException e) {
            log.error("es init fail! host: {}, port {}, clusterName: {}", host, port, clusterName);
        }

        return null;
    }

    /**
     * rest client
     * <p>
     * https://www.elastic.co/guide/en/elasticsearch/client/java-rest/6.0/java-rest-high-document-index.html
     *
     * @return
     */
    @Bean
    public RestHighLevelClient restHighLevelClient() {
        RestHighLevelClient highLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost(host, port))
        );
        return highLevelClient;
    }

}
