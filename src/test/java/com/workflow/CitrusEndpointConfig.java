package com.workflow;

import com.consol.citrus.dsl.endpoint.CitrusEndpoints;
import com.consol.citrus.http.client.HttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CitrusEndpointConfig {

    @Bean
    public HttpClient votingClient() {
        return CitrusEndpoints.http()
                .client()
                .requestUrl("http://localhost:8181")
                .build();
    }

}
