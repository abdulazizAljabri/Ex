package com.example.librarysystem.Repository;

import com.example.librarysystem.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    Book findBookById(Integer id);
    Book findBookByTitle(String title);
    List<Book> findBookByCategory(String category);

    List<Book> findBookByAuthor(String author);

    List<Book> findBookByNumberOfPagesIsGreaterThan(Integer numberOfPages);
}
