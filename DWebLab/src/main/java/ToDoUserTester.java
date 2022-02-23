/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Feb 22, 2022
 */

import java.util.List;

import controller.ToDoUserHelper;
import model.ToDoUser;



public class ToDoUserTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ToDoUser bill = new ToDoUser("Bill");
		ToDoUser jim = new ToDoUser("Jim");
		ToDoUserHelper sh = new ToDoUserHelper();
		sh.insertToDoUser(bill);
		sh.insertToDoUser(jim);
		
		List<ToDoUser> allToDoUsers = sh.showAllToDoUsers();
		for(ToDoUser a: allToDoUsers) {
			System.out.println(a.toString());
		}

	}

}
