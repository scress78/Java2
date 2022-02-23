/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Feb 23, 2022
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ToDoListDetails;

public class ToDoListDetailsHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("DWebLab");
	
	public void insertNewListDetails(ToDoListDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ToDoListDetails> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<ToDoListDetails> allDetails = em.createQuery("SELECT d FROM ToDoListDetails d").getResultList();
		return allDetails;
	}
	
	public void deleteList(ToDoListDetails toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ToDoListDetails> typedQuery = em.createQuery("select detail from ToDoListDetails detail where detail.id = :selectedId", ToDoListDetails.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", toDelete.getId());
		// we only want one result
		typedQuery.setMaxResults(1);
		// get the result and save it into a new list item
		ToDoListDetails result = typedQuery.getSingleResult();
		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public ToDoListDetails searchForListDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ToDoListDetails found = em.find(ToDoListDetails.class, tempId);
		em.close();
		return found;
		}
	
	public void updateList(ToDoListDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		}

}
