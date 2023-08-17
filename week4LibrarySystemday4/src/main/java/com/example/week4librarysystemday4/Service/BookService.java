package com.example.week4librarysystemday4.Service;

import com.example.week4librarysystemday4.ApiResponse.ApiException;
import com.example.week4librarysystemday4.Model.Book;
import com.example.week4librarysystemday4.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
   private final BookRepository bookRepository;

    public List<Book> getAll()
    {
        return bookRepository.findAll();
    }

    public void addBook(Book book)
    {
        bookRepository.save(book);
    }

    public void updateBook(Integer id,Book book)
    {
        Book book1=bookRepository.findBookById(id);
        if(book1==null)
        {
            throw new ApiException("the Book not found ");
        }
        book1.setAuthor(book.getAuthor());
        book1.setCategory(book.getCategory());
        book1.setTitle(book.getTitle());
        book1.setISBN(book.getISBN());
        book1.setNumberOfPages(book.getNumberOfPages());
    }

    public void deleteBook(Integer id)
    {
        Book book1=bookRepository.findBookById(id);
        if(book1==null)
        {
            throw new ApiException("the Book not found ");
        }
        bookRepository.delete(book1);
    }

    public List<Book> GetBooksByCategory (String category)
    {
        List<Book>bookByCategory=bookRepository.findBookByCategory(category);
        if (bookByCategory==null)
        {
            throw new ApiException("the Category not found");
        }
        return bookByCategory;
    }

    public List<Book>getBookByNumberOfPages()
    {
        List<Book>bookByNumberOfPages=bookRepository.getBookByNumberOfPagesGreaterThan(300);
        if(bookByNumberOfPages==null)
        {
            throw new ApiException("there is no book with pages greater than 300");
        }
        return bookByNumberOfPages;
    }

    public List<Book>getBookByAuthor(String author)
    {
        List<Book>books=bookRepository.findBookByAuthor(author) ;
        if (books==null)
        {
            throw new ApiException("there is no book published by this author");
        }
        return books;
    }
    public Book searchByTitle(String title){
        Book book=bookRepository.findBookByTitle(title);
            if (book==null)
            {
                throw new ApiException("The book isn't found");
            }
            return book;
        }
}
