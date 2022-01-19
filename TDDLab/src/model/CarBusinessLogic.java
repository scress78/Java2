/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Jan 17, 2022
 */
package model;

public class CarBusinessLogic {
	
	public double calculateValueNextYear(Car car) {
		double carValue = car.getValue();
		return carValue * 0.9;
	}
	
	public double calculateValueNewTires(Car car) {
		double carValue = car.getValue();
		return carValue + 500;
	}
	
	public Boolean calculateCarIsScrapped(Car car) {
		double carValue = car.getValue();
		if(carValue <= 300) {
			return true;
		} else {return false;}
	}

}
