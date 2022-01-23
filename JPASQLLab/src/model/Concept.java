/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Jan 23, 2022
 */
package model;

//this program will aim to be quick reference for programming concepts
// i.e. how do we cast a string to lower case in JS?
// conceptName = lowercase, language = JS, description = myString.toLowerCase()
public class Concept {
	private int id;
	private String conceptName;
	private String language;
	private String description;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getConceptName() {
		return conceptName;
	}
	public void setConceptName(String conceptName) {
		this.conceptName = conceptName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Concept() {
		
	}
	
	/*
	public ListConcept(String conceptName, String language, String description) {
		this.conceptName = conceptName;
		this.language = language;
		this.description = description;
	}
	*/
	
	public String returnConceptDetails() {
		return this.conceptName + ":" +this.language;
	}
}
