package guru.simple.webapplication.started.repository;

import org.springframework.data.repository.CrudRepository;

import guru.simple.webapplication.started.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{  
	// extends CrudRepository de thuc thi cac functional full crud
}
