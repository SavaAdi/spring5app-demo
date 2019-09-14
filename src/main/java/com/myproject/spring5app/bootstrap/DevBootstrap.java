package com.myproject.spring5app.bootstrap;

import com.myproject.spring5app.model.Author;
import com.myproject.spring5app.model.Book;
import com.myproject.spring5app.model.Publisher;
import com.myproject.spring5app.repositories.AuthorRepository;
import com.myproject.spring5app.repositories.BookRepository;
import com.myproject.spring5app.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

//The whole point of this class is to initialize the database with some objects
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

//    No need for @autowired annotation here because we are using Constructor injection
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

//    Constructor injection
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

//    This populates the database at runtime
    public void initData(){

        Publisher vikings = new Publisher();
        vikings.setName("Vikings");

        publisherRepository.save(vikings);

        Author ivan = new Author("Ivan", "the Great");
        Book headCrush = new Book("HeadCrush", "13131", vikings);
        ivan.getBooks().add(headCrush);
        headCrush.getAuthors().add(ivan);

        authorRepository.save(ivan);
        bookRepository.save(headCrush);

        Publisher thePoliceMagazine = new Publisher();
        thePoliceMagazine.setName("The Police Magazine");

        publisherRepository.save(thePoliceMagazine);

        Author joe = new Author("John", "Doe");
        Book missingMan = new Book("Missing Man", "12341", thePoliceMagazine);
        joe.getBooks().add(missingMan);
        missingMan.getAuthors().add(joe);

        authorRepository.save(joe);
        bookRepository.save(missingMan);
    }
}
