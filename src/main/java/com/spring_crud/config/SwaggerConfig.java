package com.spring_crud.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "SPLU Monitoring", version = "1.0.0"))
@SecurityScheme(type = SecuritySchemeType.APIKEY, name = "tokenAuth", in = SecuritySchemeIn.HEADER, paramName = "x-app-token")
public class SwaggerConfig {

}