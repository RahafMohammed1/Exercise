package com.example.week4librarysystemday4.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "The name field is required")
    private String name;
    @NotEmpty(message = "The username field is required")
    @Column(columnDefinition = "Varchar(20) unique")
    private String username;
    @NotEmpty(message = "The password field is required")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]+)$",message = "the password must must have characters and digits ")
    private String password;
    @Email(message = "please enter a correct email")
    @Column(columnDefinition = "Varchar(20) unique")
    private String email;
}
