package com.example.library_servlet.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DeleteServlet extends HttpServlet {
    private final UserRepository userRepository = UserRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("euc-kr");
        Long id = Long.parseLong(request.getParameter("id"));
        response.setContentType("text/html;charset=euc-kr");

        userRepository.deleteUser(id);

        response.sendRedirect("list");
    }
}