package com.example.week4librarysystemday4.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "The title field is required")
    private String title;
    @NotEmpty(message = "The author field is required")
    private String author;
    @NotEmpty(message = "The category field is required")
    @Column(columnDefinition = "Varchar(20) check(category='Academic' or category='Mystery' or  category='Novel'")
    private String category;
    @NotEmpty(message = "The ISBN field is required")
    private Integer ISBN;
    @NotEmpty(message = "The number Of Pages field is required")
    @Min(value = 50,message = "the number Of Pages must be more than 50")
    private Integer numberOfPages;
}
