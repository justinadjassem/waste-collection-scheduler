package com.wcs.waste_collection_scheduler.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name =  "ADJASSEM Yao-fiawomo Justin",
                        email = "justin.adjassem@gmail.com"
                ),
                description = "Documentation for waste collect app",
                title = "Waste Collection Scheduller",
                version = "1.0"
        ),
        servers = @Server(
                description = "Dev ENV",
                url = "http://localhost:8080"
        )
)
public class OpenApiConfig {
}
