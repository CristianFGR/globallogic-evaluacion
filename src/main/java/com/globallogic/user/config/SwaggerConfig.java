package com.globallogic.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * Created by cgonroja on 13-02-20.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String PACKAGE_CONTROLLER = "com.globallogic.user.controller";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .globalResponseMessage(RequestMethod.POST, new ArrayList<>())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage(PACKAGE_CONTROLLER))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contacto = new Contact("Globallogic", "", "soporte@globallogic.com");
        return new ApiInfo("Microservices RestFull Add Users", "MicroServicio que implementa " +
                "creacion de usuarios con spring boot ",
                "1.0.0", "GlobalLogic", contacto, "Apache",
                "http://www.globallogic.com.", new ArrayList<VendorExtension>());
    }

}
