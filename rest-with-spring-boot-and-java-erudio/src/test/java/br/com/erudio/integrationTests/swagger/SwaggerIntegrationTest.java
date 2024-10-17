package br.com.erudio.integrationTests.swagger;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

import br.com.erudio.integrationTests.testcontainer.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.erudio.configs.TestConfigs;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SwaggerIntegrationTest extends AbstractIntegrationTest {

	@Test
	public void shouldDisplaySwaggerUiPage() {
		var content =
			given()
				.basePath("/swagger-ui/index.html")
				.port(8080) // verificar erro posteriormente... Instrutor passou TestConfigs.SERVER_PORT, definida como 8888, porem a aplicação está subindo em 8080
				.when()
					.get()
				.then()
					.statusCode(200)
				.extract()
					.body()
						.asString();
		assertTrue(content.contains("Swagger UI"));
	}

}
