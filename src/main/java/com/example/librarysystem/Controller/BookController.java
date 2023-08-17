package com.example.librarysystem.Controller;

import com.example.librarysystem.Api.ApiResponse;
import com.example.librarysystem.Model.Book;
import com.example.librarysystem.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/Books")
public class BookController {
    private final BookService bookservice;

    @GetMapping("/")
    public ResponseEntity getBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(bookservice.getBooks());
    }

    @PostMapping("/add")
    public ResponseEntity addBook (@RequestBody @Valid Book book){
        bookservice.addBook(book);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("book added"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity removeBook(@PathVariable Integer id){
        bookservice.removeBook(id);
        return ResponseEntity.status(HttpStatus.OK).body("Book remover");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@PathVariable Integer id, @RequestBody @Valid Book book){
        bookservice.updateBook(id,book);
        return ResponseEntity.status(HttpStatus.OK).body("Book updated");
    }

    @GetMapping("/search/{title}")
    public ResponseEntity searchByTitle(@PathVariable String title){
         Book book = bookservice.searchByTitle(title);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @GetMapping("/search/{author}")
    public ResponseEntity getBookByAuthor(@PathVariable String author){
       List<Book> books = bookservice.searchByAuthor(author);
       return ResponseEntity.status(HttpStatus.OK).body(books);
    }

    @GetMapping("/search/{category}")
    public ResponseEntity getBookByCategory(@PathVariable String category){
        List<Book> books = bookservice.searchByCategory(category);
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }

    @GetMapping("/search/{numberOfPages}")
    public ResponseEntity getBookByNumber(@PathVariable Integer numberOfPages){
        List<Book> books = bookservice.searchByNumberOfPages(numberOfPages);
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }

}
