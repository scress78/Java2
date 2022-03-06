package dmacc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import dmacc.beans.MenuItem;
import dmacc.beans.Recipe;
import dmacc.controller.BeanConfiguration;
import dmacc.repository.MenuItemRepository;


@SpringBootApplication
public class SpringLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLabApplication.class, args);
//	ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
//	MenuItem c = appContext.getBean("menuitem", MenuItem.class);
//	System.out.println(c.toString());
	}
	
	@Autowired
	MenuItemRepository repo;
	
	//@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		
		//Using an existing bean
		MenuItem c = appContext.getBean("Large Pepperoni Pizza", MenuItem.class);
		c.setSpiciness(4);
		repo.save(c);
		
		//Create a bean to use - not managed by Spring
		//Name, int Spiciness, long price
		MenuItem d = new MenuItem("Jalapeno Popper", 5, 4);
		//Ingredients, preptime, int FoodCost
		Recipe a = new Recipe("Jalapenos, Cream Cheese", "3 Minutes", 1);
		d.setRecipe(a);
		repo.save(d);
		
		List<MenuItem> allMyMenuItems = repo.findAll();
		for(MenuItem item: allMyMenuItems) {
			System.out.println(item.toString());
		}
		
		//closes the ApplicationContext resource leak - not imperative to add but nice to clean it up
		((AbstractApplicationContext) appContext).close();
	
	}
	
	
}
