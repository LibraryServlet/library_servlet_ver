package com.example.library_servlet.controller;

import com.example.library_servlet.domain.Library;
import com.example.library_servlet.service.LibraryService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

    private final LibraryService libraryService = new LibraryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Library lib = libraryService.findById(id);

        resp.setContentType("text/html;charset=euc-kr");
        PrintWriter pw = resp.getWriter();
        pw.println("<html>");
        pw.println("<head></head>");
        pw.println("<body>");

        pw.println("<form method='post' action='updateok'>");
        pw.println("<input type='hidden' name='id' value='" + id + "'>");
        pw.println("<label for='name'>책 이름</label>");
        pw.println("<input type='text' name='name' value= " + lib.getName() + "><br/>");
        pw.println("<label for='author'>작가</label>");
        pw.println("<input type='text' name='author' value=" + lib.getAuthor() + "><br/>");
        pw.println("<label for='publisher'>출판사</label>");
        pw.println("<input type='text' name='publisher' value=" + lib.getPublisher() + "><br/>");
        pw.println("<label for='isbn'>ISBN</label>");
        pw.println("<input type='text' name='isbn' value=" + lib.getIsbn() + "><br/>");
        pw.println("<label for='releaseYear'>출판 연도</label>");
        pw.println("<input type='text' name='releaseYear' value=" + lib.getReleaseYear() + "><br/>");

        pw.println("<label for='count'>수량</label>");
        pw.println("<input type='text' name='count' value=" + lib.getCount() + "><br/>");
        pw.println("<label for='summary'>요약</label>");
        pw.println("<input type='text' name='summary' value=" + lib.getSummary() + "><br/>");
        pw.println("<label for='image'>이미지</label>");
        pw.println("<input type='text' name='image' value=" + lib.getImage() + "><br/>");
        pw.println("<label for='category'>카테고리</label>");
        pw.println("<input type='text' name='category' value=" + lib.getCategory() + "/><br/>");

        pw.println("<input type='submit' value='수정 완료'/><br/>");
        pw.println("</form>");

        pw.println("</body>");
        pw.println("</html>");
        pw.close();

    }
}
