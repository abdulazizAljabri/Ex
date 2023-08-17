package com.example.librarysystem.Service;

import com.example.librarysystem.Api.ApiException;
import com.example.librarysystem.Model.Book;
import com.example.librarysystem.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookrepository;

    public List<Book> getBooks(){
        return bookrepository.findAll();
    }
    public void addBook(Book book){
        bookrepository.save(book);
    }

    public void removeBook(Integer id){
       Book book = bookrepository.findBookById(id);
       if(book == null){
           throw new ApiException("Book not found");
       }
        bookrepository.deleteById(id);
    }

    public void updateBook(Integer id , Book book){
       Book book1 = bookrepository.findBookById(id);
       if(book == null){
           throw new ApiException("book not found");
       }
       book1.setTitle(book.getTitle());
       book1.setNumberOfPages(book.getNumberOfPages());
        book1.setCategory(book.getCategory());
        bookrepository.save(book1);
    }

    public Book searchByTitle(String title){
        Book book = bookrepository.findBookByTitle(title);
        if(book == null){
            throw  new ApiException("book not found");
        }
        return book;
    }
    public List<Book> searchByCategory(String category){
        List<Book> books = bookrepository.findBookByCategory(category);
        if(books.isEmpty()){
            throw new ApiException("isEmpty");
        }
        return books;
    }

    public List<Book> searchByAuthor(String author){
        List<Book> books = bookrepository.findBookByAuthor(author);
        if(books.isEmpty()){
            throw new ApiException("the Author not have any book");
        }
        return books;
    }


    public List<Book> searchByNumberOfPages(Integer numberOfPages){
        List<Book> books = bookrepository.findBookByNumberOfPagesIsGreaterThan(numberOfPages);
        if(books.isEmpty()){
            throw new ApiException("not found book have number of pages greater than 300 ");
        }
        return books;
    }


}
