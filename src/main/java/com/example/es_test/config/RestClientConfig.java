package com.example.es_test.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

/**
 * 配置elasticsearch client
 * @author liangbin02
 * @date 2020/6/3
 */

@Configuration
@PropertySource("classpath:esconfig.properties")
public class RestClientConfig extends AbstractElasticsearchConfiguration {

  @Value("${elasticsearch.host}")
  private String host;
  @Value("${elasticsearch.port}")
  private String port;
  @Value("${elasticsearch.client.connectTimeOut}")
  private int connectTimeOut;
  @Value("${elasticsearch.client.socketTimeOut}")
  private int socketTimeOut;

  @Override
  @Bean
  public RestHighLevelClient elasticsearchClient() {
    final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
        .connectedTo(host+":"+port)
        .withConnectTimeout(connectTimeOut)
        .withSocketTimeout(socketTimeOut)
        .build();
    return RestClients.create(clientConfiguration).rest();
  }
}
