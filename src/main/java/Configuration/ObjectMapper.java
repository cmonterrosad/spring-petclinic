package Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ObjectMapper {

	@Bean
	@Primary
	public ObjectMapper objectMapper() {
		final ObjectMapper mapper = new ObjectMapper();
		return mapper;
	}

}
