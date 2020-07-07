package guru.simple.webapplication.started.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.simple.webapplication.started.repository.BookRepository;

@Controller  // tell spring day la controller , this is spring stereotype
public class BookController {
	
	private final BookRepository bookRepository;
	
	public BookController(BookRepository bookRepository) {
	//	super();
		this.bookRepository = bookRepository;
	}

	@RequestMapping(value = "/books") // nhan request tu URL 
	public String getBook(Model model) {
		
		model.addAttribute("books", bookRepository.findAll()); // controller di lay model
		return "books/list";  // controler tra ve view 
	}
	
}
