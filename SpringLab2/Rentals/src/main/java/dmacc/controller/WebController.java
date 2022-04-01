/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Mar 30, 2022
 */
package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Development;
import dmacc.repository.DevelopmentRepository;


@Controller
public class WebController {
	@Autowired
	DevelopmentRepository repo;
	
	
	
	@GetMapping({"/viewAll"})  // corresponds to href viewAll in index .. generates the following
	public String viewAllContacts(Model model) {
	if(repo.findAll().isEmpty()) {
		return addNewDevelopment(model);
	}
	model.addAttribute("developments", repo.findAll()); // see line 10 in results
		return "results";
	}
	
	@GetMapping("/inputDevelopment")
	public String addNewDevelopment(Model model) {
	 Development c = new Development();
	 model.addAttribute("newDevelopment", c);
	 return "input";
	}
	
	
	@PostMapping("/inputDevelopment") // line 9 in input.html
	public String addNewContact(@ModelAttribute Development c, Model model) {
	repo.save(c);
	return viewAllContacts(model); // note public declaration line 25.. returns results with model
	}
	
	
	// edit
	@GetMapping("/edit/{id}")
	public String showUpdateContact(@PathVariable("id") long id, Model model) {
	Development c = repo.findById(id).orElse(null);
	model.addAttribute("newDevelopment", c);
	return "input";
	}
	
	@PostMapping("/update/{id}")
	public String reviseContact(Development c, Model model) {
	repo.save(c);
	return viewAllContacts(model);
	}
	
	//delete
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
	Development c = repo.findById(id).orElse(null);
	repo.delete(c);
	return viewAllContacts(model);
	}
	
	
	
		
}
