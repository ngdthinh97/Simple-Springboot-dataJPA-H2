package guru.simple.webapplication.started.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.simple.webapplication.started.model.Author;
import guru.simple.webapplication.started.model.Book;
import guru.simple.webapplication.started.model.Publisher;
import guru.simple.webapplication.started.repository.AuthorRepository;
import guru.simple.webapplication.started.repository.BookRepository;
import guru.simple.webapplication.started.repository.PublisherRepository;

@Component // to tell spring this class as a managed component 
public class BootStrapData implements CommandLineRunner{

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
	//	super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Started in bootstrap");
		Author eric = new Author("Eric", "Christ");
		Book ddd = new Book("Domain driven assign", "123456");
		Publisher NXBYuka = new Publisher();
		NXBYuka.setName("Yuka");
		NXBYuka.setCity("TP.HCM");
		NXBYuka.setState("FL");
		publisherRepository.save(NXBYuka);
		
		eric.getBook().add(ddd);  // author.eric -> getbook -> add book.ddd
		ddd.getAuthors().add(eric); // book.ddd -> getAuthor -> add author.eric
		
		ddd.setPublisher(NXBYuka);
		NXBYuka.getBooks().add(ddd);
		
		authorRepository.save(eric); //spring data jpa is ultilizing Hibernate  to save them in to h2 memory database
		bookRepository.save(ddd);//spring data jpa is ultilizing Hibernate  to save them in to h2 memory database
		publisherRepository.save(NXBYuka);
		
		//book 2
		Author thinh = new Author("Thinh","Nguyen"); // create author object
		Book bbb= new Book("Chuyen tinh than xuan bi hai","654321"); 
		
		
		thinh.getBook().add(bbb);  
		bbb.getAuthors().add(thinh);
		
		bbb.setPublisher(NXBYuka);
		NXBYuka.getBooks().add(bbb);
		
		authorRepository.save(thinh);//spring data jpa is ultilizing Hibernate  to save them in to h2 memory database
		bookRepository.save(bbb);//spring data jpa is ultilizing Hibernate  to save them in to h2 memory database
		publisherRepository.save(NXBYuka);
		
		
		System.out.println("Number of books:" + bookRepository.count());
		System.out.println("Number of authors:" + authorRepository.count());

		System.out.println("Publisher:" + publisherRepository.count() + "\t" + NXBYuka.getBooks().size() + "\t"  + NXBYuka.getName());
		
		
		
		
		
	}
	
}
