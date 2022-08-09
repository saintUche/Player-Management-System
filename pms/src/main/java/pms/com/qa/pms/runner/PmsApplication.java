package pms.com.qa.pms.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(value="pms.com.qa.pms.beans")
@ComponentScan(value="pms.com.qa.pms.controllers")
@EnableJpaRepositories(value="pms.com.qa.pms.repos")
@EntityScan(value="pms.com.qa.pms.models")
@SpringBootApplication
public class PmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PmsApplication.class, args);
	}

}
