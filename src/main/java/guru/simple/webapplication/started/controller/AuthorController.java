package guru.simple.webapplication.started.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.simple.webapplication.started.repository.AuthorRepository;

@Controller
public class AuthorController {
	private final AuthorRepository authorRepository;
	
	public AuthorController(AuthorRepository authorRepository) {
	//	super();
		this.authorRepository = authorRepository;
	}

	
	
	@RequestMapping(value = "/author")
	public String getAuthor(Model model) {
		
		model.addAttribute("authors", authorRepository.findAll());
		
		return "authors/authorList";
	}
}
