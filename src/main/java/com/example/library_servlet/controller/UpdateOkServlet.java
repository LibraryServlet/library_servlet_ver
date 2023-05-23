package com.example.library_servlet.controller;

import com.example.library_servlet.service.LibraryService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UpdateOkServlet extends HttpServlet {
    private final LibraryService libraryService = new LibraryService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("euc-kr");
        Long id = Long.parseLong(req.getParameter("id"));
        String updateName = req.getParameter("updateName");

        userRepository.updateUser(id, updateName);

        resp.sendRedirect("list");
    }
}