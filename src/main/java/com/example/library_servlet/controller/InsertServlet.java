package com.example.library_servlet.controller;


import com.example.library_servlet.service.LibraryService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


public class InsertServlet extends HttpServlet {

    private final LibraryService libraryService = new LibraryService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // 1. 파라미터로 전송된 값을 얻어오기.
        request.setCharacterEncoding("euc-kr");
        String name = request.getParameter("name");

        userRepository.addUser(name);

        response.sendRedirect("list");
    }
}
