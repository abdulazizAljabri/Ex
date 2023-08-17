package com.example.librarysystem.Controller;

import com.example.librarysystem.Api.ApiResponse;
import com.example.librarysystem.Model.Librarian;
import com.example.librarysystem.Service.LibrarianService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/librarians")
@RequiredArgsConstructor
public class LibrarianController {
    private final LibrarianService librarianservice;

    @GetMapping("/")
    public ResponseEntity getLibrarians(){
        return ResponseEntity.status(HttpStatus.OK).body(librarianservice.getAllLibraries());
    }

    @PostMapping("/add")
    public ResponseEntity addLibrarian(@RequestBody @Valid Librarian librarian ){
        librarianservice.addLibrarian(librarian);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Librarian added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateLibrarian(@PathVariable Integer id, @RequestBody @Valid Librarian librarian){
        librarianservice.updateLibrarian(id, librarian);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Librarian updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLibrarian(@PathVariable Integer id){
        librarianservice.removeLibrarian(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Librarian deleted"));
    }

    @GetMapping("/search/{email}")
    public ResponseEntity searchByEmail(@PathVariable String email){
        return ResponseEntity.status(HttpStatus.OK).body(librarianservice.searchByEmail(email));
    }

    @GetMapping("/search/{id}")
    public ResponseEntity searchById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(librarianservice.searchById(id));
    }

    @GetMapping("/account/{username}/{password}")
    public ResponseEntity getAccount (@PathVariable String username, @PathVariable String password){
        return ResponseEntity.status(HttpStatus.OK).body(librarianservice.checkLogin(username,password));
    }


}
