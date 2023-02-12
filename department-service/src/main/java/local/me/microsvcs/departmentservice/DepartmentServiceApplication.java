package local.me.microsvcs.departmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import eu.techmoodivns.support.validation.ValidationConfiguration;

@SpringBootApplication
@Import({
	ValidationConfiguration.class
})
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}
}
