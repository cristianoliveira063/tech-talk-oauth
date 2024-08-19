package br.com.quote.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ResourceServerConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authz -> authz.requestMatchers("/oauth2/**").permitAll()
                        .anyRequest().authenticated())
                .oauth2ResourceServer(
                        oauth2ResourceServer ->
                                oauth2ResourceServer
                                        .opaqueToken(opaqueToken ->
                                                opaqueToken.introspectionUri("http://localhost:9000/oauth2/introspect")
                                                        .introspectionClientCredentials("quote-api", "secret123")
                                        ));
        return http.build();
    }

}


