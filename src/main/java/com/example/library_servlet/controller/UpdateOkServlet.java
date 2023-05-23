package com.example.library_servlet.controller;

import com.example.library_servlet.domain.Library;
import com.example.library_servlet.service.LibraryService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/updateok")
public class UpdateOkServlet extends HttpServlet {
    private final LibraryService libraryService = new LibraryService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("euc-kr");
        Long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        String publisher = req.getParameter("publisher");
        String isbn = req.getParameter("isbn");
        int releaseYear = Integer.parseInt(req.getParameter("releaseYear"));
        int count = Integer.parseInt(req.getParameter("count"));
        String summary = req.getParameter("summary");
        String image = req.getParameter("image");
        String category = req.getParameter("category");

        libraryService.updateLibrary(new Library(id, name, author, publisher, isbn, releaseYear, count, summary, image, category));

        resp.sendRedirect("list");
    }
}