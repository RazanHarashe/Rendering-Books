package com.renderingbooks.renderingbooks;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.books.books.repositories.BookRepository;

@Controller
public class RenderingBooksController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books/{id}")
    public String showBook(@PathVariable("id") Long id, Model model) {
        com.books.books.models.Book book = bookRepository.findById(id).orElse(null);
        model.addAttribute("book", book);
        return "show.jsp";
    }
}

