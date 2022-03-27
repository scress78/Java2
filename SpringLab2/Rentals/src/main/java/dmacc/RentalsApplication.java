package dmacc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dmacc.beans.Development;
import dmacc.controller.BeanConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class RentalsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalsApplication.class, args);
	
	
	ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
	Development c = appContext.getBean("development", Development.class);
	System.out.println(c.toString());
	}
	

}
