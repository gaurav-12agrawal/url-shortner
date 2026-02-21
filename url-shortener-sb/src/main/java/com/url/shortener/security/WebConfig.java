package com.url.shortener.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${frontend.url}")
    String frontEndUrl;
    @Value("${chrome.extension.id}")
    String chromeExtensionId;
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String extensionOrigin = "chrome-extension://" + chromeExtensionId;
        registry.addMapping("/**")
                .allowedOrigins(
                        frontEndUrl,
                        extensionOrigin
                )
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}

