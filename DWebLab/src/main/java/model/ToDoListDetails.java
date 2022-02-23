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
	
	//private LocalDate tripDate; // don't mess with datetime yet.
	// can be used for things like complete, or complete by etc. Re-write, constructor, get/set/
	
	//  OTM types. Match classes ToDoItem and ToDoUser
	@ManyToOne(cascade=CascadeType.PERSIST)
	private ToDoUser ToDoUser;
	
	//@JoinTable
	// Merge used below
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private List<ToDoItem> listOfToDoItems;
	
	
	public ToDoListDetails(int id, String listName, ToDoUser ToDoUser, List<ToDoItem> listOfToDoItems) {
		this.id = id;
		this.listName = listName;
		this.ToDoUser = ToDoUser;
		this.listOfToDoItems = listOfToDoItems;
	}
	
		
	public ToDoListDetails(String listName, ToDoUser ToDoUser, List<ToDoItem> listOfToDoItems) {
		this.listName = listName;
		this.ToDoUser = ToDoUser;
		this.listOfToDoItems = listOfToDoItems;
	}
	
	public ToDoListDetails(String listName, ToDoUser ToDoUser) {
		this.listName = listName;
		this.ToDoUser = ToDoUser;
	}
	
	
	@Override
	public String toString() {
		return "ToDoListDetails [id=" + id + ", listName=" + listName + ", ToDoUser=" + ToDoUser
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
		return ToDoUser;
	}
	public void setToDoUser(ToDoUser ToDoUser) {
		this.ToDoUser = ToDoUser;
	}
	public List<ToDoItem> getlistOfToDoItems() {
		return listOfToDoItems;
	}
	public void setlistOfToDoItems(List<ToDoItem> listOfToDoItems) {
		this.listOfToDoItems = listOfToDoItems;
	}

}
