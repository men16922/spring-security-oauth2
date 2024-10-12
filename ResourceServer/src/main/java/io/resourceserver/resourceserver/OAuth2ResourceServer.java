package io.resourceserver.resourceserver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class OAuth2ResourceServer {

    @Bean
    SecurityFilterChain securityFilterChain1(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests(
                (requests) -> requests
                        .antMatchers("/photos","/remotePhotos","/myInfo").access("hasAuthority('SCOPE_photo')")
                        .anyRequest().authenticated());
//        http.oauth2ResourceServer().jwt();
        http.cors().disable();
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://127.0.0.1:8081/");
//        configuration.addAllowedOrigin("*"); // 모든 오리진 허용, 필요한 경우 특정 도메인으로 변경
        configuration.addAllowedMethod("*"); // 모든 HTTP 메소드 허용
        configuration.addAllowedHeader("*"); // 모든 헤더 허용
        configuration.setAllowCredentials(true); // 자격 증명 허용
        configuration.setMaxAge(3600L); // CORS 프리플라이트 응답 캐시 시간 설정

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // 모든 엔드포인트에 적용

        return source;

    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
