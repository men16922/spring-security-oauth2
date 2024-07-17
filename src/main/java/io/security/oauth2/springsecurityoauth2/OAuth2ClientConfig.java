package io.security.oauth2.springsecurityoauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestResolver;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class OAuth2ClientConfig {

   @Bean
   SecurityFilterChain oauth2SecurityFilterChain(HttpSecurity http) throws Exception {
      http.authorizeRequests((requests) -> requests.antMatchers("/home", "/client","/favicon.ico", "/error").permitAll()
              .anyRequest().authenticated());
      http.oauth2Client(Customizer.withDefaults());
      http.logout().logoutSuccessUrl("/home");
      return http.build();
   }
}