package com.fkq.common.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 *服务器路径配置
 */
@Component
@ConfigurationProperties(prefix = "service-path")
@PropertySource(value = "classpath:application.properties")
public class ServerSetting {

    private String apk;

    private String image;

    public void setApk(String apk) {
        this.apk = apk;
    }

    public String getApk() {
        return apk;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }
}
