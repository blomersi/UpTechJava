package br.com.uptech.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  public static final int MAX_AGE = 3600;

  private static final String[] ALLOWED_ORIGINS = {
      "http://localhost:3000",
      "http://localhost:8888",
      "https://uptech-admin-homolog.escolaconquer.com.br",
      "https://uptech-admin.escolaconquer.com.br",
      "https://uptech.conqueronline.com.br",
      "https://uptech.homolog.escolaconquer.com.br"
  };

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
        .allowedOrigins(ALLOWED_ORIGINS)
        .allowedHeaders("*")
        .allowCredentials(true)
        .maxAge(MAX_AGE);
  }

}
