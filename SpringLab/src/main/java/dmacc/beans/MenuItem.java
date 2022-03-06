/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Mar 5, 2022
 */
package dmacc.beans;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sunga
 *
 */


@Entity
public class MenuItem {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private int spiciness;
	private long price;
	@Autowired
	private Recipe recipe;
	
	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public MenuItem() {
		super();
		this.spiciness = 1;
	}
	
	public MenuItem(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", name=" + name + ", spiciness=" + spiciness + ", price=" + price + "]";
	}

	public MenuItem(String name, int spiciness, long price) {
		super();
		this.name = name;
		this.spiciness = spiciness;
		this.price = price;
	}
	
	public MenuItem(long id, String name, int spiciness, long price) {
		super();
		this.id = id;
		this.name = name;
		this.spiciness = spiciness;
		this.price = price;
	}
	
	public MenuItem(long id, String name, int spiciness, long price, Recipe recipe) {
		super();
		this.id = id;
		this.name = name;
		this.spiciness = spiciness;
		this.price = price;
		this.recipe = recipe;
	}
	
	
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
	public int getSpiciness() {
		return spiciness;
	}
	public void setSpiciness(int spiciness) {
		this.spiciness = spiciness;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}

}
