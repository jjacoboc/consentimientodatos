package pe.sura.api.consentimientodatos.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket produceApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("pe.sura.api.consentimientodatos")).paths(paths())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Microservicio del Dominio Consentimientodatos")
				.description("Esta página lista todos los servicios Rest expuestos para el dominio Consentimientodatos")
				.version("1.0").build();
	}

	private Predicate<String> paths() {
		return Predicates.and(PathSelectors.regex("/api.*"), Predicates.not(PathSelectors.regex("/error.*")));
	}

}
