package com.example.week4librarysystemday4.Service;

import com.example.week4librarysystemday4.ApiResponse.ApiException;
import com.example.week4librarysystemday4.Model.Book;
import com.example.week4librarysystemday4.Model.Librarian;
import com.example.week4librarysystemday4.Repository.LibrarianRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LibrarianService {
    private final LibrarianRepository librarianRepository;
    public List<Librarian> getAll()
    {
        return librarianRepository.findAll();
    }

    public void addLibrarian(Librarian librarian)
    {
        librarianRepository.save(librarian);
    }

    public void updateLibrarian ( Integer id,Librarian librarian) {
        Librarian oldLib = librarianRepository.getById(id);
        if (oldLib == null) {
            throw new ApiException("the librarian is not found");
        }
        oldLib.setName(librarian.getName());
        oldLib.setPassword(librarian.getPassword());
        oldLib.setUsername(librarian.getUsername());

        librarianRepository.save(oldLib);
    }

    public void delete(Integer id)
    {
        Librarian oldLib = librarianRepository.getById(id);
        if (oldLib == null) {
            throw new ApiException("the librarian is not found");
        }
        librarianRepository.delete(oldLib);
    }
    public Librarian LibrarianById(Integer id)
    {
        Librarian oldLib = librarianRepository.findLibrarianById(id);
        if (oldLib == null) {
            throw new ApiException("the librarian is not found");
        }
        return oldLib;
    }

    public void checkLogin(String username,String password)
    {
        Librarian librarian=librarianRepository.findAllByUsername(username);
        if (librarian == null) {
            throw new ApiException("the librarian username and password is not correct");
        }
        if (!Objects.equals(librarian.getPassword(), password))
        {
            throw new ApiException("the librarian username and password is not correct");
        }

    }

    public Librarian getByEmail(String email)
    {
       Librarian librarian=librarianRepository.findAllByEmail(email);
        if (librarian == null) {
            throw new ApiException("the librarian email is not Found");
        }
        return librarian;
    }
}
