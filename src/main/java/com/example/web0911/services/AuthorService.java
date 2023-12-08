package com.example.web0911.services;

import com.example.web0911.db.Author;
import com.example.web0911.repositories.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public void addAuthor(String author) {
        authorRepository.save(new Author(0, author));
    }

    public void delete(int id) {
        authorRepository.deleteById(id);
    }

    public Optional<Author> findAuthor(int id) {
        return authorRepository.findById(id);
    }

    public void updateAuthor(int id, String name) {
        authorRepository.save(new Author(id, name));
    }
}
