package com.example.week4librarysystemday4.Controller;

import com.example.week4librarysystemday4.ApiResponse.ApiResponse;
import com.example.week4librarysystemday4.Model.Book;
import com.example.week4librarysystemday4.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/library")
public class BookController {
    private final BookService bookService;

    public List<Book> getAll()
    {
        return bookService.getAll();
    }

    public ResponseEntity addBook(@RequestBody Book book)
    {
        bookService.addBook(book);
        return ResponseEntity.status(200).body(new ApiResponse("the Book is added"));
    }
    public ResponseEntity updateBook(@PathVariable Integer id, @RequestBody Book book)
    {
        bookService.updateBook(id,book);
        return ResponseEntity.status(200).body(new ApiResponse("the Book is updated"));
    }

    public ResponseEntity deleteBook(@PathVariable Integer id)
    {
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body(new ApiResponse("the Book is deleted"));
    }

    public ResponseEntity GetBooksByCategory(@PathVariable String category)
    {
       return ResponseEntity.status(200).body(bookService.GetBooksByCategory(category));
    }

}
