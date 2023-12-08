package com.example.web0911.controllers;

import com.example.web0911.db.Author;
import com.example.web0911.services.AuthorService;
import com.example.web0911.services.BookService;
import com.example.web0911.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class MainController {

    private StudentService studentService;

    private AuthorService authorService;

    private BookService bookService;

    @GetMapping("/home/{color}")
    public String home(@PathVariable String color,
                       @RequestParam String username,
                       Model model) {
        model.addAttribute("username", username);
        model.addAttribute("color", color);
        return "home";
    }

    @GetMapping("/students")
    public String students(Model model) {
        model.addAttribute("students", studentService.getStudents());
        return "students";
    }

    @GetMapping("/authors")
    public String authors(Model model) {
        model.addAttribute("authors", authorService.getAuthors());
        return "authors";
    }

    @PostMapping("add_author")
    public String addAuthor(@RequestParam String author) {
        authorService.addAuthor(author);
        return "redirect:/authors";
    }

    @GetMapping("/delete_author")
    public String deleteAuthor(@RequestParam int id) {
        authorService.delete(id);
        return "redirect:/authors";
    }

    @GetMapping("/show_author_books")
    public String booksByAuthor(@RequestParam int id, Model model) {
        Optional<Author> author = authorService.findAuthor(id);
        if (author.isPresent()) {
            model.addAttribute("author", author.get());
            return "books_by_author";
        } else {
            return "redirect:/authors";
        }
    }

    @PostMapping("add_book")
    public String addBook(@RequestParam int author_id, @RequestParam String title, @RequestParam int pages) {
        Optional<Author> author = authorService.findAuthor(author_id);
        if (author.isEmpty()) return "error";
        bookService.addBook(author.get(), title, pages);
        return "redirect:/show_author_books?id="+author_id;
    }

    @GetMapping("books")
    public String books(Model model){
        model.addAttribute("books", bookService.getBookInfos());
        return "books";
    }

    @PostMapping("update_author")
    public String updateAuthor(@RequestParam(name="a_id") int id, @RequestParam(name="a_name") String name) {
        authorService.updateAuthor(id, name);
        return "redirect:/authors";
    }

}
