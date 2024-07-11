package com.synchrony.codechallenge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.authentication.RedirectServerAuthenticationSuccessHandler;
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.server.WebSessionServerOAuth2AuthorizedClientRepository;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    // Method that returns a SecurityWebFilterChain object, which is used to configure the web security for a reactive application.
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http, ClientRegistrationRepository clientRegistrationRepository) { // A parameter that provides the repository
        // for OAuth2 client registrations.

        http
                .authorizeExchange(authorizeExchangeSpec -> authorizeExchangeSpec // Configures authorization rules for HTTP requests.
                        .anyExchange().authenticated() // ensures that any exchange (request) must be authenticated.
                )
                .oauth2Login(oauth2 -> oauth2 // Configures OAuth2 login
                        .clientRegistrationRepository((ReactiveClientRegistrationRepository) clientRegistrationRepository) // Sets the client registration repository,
                                // cast to ReactiveClientRegistrationRepository.
                        .authorizedClientRepository(authorizedClientRepository()) // Sets the authorized client repository to manage OAuth2 clients.
                        .authenticationSuccessHandler(new RedirectServerAuthenticationSuccessHandler("{baseUrl}/loginSuccess")) // Sets the authentication success handler to redirect
                        // users upon successful authentication.
                ); // Use withDefaults() for default configuration
        return http.build(); // Builds the SecurityWebFilterChain object.
    }

    @Bean // method produces a bean to be managed by the Spring container.

    // Method that returns a ClientRegistrationRepository object.
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(this.imgurClientRegistration()); // Creates an in-memory client registration repository with the Imgur client registration.
    }
    // Private method that returns a ClientRegistration object for the Imgur OAuth2 client.
    private ClientRegistration imgurClientRegistration() {
        return ClientRegistration.withRegistrationId("imgur") // Starts building a new ClientRegistration with the registration ID imgur.
                .clientId("0015c0fb47cb4c5") // Sets the client ID.
                .clientSecret("9c81a36140243776be73c8491b30f33220f2074f") // Sets the client secret.
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC) // Sets the client authentication method to CLIENT_SECRET_BASIC.
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE) // Sets the authorization grant type to AUTHORIZATION_CODE.
                .redirectUri("{baseUrl}/login/oauth2/code/imgur") // Sets the redirect URI template.
                .scope("read", "write") // Sets the requested scopes.
                .authorizationUri("https://api.imgur.com/oauth2/authorize") //
                .tokenUri("https://api.imgur.com/oauth2/token") // Sets the user info URI.

                .userInfoUri("https://api.imgur.com/3/account/me") // Sets the user info URI.
                .userNameAttributeName("id") // Sets the attribute name to extract the username.
                .clientName("Imgur") // Sets the client name.
                .build(); // Builds the ClientRegistration object.
    }

    @Bean
    // Method that creates a new WebSessionServerOAuth2AuthorizedClientRepository to manage OAuth2 clients using web sessions.
    public ServerOAuth2AuthorizedClientRepository authorizedClientRepository() {
        return new WebSessionServerOAuth2AuthorizedClientRepository();
    }

    @Bean
    // Method that creates a new BCryptPasswordEncoder, which is a password hashing implementation using the bcrypt algorithm.
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

