package br.com.uptech.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Profile("!test")
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  private static final String[] SWAGGER_LIST = {
      "/team-api/api-docs/**",
      "/team-api/swag/**",
      "/team-api/swagger-ui/**",
      "/team-api/swagger-ui.html",
      "/team-api/swagger-ui/index.html",
  };

  @Bean
  protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .cors(Customizer.withDefaults())
        .csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(request -> request
            .requestMatchers(SWAGGER_LIST).authenticated()
            .requestMatchers("/actuator/*/*").permitAll()
            .requestMatchers("/team/**").authenticated()
            .anyRequest().authenticated()
        )
        .httpBasic(Customizer.withDefaults());
    return http.build();
  }
}
