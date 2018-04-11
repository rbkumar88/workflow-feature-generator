package com.workflow;

import com.consol.citrus.http.client.HttpClient;
import com.consol.citrus.http.client.HttpEndpointConfiguration;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

@Configuration
public class CitrusEndpointConfig {

//    @Bean
//    public HttpClient votingClient() {
//        return CitrusEndpoints.http()
//                .client()
//                .requestUrl("http://localhost:8181")
//                .build();
//    }
    @Bean
    public BeanDefinitionRegistryPostProcessor factory(final Environment environment) {
        return new BeanDefinitionRegistryPostProcessor() {
            @Override
            public void postProcessBeanDefinitionRegistry(final BeanDefinitionRegistry registry) throws BeansException {
                //TODO Read properties file/feature file and create appropriate Citrus beans from it
                    HttpEndpointConfiguration httpEndpointConfiguration = new HttpEndpointConfiguration();
                    httpEndpointConfiguration.setRequestUrl("http://localhost:8181");
                    BeanDefinition citrusEndpointsBd=BeanDefinitionBuilder
                            .rootBeanDefinition(HttpClient.class)
                            .addConstructorArgValue(httpEndpointConfiguration)
                            .getBeanDefinition();
                    registry.registerBeanDefinition("votingClient",citrusEndpointsBd);
            }

            @Override
            public void postProcessBeanFactory(final ConfigurableListableBeanFactory beanFactory) throws BeansException {
                // Nothing.
            }

        };
    }

}
