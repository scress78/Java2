/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Jan 17, 2022
 */
package model;


public class Car {
	private String carModel;
	private double value;
	private int year;
	
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public Car(String carModel, int year, double value) {
		super();
		this.carModel = carModel;
		this.year = year;
		this.value = value;
		
	}
	
	public Car(String carModel, int year) {
		super();
		this.carModel = "";
		this.year = 0;
		this.value = 300;
	}
	
	
	

}
