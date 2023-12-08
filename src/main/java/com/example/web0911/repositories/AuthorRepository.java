package com.example.web0911.repositories;

import com.example.web0911.db.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}