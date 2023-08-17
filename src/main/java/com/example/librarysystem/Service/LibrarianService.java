package com.example.librarysystem.Service;

import com.example.librarysystem.Api.ApiException;
import com.example.librarysystem.Model.Librarian;
import com.example.librarysystem.Repository.LibrarianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibrarianService {
    private final LibrarianRepository librarianrepository;

    public List<Librarian> getAllLibraries(){
        return librarianrepository.findAll();
    }

    public void addLibrarian(Librarian librarian){
        librarianrepository.save(librarian);
    }

    public void removeLibrarian(Integer id){
        Librarian librarian = librarianrepository.findLibrarianById(id);
        if (librarian == null){
            throw new ApiException("Could not find");
        }
        librarianrepository.deleteById(id);
    }

    public void updateLibrarian( Integer id , Librarian librarian){
        Librarian librarians = librarianrepository.findLibrarianById(id);
        if (librarians == null){
            throw new ApiException("Could not find");
        }
        librarians.setName(librarian.getName());
        librarians.setEmail(librarian.getEmail());
        librarians.setUsername(librarian.getUsername());
        librarians.setPassword(librarian.getPassword());

        librarianrepository.save(librarian);
    }

    public Librarian searchByEmail(String email){
        Librarian librarian = librarianrepository.findLibrarianByEmail(email);
        if (librarian == null){
            throw new ApiException("could not found account with this email");
        }
        return librarian;
    }

    public Librarian searchById(Integer id){
        Librarian librarian = librarianrepository.findLibrarianById(id);
        if(librarian == null){
            throw new ApiException("not found");
        }
        return librarian;
    }
     public Librarian checkLogin(@PathVariable String username, @PathVariable String password){
        Librarian librarian = librarianrepository.findLibrarianByUsernameAndPassword(username, password);
         if(librarian == null){
             throw new ApiException("not found the username ");
         }
         return librarian;
     }

}
