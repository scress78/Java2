/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Jan 23, 2022
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Concept;




/**
 * @author sunga
 *
 */
public class ConceptHelper {
	static EntityManagerFactory emfactory =
			Persistence.createEntityManagerFactory("ProgrammingConcepts");
	
	public void insertItem(Concept li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Concept> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		List<Concept> allItems = em.createQuery(
				"SELECT i FROM Concept i").getResultList();
		return allItems;
	}
	
	public void deleteItem(Concept toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Concept>typedQuery = em.createQuery(
				"select li from Concept li where li.conceptName = :selectedConcept and li.language = :selectedLanguage", Concept.class);
		
		//substitute parameter with actual data from toDelete
		typedQuery.setParameter("selectedConcept", toDelete.getConceptName());
		typedQuery.setParameter("selectedLanguage", toDelete.getLanguage());
		
		// limit to one result
		typedQuery.setMaxResults(1);
		
		//get the result, save to new list item
		Concept result = typedQuery.getSingleResult();
		
		//remove result
		em.remove(result);
		em.getTransaction().commit(); // commit and close
		em.close();
	}
	
	
	public Concept searchForConceptById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Concept found = em.find(Concept.class, idToEdit);
		em.close();
		return found;
	}
	
	public List<Concept> searchforItemByConcept(String conceptName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Concept>typedQuery = em.createQuery(
				"select li from Concept li where li.conceptName = :selectedConcept", Concept.class);
		typedQuery.setParameter("selectedConcept", conceptName);
		
		List<Concept> foundItems = typedQuery.getResultList();
		em.close();
		
		return foundItems;
	}
	
	public void updateItem(Concept toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}
	

	public void cleanUp() {
		emfactory.close();
	}
}