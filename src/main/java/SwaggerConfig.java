import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.annotations.Contact;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//Docket is present in springfox
// Swagger is used for documentation , http://localhost:8080/v2/api-docs -  this will give us diff diff parameter
// most imp parameter are 1- paths (all the resource we are exposing and diff operations which can be performed on these 
//resources and inside path all details are metions what api is prodicing which type and which type is consuming and also what are diff repsonses service can give
//2- definition(it includes diff elements used in our api ,example what does user contians, what type of fields are available 3- info (contains documenation of api, terms 
// and services , title), license))
// If we want to document produce and consume then we need to use method .produce and .consume on docket
// If we want to give documentation about model class (user in this example) we need to use api @ApiModel(description = "all deatils we want to give")
@Configuration
@EnableSwagger2
public class SwaggerConfig {
		
//	public static final Contact DEFAULT_CONTACT = new Contact("piyush", "wwwI.in28.com", "piyush2ot@gmal.com");
//	
//	  public static final ApiInfo DEFAULT_API_INFO  = new ApiInfo(
//			  "Awsum API Documentation", "AWSUM Api Documentation", "1.0",
//			  "urn:tos",
//	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
//
//	@Bean
//	public Docket api(){
//		return new Docket(DocumentationType.SWAGGER_2)
//				.apiInfo(DEFAULT_API_INFO);
//	
//	}

}
