package com.example.library_servlet.controller;


import com.example.library_servlet.entity.Library;
import com.example.library_servlet.service.LibraryService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/insert")
public class InsertServlet extends HttpServlet {

    private final LibraryService libraryService = new LibraryService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("euc-kr");
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");
        String isbn = request.getParameter("isbn");
        int releaseYear = Integer.parseInt(request.getParameter("releaseYear"));
        int count = Integer.parseInt(request.getParameter("count"));
        String summary = request.getParameter("summary");
        String image = request.getParameter("image");
        String category = request.getParameter("category");

        libraryService.insert(new Library(name, author, publisher, isbn, releaseYear, count, summary, image, category));

        response.sendRedirect("list");
    }
}
