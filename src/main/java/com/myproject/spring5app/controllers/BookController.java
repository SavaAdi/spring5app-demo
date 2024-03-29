package com.myproject.spring5app.controllers;

import com.myproject.spring5app.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

//    This is an alternative to @Autowired
//    public BookController(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }

    @RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "books";
    }
}
