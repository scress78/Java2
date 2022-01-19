/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Jan 17, 2022
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Car;
import model.CarBusinessLogic;


public class TestCarLogic {

	/**
	 * @throws java.lang.Exception
	 */
	CarBusinessLogic carBL = new CarBusinessLogic();
	Car car = new Car("Deville", 2002, 3000);
	Car badCar = new Car("Alero", 1999, 300);
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCalculateValueNewTires() {
		double newValue = carBL.calculateValueNewTires(car);
		assertEquals(3500, newValue, 0);
	}
	
	
	@Test
	public void testCalculateValueNextYear() {
		double newValue = carBL.calculateValueNextYear(car);
		assertEquals(2700, newValue, 0);
	}
	
	@Test
	public void testCarIsScrappedFalse() {
		boolean Scrapped = carBL.calculateCarIsScrapped(car);
		assertFalse(Scrapped);
	}
	
	@Test
	public void testCarIsScrappedTrue() {
		boolean Scrapped = carBL.calculateCarIsScrapped(badCar);
		assertTrue(Scrapped);
	}

}
