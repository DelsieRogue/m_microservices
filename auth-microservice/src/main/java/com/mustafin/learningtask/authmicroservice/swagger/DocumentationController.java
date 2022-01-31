package com.mustafin.learningtask.authmicroservice.swagger;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
@EnableAutoConfiguration
public class DocumentationController implements SwaggerResourcesProvider {

    @Override
    public List get() {
        List resources = new ArrayList<>();
        resources.add(swaggerResource("goods-microservice", "http://localhost:8080/goods/v2/api-docs", "1.0"));
        resources.add(swaggerResource("admin-microservice", "http://localhost:8080/admin/v2/api-docs", "1.0"));
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String url, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setUrl(url);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }

}
