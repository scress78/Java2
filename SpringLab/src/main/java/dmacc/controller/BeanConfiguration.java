/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Mar 5, 2022
 */
package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import dmacc.beans.MenuItem;
import dmacc.beans.Recipe;
/**
 * @author sunga
 *
 */
@Configuration
public class BeanConfiguration {
	
	@Bean
	public MenuItem menuitem() {
		MenuItem bean = new MenuItem();
		bean.setName("Large Pepperoni Pizza");
		bean.setPrice(15);
		bean.setSpiciness(3);
		return bean;
	}
	
	@Bean
	public Recipe recipe() {
		Recipe bean = new Recipe("Pepperoni, Dough, Cheese", "15 Minutes", 4);
		return bean;
	}

}
