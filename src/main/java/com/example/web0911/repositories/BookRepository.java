package com.example.web0911.repositories;

import com.example.web0911.db.Book;
import com.example.web0911.db.BookInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("select b from Book b")
    List<BookInfo> findBookInfo();


}