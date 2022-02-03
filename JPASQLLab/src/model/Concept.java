/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Jan 23, 2022
 */
//this program will aim to be quick reference for programming concepts
// i.e. how do we cast a string to lower case in JS?
// conceptName = lowercase, language = JS, description = myString.toLowerCase() // OR a link to .txt file with instructions

package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
// double, NOT single quotes
@Table(name="concepttable")


public class Concept {
	@Id
	@GeneratedValue
	@Column(name="ID")
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
	
	
	public Concept(int id, String conceptName, String language, String description) {
		super();
		this.id = id;
		this.conceptName = conceptName;
		this.language = language;
		this.description = description;
	}
	
	
	
	public Concept(String conceptName, String language, String description) {
		super();
		this.conceptName = conceptName;
		this.language = language;
		this.description = description;
	}
	
	
	public Concept(String conceptName, String language) {
		super();
		this.conceptName = conceptName;
		this.language = language;
	}
	
	
	public Concept() {
		super();
	}
	
	
	public String returnConceptDetails() {
		return this.conceptName + " : " + this.language + " : " + this.description;
	}
}
