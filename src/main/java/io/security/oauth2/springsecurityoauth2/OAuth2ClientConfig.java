package io.security.oauth2.springsecurityoauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ClientRegistrations;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;

@Configuration
public class OAuth2ClientConfig {

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(keycloakClientRegistration());
    }

    private ClientRegistration keycloakClientRegistration() {

        return ClientRegistrations.fromIssuerLocation("http://localhost:8080/realms/oauth2")
                .registrationId("keycloak")
                .clientId("oauth2-client-app")
                .clientSecret("CsJlVOw2en5hjFaIHeJYAbL3KTJGmKRf")
                .redirectUri("http://localhost:8081/login/oauth2/code/keycloak")
                .build();

//        return ClientRegistration.withRegistrationId("keycloak")
//                .clientId("oauth2-client-app")
//                .clientSecret("CsJlVOw2en5hjFaIHeJYAbL3KTJGmKRf")
//                .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
//                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//                .redirectUriTemplate("{baseUrl}/login/oauth2/code/{registrationId}")
//                .scope("openid", "profile", "email", "address", "phone")
//                .authorizationUri("http://localhost:8080/realms/oauth2")
//                .tokenUri("http://localhost:8080/realms/oauth2/token")
//                .userInfoUri("http://localhost:8080/realms/oauth2/userinfo")
//                .userNameAttributeName(IdTokenClaimNames.SUB)
//                .jwkSetUri("http://localhost:8080/realms/oauth2/certs")
//                .clientName("Keycloak")
//                .build();
    }
}
