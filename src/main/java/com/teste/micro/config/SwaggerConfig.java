package com.teste.micro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig extends WebMvcConfigurationSupport {

  /** Build api docket. */
  @Bean
  public Docket apiDocket() {
    // @formatter:off
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.teste.micro"))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(apiInfo().build());
    // @formatter:on
  }

  /** Build ApiInfoBuilder. */
  private ApiInfoBuilder apiInfo() {
    // @formatter:off
    return new ApiInfoBuilder()
        .title("test")
        .version("1.0")
        .license("Licença - Open Source")
        .licenseUrl("http://www.dalvanbevilaqua.com.br");
    // @formatter:on
  }

  @Override
  protected void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry
        .addResourceHandler("swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/");
    registry
        .addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");
  }
}
