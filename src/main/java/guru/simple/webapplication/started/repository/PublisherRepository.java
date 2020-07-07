package guru.simple.webapplication.started.repository;

import org.springframework.data.repository.CrudRepository;

import guru.simple.webapplication.started.model.Publisher;

public interface PublisherRepository  extends CrudRepository<Publisher, Long>{
	
}
