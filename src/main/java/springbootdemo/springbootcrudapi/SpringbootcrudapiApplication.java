package springbootdemo.springbootcrudapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath*:application-context.xml"})
public class SpringbootcrudapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootcrudapiApplication.class, args);
	}

}
