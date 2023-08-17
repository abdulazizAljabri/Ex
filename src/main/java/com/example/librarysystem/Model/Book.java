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
@Table(name = "Book")
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
    @Column(columnDefinition = "varchar(10) NOT NULL check(category = 'Academic' or category = 'Mystery' or category = 'Novel')")
    private String category;

    @NotNull(message = "should not null")
    @Column(columnDefinition = "int not null")
    private Integer isbn;

    @NotNull(message = "should not null")
    @Min(value=50)
    @Column(columnDefinition = "int not null")
    private Integer numberOfPages;

}
