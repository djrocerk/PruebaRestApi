package com.example.pruebarestapi.swagger;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfig {

    private String url = "http://localhost:8081";

    @Bean
    public OpenAPI myOpenAPI() {
        Server server = new Server();
        server.setUrl(url);
        server.setDescription("Servicio de prueba");

        Contact contact = new Contact();
        contact.setEmail("ejemplo@gmail.com");
        contact.setName("Prueba");
        contact.setUrl(url);

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("API Prueba")
                .version("1.0")
                .contact(contact)
                .description("Esta API expone productos, clientes y facturas.")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(server));
    }
}
