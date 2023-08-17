package com.example.librarysystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message="should not be empty")
    @Column(columnDefinition = "varchar(15) NOT NULL unique")
    private String title;

    @NotEmpty(message = "should not be empty")
    @Column(columnDefinition = "varchar(15) NOT NULL")
    private String author;
    @NotEmpty(message = "should not be empty")
    @Column(columnDefinition = "varchar(10) NOT NULL")
    private String category;

    @NotNull(message = "should not null")
    private Integer isbn;

    @NotNull(message = "should not null")
    @Min(value=50)
    private Integer numberOfPages;

}
