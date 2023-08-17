package com.example.week4librarysystemday4.Repository;

import com.example.week4librarysystemday4.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    Book findBookById(Integer id);
    List<Book> findBookByCategory(String category);
    List<Book> getBookByNumberOfPagesGreaterThan(Integer number);

    List<Book> findBookByAuthor(String author);

    Book findBookByTitle(String title);
}
