/* 
* @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Feb 22, 2022
 */
package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author sunga
 *
 */

@Entity
public class ToDoListDetails {
	
	@Id
	@GeneratedValue
	private int id; // select explanatory
	private String listName; // Kind of a placeholder. Name of specific To-Do-List
	
	
	//  OTM types. Match classes ToDoItem and ToDoUser
	@ManyToOne(cascade=CascadeType.PERSIST)
	private ToDoUser toDoUser;
	
	//@JoinTable
	// Merge used below // always RETURN HERE AND CHECK MERGE VS PERSIST!
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<ToDoItem> listOfToDoItems;
	
	
	public ToDoListDetails(int id, String listName, ToDoUser toDoUser, List<ToDoItem> listOfToDoItems) {
		this.id = id;
		this.listName = listName;
		this.toDoUser = toDoUser;
		this.listOfToDoItems = listOfToDoItems;
	}
	
		
	public ToDoListDetails(String listName, ToDoUser toDoUser, List<ToDoItem> listOfToDoItems) {
		this.listName = listName;
		this.toDoUser = toDoUser;
		this.listOfToDoItems = listOfToDoItems;
	}
	
	public ToDoListDetails(String listName, ToDoUser toDoUser) {
		this.listName = listName;
		this.toDoUser = toDoUser;
	}
	
	
	@Override
	public String toString() {
		return "ToDoListDetails [id=" + id + ", listName=" + listName + ", ToDoUser=" + toDoUser
				+ ", listOfToDoItems=" + listOfToDoItems + "]";
	}
	
	public ToDoListDetails() {
		super();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	
	public ToDoUser getToDoUser() {
		return toDoUser;
	}
	public void setToDoUser(ToDoUser ToDoUser) {
		this.toDoUser = ToDoUser;
	}
	public List<ToDoItem> getlistOfToDoItems() {
		return listOfToDoItems;
	}
	
	// there is a capitalization error here, it's risky to track it way down. Note anyway!
	public void setlistOfToDoItems(List<ToDoItem> listOfToDoItems) {
		this.listOfToDoItems = listOfToDoItems;
	}

}
