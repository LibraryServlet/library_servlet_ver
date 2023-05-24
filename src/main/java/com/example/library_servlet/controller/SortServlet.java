package com.example.library_servlet.controller;

import com.example.library_servlet.entity.Library;
import com.example.library_servlet.service.LibraryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@WebServlet("/sort")
public class SortServlet extends HttpServlet {
    private final LibraryService libraryService = new LibraryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String sortType = request.getParameter("type");
        String category = request.getParameter("category");
        String search = request.getParameter("search");

        if ("name".equals(sortType)) {
            sortByName(request, response, category, search);
        } else if ("year".equals(sortType)) {
            sortByYear(request, response, category, search);
        } else {
            // Invalid sort type
            response.sendRedirect("/list");
        }
    }

    private void sortByName(HttpServletRequest request, HttpServletResponse response, String category, String search) throws IOException, ServletException {
        List<Library> libraryList = selectCategory(category, search);

        libraryList.sort(Comparator.comparing(Library::getName));

        request.setAttribute("sortedLibraryList", libraryList);
        request.getRequestDispatcher("/list").forward(request, response);
    }

    private void sortByYear(HttpServletRequest request, HttpServletResponse response, String category, String search) throws IOException, ServletException {
        List<Library> libraryList = selectCategory(category, search);

        libraryList.sort(Comparator.comparingInt(Library::getReleaseYear).reversed());

        request.setAttribute("sortedLibraryList", libraryList);
        request.getRequestDispatcher("/list").forward(request, response);
    }

    private List<Library> selectCategory(String category, String search) {
        List<Library> libraryList;

        switch (category) {
            case "title":
                libraryList = libraryService.findByName(search);
                break;

            case "author":
                libraryList = libraryService.findByAuthor(search);
                break;

            case "publisher":
                libraryList = libraryService.findByPublisher(search);
                break;

            case "isbn":
                libraryList = libraryService.findByIsbn(search);
                break;

            case "category":
                libraryList = libraryService.findByCategory(search);
                break;

            default:
                libraryList = libraryService.findAll();
                break;
        }

        return libraryList;
    }
}