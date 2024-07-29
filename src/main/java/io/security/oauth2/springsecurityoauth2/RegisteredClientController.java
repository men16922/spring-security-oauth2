package io.security.oauth2.springsecurityoauth2;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RegisteredClientController {

    private final RegisteredClientRepository registeredClientRepository;

    @GetMapping("/registeredClients")
    public List<RegisteredClient> registeredClients(){

        RegisteredClient registeredClient1 = registeredClientRepository.findByClientId("oauth2-client-app1");
        RegisteredClient registeredClient2 = registeredClientRepository.findByClientId("oauth2-client-app2");
        RegisteredClient registeredClient3 = registeredClientRepository.findByClientId("oauth2-client-app3");

        return Arrays.asList(registeredClient1,registeredClient2, registeredClient3);
    }
}