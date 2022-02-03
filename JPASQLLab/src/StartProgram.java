

/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Jan 23, 2022
 */

import java.util.List;
import java.util.Scanner;
import java.awt.Desktop;
import java.io.*;

import controller.ConceptHelper;
import model.Concept;



public class StartProgram {

		// TODO Auto-generated method stub
		static Scanner in = new Scanner(System.in);
		static ConceptHelper lih = new ConceptHelper();
		
		
		public static void addAnItem(){
			System.out.print("Enter a programming concept: ");
			String concept = in.nextLine();
			System.out.print("Enter a language: ");
			String language = in.nextLine();
			System.out.print("Enter a description of the syntax for this language: ");
			String description = in.nextLine();
			
			// lih is a ConceptHelper.. therefore this becomes an EMF??
			Concept toAdd = new Concept(concept, language, description);
			// put item into database
			lih.insertItem(toAdd);
		}
		
		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the concept to delete: ");
			String concept = in.nextLine();
			System.out.print("Enter the language to delete: ");
			String language = in.nextLine();
			
			Concept toDelete = new Concept(concept, language);
			lih.deleteItem(toDelete);
		}
		
		private static void editAnItem() {
			// TODO Auto-generated method stub
		
			List<Concept> foundItems = null;
			
			System.out.print("Enter the concept name: ");
			String conceptName = in.nextLine();
			foundItems = lih.searchforItemByConcept(conceptName);
				
			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (Concept l : foundItems) {
					System.out.println(l.getId() + " : " + l.getConceptName() + " : " + l.getLanguage());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();
				Concept toEdit = lih.searchForConceptById(idToEdit);
				System.out.println("Retrieved " + toEdit.getConceptName() + " from " + toEdit.getLanguage());
				System.out.println("1 : Update Concept");
				System.out.println("2 : Update Language");
				System.out.println("3 : Update Syntax");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Concept Name: ");
					String newConceptName = in.nextLine();
					toEdit.setConceptName(newConceptName);
				} else if (update == 2) {
					System.out.print("New Language: ");
					String newLanguage = in.nextLine();
					toEdit.setLanguage(newLanguage);
				} else if (update == 3) {
					System.out.print("New Description: ");
					String newDescription = in.nextLine();
					toEdit.setDescription(newDescription);
				}

				lih.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}
		}
		
		
		/*
	     * Can eventually incorporate long form .txt descriptions of programming concepts.
	     * Ran out of time in the week to fully troubleshoot before submission.
	    
	    private static void getAllFiles(File curDir) {

	        File[] filesList = curDir.listFiles();
	        for(File f : filesList){
	            if(f.isDirectory())
	                getAllFiles(f);
	            if(f.isFile()){
	                System.out.println(f.getName());
	            }}
	        }
	    
		private static void openTxt() {
			String txtFile = StartProgram.class.getClassLoader().getResource("text.txt").getPath();
			System.out.println(txtFile);
			File curDir = new File(".");
	        getAllFiles(curDir);
			try {
				Desktop.getDesktop().open(new java.io.File(txtFile));
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		*/
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}
		
		
		
		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Programming Language Concept DB ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add an item");
				System.out.println("*  2 -- Edit an item");
				System.out.println("*  3 -- Delete an item");
				System.out.println("*  4 -- View the list");
				//System.out.println("*  5 -- Open .txt path"); // note need final else if statement
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();
				System.out.print("\n");
				if (selection == 1) {
					addAnItem();
				} 
				
				else if (selection == 2) {
					editAnItem();
				}
				
				 else if (selection == 3) {
					deleteAnItem();
				}
				
				
				else if (selection == 4) {
					viewTheList();
				}
				else {
					lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}
				
			}
		}
		
		private static void viewTheList() {
			// TODO Auto-generated method stub
			System.out.println("Concept : Language : Syntax");	
			List<Concept> allItems = lih.showAllItems();
			for(Concept singleItem:allItems) {
				System.out.println(singleItem.returnConceptDetails());
			}
			System.out.println("");
		} 
		
	}

