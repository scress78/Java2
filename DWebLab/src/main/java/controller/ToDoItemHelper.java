 /* @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Feb 13, 2022
 */

package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ToDoItem;


public class ToDoItemHelper {
	
	static EntityManagerFactory emfactory =
			Persistence.createEntityManagerFactory("DWebLab");

	public void insertItem(ToDoItem li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ToDoItem> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		List<ToDoItem> allItems = em.createQuery(
				"SELECT i FROM ToDoItem i").getResultList();
		return allItems;
	}
	
	public void deleteItem(ToDoItem toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ToDoItem>typedQuery = em.createQuery(
				"select li from ToDoItem li where li.description = :selectedDescription and li.priority = :selectedPriority", ToDoItem.class);
		
		//substitute parameter with actual data from toDelete
		typedQuery.setParameter("selectedDescription", toDelete.getDescription());
		typedQuery.setParameter("selectedPriority", toDelete.getPriority());
		
		// limit to one result
		typedQuery.setMaxResults(1);
		
		//get the result, save to new list item
		ToDoItem result = typedQuery.getSingleResult();
		
		//remove result
		em.remove(result);
		em.getTransaction().commit(); // commit and close
		em.close();
	}

	/**
	 * @param idToEdit
	 * @return
	 */
	public ToDoItem searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ToDoItem found = em.find(ToDoItem.class, idToEdit);
		em.close();
		return found;
	}

	/**
	 * @param toEdit
	 */
	public void updateItem(ToDoItem toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}

	/**
	 * @param storeName
	 * @return
	 */
	public List<ToDoItem> searchforItemByDescription(String description) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ToDoItem>typedQuery = em.createQuery(
				"select li from ToDoItem li where li.description = :selectedDescription", ToDoItem.class);
		typedQuery.setParameter("selectedDescription", description);
		
		List<ToDoItem> foundItems = typedQuery.getResultList();
		em.close();
		
		return foundItems;
	}

	/**
	 * @param itemName
	 * @return
	 */
	public List<ToDoItem> searchForItemByPriority(String priority) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ToDoItem>typedQuery = em.createQuery(
				"select li from ToDoItem li where li.priority = :selectedPriority", ToDoItem.class);
		typedQuery.setParameter("selectedPriority", priority);
		
		List<ToDoItem> foundItems = typedQuery.getResultList();
		em.close();
		
		return foundItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
	
	
}
