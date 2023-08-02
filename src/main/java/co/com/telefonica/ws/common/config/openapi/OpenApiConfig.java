package co.com.telefonica.ws.common.config.openapi;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Value("${springdoc.openapi.host-port}")
    private String hostPort;

    private final OpenApiParams openApiParams;

    @Autowired
    public OpenApiConfig(OpenApiParams openApiParams) {
        this.openApiParams = openApiParams;
    }

    @Bean
    public OpenAPI myOpenAPI() {

        var devServer = new Server();
        devServer.setUrl(hostPort);
        devServer.setDescription(this.openApiParams.getProjectShortDescription());

        var contact = new Contact();
        contact.setEmail(this.openApiParams.getDeveloperMail());
        contact.setName(this.openApiParams.getDeveloperName());
        contact.setUrl(this.openApiParams.getOrganizationUrl());

        var mitLicense = new License()
                .name("MIT License")
                .url(this.openApiParams.getProjectLicenceLink());

        var info = new Info()
                .title(this.openApiParams.getProjectName())
                .version("1.0")
                .contact(contact)
                .description(this.openApiParams.getProjectShortDescription())
                .termsOfService(this.openApiParams.getProjectLicenceMsg())
                .license(mitLicense);

        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer))
                .components(new Components());
    }

}
