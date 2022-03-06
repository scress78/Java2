/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Feb 14, 2022
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author sunga
 *
 */
@Entity
@Table(name="todoitems")
public class ToDoItem {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	private String description;
	private String priority;
	private String complete;
	
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getComplete() {
		return complete;
	}
	public void setComplete(String complete) {
		this.complete = complete;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	
	public ToDoItem(int id, String description, String priority, String complete) {
		super();
		this.id = id;
		this.description = description;
		this.priority = priority;
		this.complete = complete;
	}
	
	public ToDoItem(String description, String priority, String complete) {
		super();
		this.description = description;
		this.priority = priority;
		this.complete = complete;
	}
	
	public ToDoItem() {
		super();
	}
	
	
	
	public String returnItemDetails() {
		return this.description + ":" + this.priority + ":" + this.complete;
		}
	
	
}