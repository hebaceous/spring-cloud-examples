package me.hebaceous.cloud.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.ant;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SpringfoxConfig {

    @Value("${path.user}")
    private String userPath;

    @Value("${path.order}")
    private String orderPath;

    @Bean
    Docket userDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("user-api")
                .select()
                .paths(or(ant(userPath), ant(userPath + "/{userId}")))
                .build()
                .enableUrlTemplating(true);
    }

    @Bean
    Docket orderDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("order-api")
                .select()
                .paths(or(ant(orderPath), ant(orderPath + "/{orderId}")))
                .build()
                .enableUrlTemplating(true);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("ApiInfo")
                .description("some description")
                .termsOfServiceUrl("http://localhost:8000")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/hebaceous/spring-cloud-examples/blob/master/LICENSE")
                .version("1.0.0")
                .build();
    }
}
