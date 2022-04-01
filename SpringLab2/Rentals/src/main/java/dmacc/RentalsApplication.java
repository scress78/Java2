package dmacc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import dmacc.beans.Building;
import dmacc.beans.Development;
import dmacc.controller.BeanConfiguration;
import dmacc.repository.DevelopmentRepository;

@SpringBootApplication
public class RentalsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalsApplication.class, args);
	}
	
	
//	@Autowired
//	DevelopmentRepository repo;
//	
//	@Override
//	public void run(String... args) throws Exception{
//		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);\
//		
//		//Using an existing bean
//		Development c = appContext.getBean("contact", Development.class);
//		c.setAddress("New Set Address");
//		repo.save(c);
//		
//		//Creating a bean to use – not managed by Spring
//		Development d = new Development(3, "Sandra Boynton", "555-555-5557", "whatever");
//		Building a = new Building("123 Main Street", "Des Moines", 12);
//		d.setBuilding(a);
//		repo.save(d);
//		List<Development> allMyDevelopments = repo.findAll();
//		
//		for(Development people: allMyDevelopments) {
//		System.out.println(people.toString());
//		}
//		
//		((AbstractApplicationContext) appContext).close();
//
//		
//	}
	
	
	// possibly comment out
//	ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
//	
//	Development c = appContext.getBean("development", Development.class);
//	
//	System.out.println(c.toString());
	}
	

