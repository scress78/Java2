/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Mar 27, 2022
 */
package dmacc.controller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Development;

@Configuration
public class BeanConfiguration {
	@Bean
	public Development development() {
		Development bean = new Development();
		return bean;
	}
}
