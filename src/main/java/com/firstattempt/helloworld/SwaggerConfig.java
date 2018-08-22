package com.firstattempt.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().paths(postPaths()).build();
    }

    /* Here is specified which methods should be visible in Swagger documentation
    * for example with /api/hello.* we are able to see the documentation for all
    * web method that use prefix /api/hello
    * Otherwise with pathReger = /api/hello we are able to see in documentation
    * only the method with params and not the method /api/hello/{name}*/
    private Predicate<String> postPaths() {
        return or(regex("/api/hello.*"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Test API")
                .description("JavaInUse API reference for developers")
                .termsOfServiceUrl("http://javainuse.com")
                .version("1.0").build();
    }

}