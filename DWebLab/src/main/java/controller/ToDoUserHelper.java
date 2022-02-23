/* 
* @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Feb 22, 2022
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ToDoUser;

/**
 * @author sunga
 *
 */
public class ToDoUserHelper {
	
	static EntityManagerFactory emfactory =
			Persistence.createEntityManagerFactory("DWebLab");
	
	public void insertToDoUser(ToDoUser s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ToDoUser> showAllToDoUsers() {
		EntityManager em = emfactory.createEntityManager();
		List<ToDoUser> allToDoUsers = em.createQuery("SELECT u FROM ToDoUser u").getResultList();
		return allToDoUsers;
	}
	
	public ToDoUser findToDoUser(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ToDoUser> typedQuery = em.createQuery("select us from ToDoUser us where us.ToDoUserName = :selectedName", ToDoUser.class);
		
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		ToDoUser foundToDoUser;
		
		try {
			foundToDoUser = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundToDoUser = new ToDoUser(nameToLookUp);
		}
		
		em.close();
		return foundToDoUser;
	}

}
