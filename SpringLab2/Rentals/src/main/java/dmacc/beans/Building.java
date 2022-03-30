/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Mar 28, 2022
 */
package dmacc.beans;

import javax.persistence.Embeddable;

@Embeddable
public class Building {
	private String address;
	private String buildingNumber;
	private int apartmentCount;
	
	public String getAddress() {
		return address;
	}
	public Building() {
		super();
	}
	public Building(String address, String buildingNumber, int apartmentCount) {
		super();
		this.address = address;
		this.buildingNumber = buildingNumber;
		this.apartmentCount = apartmentCount;
	}
	@Override
	public String toString() {
		return "Building [address=" + address + ", buildingNumber=" + buildingNumber + ", apartmentCount="
				+ apartmentCount + "]";
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBuildingNumber() {
		return buildingNumber;
	}
	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}
	public int getApartmentCount() {
		return apartmentCount;
	}
	public void setApartmentCount(int apartmentCount) {
		this.apartmentCount = apartmentCount;
	}
	
	

}
