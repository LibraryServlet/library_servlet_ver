package com.example.library_servlet.service;

import com.example.library_servlet.entity.Library;
import com.example.library_servlet.repository.LibraryRepositoryImpl;

import java.util.List;

public class LibraryService {
    private final LibraryRepositoryImpl libraryRepository;

    public LibraryService() {
        this.libraryRepository = new LibraryRepositoryImpl();
    }

    public void insert(Library library) {
        libraryRepository.insert(library);
    }

    public List<Library> findAll() {
        return libraryRepository.findAll();
    }

    public Library findById(Long id) {
        return libraryRepository.findById(id);
    }

    public List<Library> findByName(String name) {
        return libraryRepository.findByName(name);
    }

    public List<Library> findByAuthor(String author) {
        return libraryRepository.findByAuthor(author);
    }

    public List<Library> findByPublisher(String publisher) {
        return libraryRepository.findByPublisher(publisher);
    }

    public List<Library> findByIsbn(String isbn) {
        return libraryRepository.findByIsbn(isbn);
    }

    public List<Library> findByCategory(String category) {
        return libraryRepository.findByCategory(category);
    }

    public void countPlus(Long id, int count) {
        libraryRepository.countPlus(id, count);
    }

    public void countMinus(Long id, int count) {
        libraryRepository.countMinus(id, count);
    }

    public void deleteById(Long id) {
        libraryRepository.deleteById(id);
    }

    public void updateLibrary(Library lib){
        libraryRepository.updateLibrary(lib);
    }
}
