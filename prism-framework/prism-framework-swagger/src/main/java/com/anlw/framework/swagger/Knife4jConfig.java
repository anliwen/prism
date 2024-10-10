package com.anlw.framework.swagger;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anliwen
 */
@ConditionalOnClass({OpenAPI.class})
@EnableConfigurationProperties(SwaggerConfig.class)
@ConditionalOnProperty(name = "springdoc.api-docs.enabled", havingValue = "true")
@Component
public class Knife4jConfig {

    @Bean
    public OpenAPI openApi(SwaggerConfig properties) {
        Map<String, SecurityScheme> securitySchemas = this.buildSecuritySchemes();
        OpenAPI api = new OpenAPI()
                // 接口信息
                .info(this.buildInfo(properties))
                // 接口安全配置
                .components(new Components().securitySchemes(securitySchemas));
        securitySchemas.keySet()
                .forEach(key -> api.addSecurityItem(new SecurityRequirement().addList(key)));
        return api;
    }

    /**
     * api 摘要信息
     */
    private Info buildInfo(SwaggerConfig properties) {
        return new Info()
                .title(properties.getTitle())
                .description(properties.getDescription())
                .version(properties.getVersion())
                .contact(new Contact().name(properties.getAuthor()).url(properties.getUrl()).email(properties.getEmail()))
                .license(new License().name(properties.getLicense()).url(properties.getLicenseUrl()));
    }

    /**
     * 配置请求头 Authorization 传递 token 参数
     *
     * @return 安全模式
     */
    private Map<String, SecurityScheme> buildSecuritySchemes() {
        Map<String, SecurityScheme> securitySchemes = new HashMap<>();
        SecurityScheme securityScheme = new SecurityScheme()
                // 类型
                .type(SecurityScheme.Type.APIKEY)
                // 请求头的 name
                .name(HttpHeaders.AUTHORIZATION)
                // token 所在位置
                .in(SecurityScheme.In.HEADER);
        securitySchemes.put(HttpHeaders.AUTHORIZATION, securityScheme);
        return securitySchemes;
    }
}
