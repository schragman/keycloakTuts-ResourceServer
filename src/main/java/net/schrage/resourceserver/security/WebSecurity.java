package net.schrage.resourceserver.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class WebSecurity {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests((authz) -> authz
            .requestMatchers(HttpMethod.GET, "/users/status/check").hasAuthority("SCOPE_profile")
            .anyRequest().authenticated()
        )
        .oauth2ResourceServer()
        .jwt();
    return http.build();
  }

}
