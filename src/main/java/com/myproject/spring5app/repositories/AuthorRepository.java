package com.myproject.spring5app.repositories;

import com.myproject.spring5app.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
