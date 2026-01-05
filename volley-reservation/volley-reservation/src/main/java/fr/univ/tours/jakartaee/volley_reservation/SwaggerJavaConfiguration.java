package fr.univ.tours.jakartaee.volley_reservation;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConditionalOnProperty(name = "swagger.dynamic.config.mode", havingValue = "java")
public class SwaggerJavaConfiguration {

    @Bean
    public OpenAPI initOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Réservation salle de volley")
                        .description("Génération automatique Swagger pour le projet de réservation de salle de volley")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Delicia Maleka")
                                .email("deliciacollaborations@gmail.com"))
                )
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080/")
                                .description("Serveur local")
                ))
                .components(new Components()
                        .addSecuritySchemes("basicAuth",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("basic"))
                );
    }
}
