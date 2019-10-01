# Microservice-Demo

Swagger Configuration:

Dependency:
```
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.9.2</version>
</dependency>

To use Swagger UI, one additional Maven dependency is required:

dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.9.2</version>
</dependency>

The configuration of Swagger mainly centers around the Docket bean.

@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
}
```


Exposes swagger documentation on:(API returns Json string)
http://localhost:8991/v2/api-docs

Exposes swagger UI on:
http://localhost:8991/swagger-ui.html

----------------------------------------------------------------------------------------------------------------------------------------
