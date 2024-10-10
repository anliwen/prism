package com.anlw.framework.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * swagger 配置
 *
 * @author anliwen
 */
@Data
@ConfigurationProperties("prism.swagger")
public class SwaggerConfig {

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * 作者
     */
    private String author;

    /**
     * 版本
     */
    private String version;

    /**
     * url
     */
    private String url;

    /**
     * email
     */
    private String email;

    /**
     * license
     */
    private String license;

    /**
     * license-url
     */
    private String licenseUrl;

    /**
     * api 分组
     */
    private Map<String, GroupedApiConfig> groupedApi;

    @Data
    public static class GroupedApiConfig {

        /**
         * 名称
         */
        private String group;

        /**
         * 路径
         */
        private String path;

    }

}
