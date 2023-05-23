package com.example.library_servlet.controller;

import com.example.library_servlet.domain.Library;
import com.example.library_servlet.service.LibraryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@WebServlet("/sort")
public class SortServlet extends HttpServlet {
    private final LibraryService libraryService = new LibraryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String sortType = request.getParameter("type");

        if ("name".equals(sortType)) {
            sortByName(request, response);
        } else if ("year".equals(sortType)) {
            sortByYear(request, response);
        } else {
            // Invalid sort type
            response.sendRedirect("/list");
        }
    }

    private void sortByName(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Library> libraryList = libraryService.findAll();
        libraryList.sort(Comparator.comparing(Library::getName));

        request.setAttribute("sortedLibraryList", libraryList);
        request.getRequestDispatcher("/list").forward(request, response);
    }

    private void sortByYear(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Library> libraryList = libraryService.findAll();
        libraryList.sort(Comparator.comparingInt(Library::getReleaseYear));

        request.setAttribute("sortedLibraryList", libraryList);
        request.getRequestDispatcher("/list").forward(request, response);
    }
}