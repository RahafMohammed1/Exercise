package com.example.week4librarysystemday4.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String username;
    @NotEmpty(message = "The password field is required")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]+)$",message = "the password must must have characters and digits ")
    private String password;
}
