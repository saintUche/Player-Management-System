package pms.com.qa.pms.beans;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class beans {

    @Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}

	
    
}
