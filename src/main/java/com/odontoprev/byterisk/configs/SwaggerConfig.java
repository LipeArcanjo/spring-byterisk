package com.odontoprev.byterisk.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuração para o Swagger/OpenAPI.
 * Define as informações da API ByteRisk, como título, versão e licença.
 */
@Configuration
public class SwaggerConfig {

    /**
     * Define a configuração personalizada do OpenAPI para a documentação da API.
     *
     * @return objeto OpenAPI com as informações configuradas da API
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("ByteRisk API")
                        .version("1.0")
                        .description("API para a aplicação ByteRisk da OdontoPrev, focado em redução de sinistros odontológicos.")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}

