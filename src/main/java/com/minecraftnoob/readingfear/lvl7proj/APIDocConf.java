package com.minecraftnoob.readingfear.lvl7proj;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class APIDocConf {
	@Bean
	Docket API() {
		return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build().apiInfo(new ApiInfo("Level7-Project", "My Level 7 project", "0.0.1", null, null, null, null, Collections.emptyList()));
	}
}