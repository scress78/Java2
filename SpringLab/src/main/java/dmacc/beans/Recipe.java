/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Mar 5, 2022
 */
package dmacc.beans;

import javax.persistence.Embeddable;

/**
 * @author sunga
 *
 */


@Embeddable
public class Recipe {
	private String ingredients;
	private String prepTime;
	private int foodCost;
	
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public String getPrepTime() {
		return prepTime;
	}
	public void setPrepTime(String prepTime) {
		this.prepTime = prepTime;
	}
	public int getFoodCost() {
		return foodCost;
	}
	public void setFoodCost(int foodCost) {
		this.foodCost = foodCost;
	}
	public Recipe(String ingredients, String prepTime, int foodCost) {
		super();
		this.ingredients = ingredients;
		this.prepTime = prepTime;
		this.foodCost = foodCost;
	}
	
	public Recipe() {
		super();
	}
	@Override
	public String toString() {
		return "Recipe [ingredients=" + ingredients + ", prepTime=" + prepTime + ", foodCost=" + foodCost + "]";
	}
}
