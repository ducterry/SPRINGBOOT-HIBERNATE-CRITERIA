package com.ndangducbn.hibernate.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .servers(Arrays.asList(
                        new Server().url("http://localhost:8080"),
                        new Server().url("https://ndangducbn.com")))
                .info(
                        new Info()
                                .title("Springboot - Hibernate")
                                .description("Springboot - Hibernate")
                                .contact(new Contact()
                                        .email("ndangducbn@gmail.com")
                                        .name("duc-terry")
                                        .url("https://ndangducbn.com"))
                                .license(new License()
                                        .name("Apache 2.0")
                                        .url("http://www.apache.org/licenses/LICENSE-2.0.html"))
                                .version("1.0.0"));
    }
}
