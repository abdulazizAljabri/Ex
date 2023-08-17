package com.example.librarysystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "should not be empty")
    @Column(columnDefinition = "varchar(20) NOT NULL ")
    private String name;
    @NotEmpty(message = "should not be empty")
    @Column(columnDefinition = "varchar(20) NOT NULL unique")
    private String username;
    @NotEmpty(message = "should not be empty")
    private  String password;
    @Email
    @Column(columnDefinition = "varchar(20) NOT NULL unique check")
    private String email;

}
