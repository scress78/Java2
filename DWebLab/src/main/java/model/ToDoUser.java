/*
* @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Feb 22, 2022
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="todouser")
public class ToDoUser {
	@Id
	@GeneratedValue
	private int id;
	private String userName;
	public ToDoUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ToDoUser(int id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}

	public ToDoUser(String userName) {
		super();
		this.userName = userName;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return "ToDoUser [id=" + id + ", userName=" + userName + "]";
	}
}

