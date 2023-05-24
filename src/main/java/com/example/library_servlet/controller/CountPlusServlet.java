package com.example.library_servlet.controller;

import com.example.library_servlet.service.LibraryService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/countPlus")
public class CountPlusServlet extends HttpServlet {
    private final LibraryService libraryService = new LibraryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idParam = request.getParameter("id");
        long id = Long.parseLong(idParam);
        libraryService.countPlus(id, 1);
        response.sendRedirect("/list/" + id); // 권수를 조절한 후 도서 상세 정보 페이지로 리디렉션
    }
}