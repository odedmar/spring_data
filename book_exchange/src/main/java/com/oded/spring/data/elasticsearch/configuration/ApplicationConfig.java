package com.oded.spring.data.elasticsearch.configuration;


import static org.elasticsearch.node.NodeBuilder.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages="com/oded/spring/data/elasticsearch/repository")
public class ApplicationConfig {
	
	@Bean
	public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(nodeBuilder().clusterName("oded").client(true).node().client());
    }

}
