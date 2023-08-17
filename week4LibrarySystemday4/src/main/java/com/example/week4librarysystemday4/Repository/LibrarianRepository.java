package com.example.week4librarysystemday4.Repository;

import com.example.week4librarysystemday4.Model.Book;
import com.example.week4librarysystemday4.Model.Librarian;
import jakarta.persistence.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian,Integer> {
Librarian findLibrarianById(Integer id);
Librarian findAllByUsername(String username);
Librarian findAllByEmail(String email);

}
