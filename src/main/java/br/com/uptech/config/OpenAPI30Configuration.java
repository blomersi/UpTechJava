package br.com.uptech.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPI30Configuration {

  @Value("${swagger.server.url}")
  private String serverUrl;

  @Bean
  public OpenAPI customizeOpenAPI() {
    return new OpenAPI()
        .addServersItem(new Server().url(serverUrl))
        .info(new Info()
            .title("UpTech Team")
            .description("This document detail methods of Uptech Team")
            .version("V1.0.0")
            .license(new License().name("Conquer Business School - All rights reserved")));
  }
}