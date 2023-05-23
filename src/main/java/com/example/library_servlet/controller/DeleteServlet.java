package com.example.library_servlet.controller;

import com.example.library_servlet.service.LibraryService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DeleteServlet extends HttpServlet {
    private final LibraryService libraryService = new LibraryService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("euc-kr");
        Long id = Long.parseLong(request.getParameter("id"));
        response.setContentType("text/html;charset=euc-kr");

        libraryService.deleteById(id);

        response.sendRedirect("list");
    }
}