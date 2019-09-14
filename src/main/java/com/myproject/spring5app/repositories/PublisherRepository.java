package com.myproject.spring5app.repositories;

import com.myproject.spring5app.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
