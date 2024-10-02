package Configuration;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;

@Configuration()
public class WebConfig {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Bean
	@DependsOn(value = { "customRestTemplateCustomizer" })
	public RestTemplateBuilder restTemplateBuilder() {
		return new RestTemplateBuilder(customRestTemplateCustomizer());
	}

	@Bean
	public CustomRestTemplateCustomizer customRestTemplateCustomizer() {
		return new CustomRestTemplateCustomizer();
	}

	public class CustomRestTemplateCustomizer implements RestTemplateCustomizer {

		@Override
		public void customize(RestTemplate restTemplate) {
			restTemplate.getInterceptors().add(new CustomClientHttpRequestInterceptor());
		}

	}

	public class CustomClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {

		@Override
		public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
				throws IOException {

			logRequestDetails(request);
			return execution.execute(request, body);
		}

		private void logRequestDetails(HttpRequest request) {
			LOGGER.info("Headers: {}", request.getHeaders());
			LOGGER.info("Request Method: {}", request.getMethod());
			LOGGER.info("Request URI: {}", request.getURI());
		}

	}

}
