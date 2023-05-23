package com.example.library_servlet.controller;

import com.example.library_servlet.domain.Library;
import com.example.library_servlet.service.LibraryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchServlet extends HttpServlet {
    private final LibraryService libraryService = new LibraryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category = request.getParameter("category");
        String search = request.getParameter("search");

        List<Library> searchResults = new ArrayList<>();

        switch (category) {
            case "title":
                searchResults = libraryService.findByName(search);
                break;
            case "author":
                searchResults = libraryService.findByAuthor(search);
                break;
            case "publisher":
                searchResults = libraryService.findByPublisher(search);
                break;
            case "isbn":
                searchResults = libraryService.findByIsbn(search);
                break;
        }

        request.setAttribute("searchResults", searchResults);
        request.getRequestDispatcher("/list").forward(request, response);
    }
}