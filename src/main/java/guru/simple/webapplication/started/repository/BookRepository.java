package guru.simple.webapplication.started.repository;

import org.springframework.data.repository.CrudRepository;

import guru.simple.webapplication.started.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
