/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Mar 27, 2022
 */
package dmacc.beans;

/**
 * @author sunga
 *
 */
public class Development {
	private long id;
	private String name;
	private String address;
	private String buildingCount;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBuildingCount() {
		return buildingCount;
	}
	public Development() {
		super();
	}
	public void setBuildingCount(String buildingCount) {
		this.buildingCount = buildingCount;
	}
	public Development(long id, String name, String address, String buildingCount) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.buildingCount = buildingCount;
	}
	@Override
	public String toString() {
		return "Development [id=" + id + ", name=" + name + ", address=" + address + ", buildingCount=" + buildingCount
				+ "]";
	}
	

}
