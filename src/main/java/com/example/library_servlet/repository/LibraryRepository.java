package com.example.library_servlet.repository;


import com.example.library_servlet.entity.Library;

import java.util.List;

public interface LibraryRepository {
    void insert(Library library);

    List<Library> findAll();

    Library findById(Long id);

    List<Library> findByName(String name);

    List<Library> findByAuthor(String author);

    List<Library> findByPublisher(String publisher);

    List<Library> findByIsbn(String isbn);

    List<Library> findByCategory(String category);

    void countPlus(Long id, int count);

    void countMinus(Long id, int count);

    void deleteById(Long id);

    void updateLibrary(Library library);
}
