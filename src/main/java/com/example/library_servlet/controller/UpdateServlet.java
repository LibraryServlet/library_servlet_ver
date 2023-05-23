package com.example.library_servlet.controller;

import com.example.library_servlet.service.LibraryService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class UpdateServlet extends HttpServlet {

    private final LibraryService libraryService = new LibraryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String id = req.getParameter("id");
        String updateName = req.getParameter("updateName");

        resp.setContentType("text/html;charset=euc-kr");
        PrintWriter pw = resp.getWriter();
        pw.println("<html>");
        pw.println("<head></head>");
        pw.println("<body>");

        pw.println("<form method='post' action='updateok'>");
        pw.println("<input type='hidden' name='id' value='" + id + "'/>");
        pw.println("이름<input type='text' name='updateName' value='" + updateName + "/><br/>");
        pw.println("<input type='submit' value='저장'/><br/>");
        pw.println("</form>");

        pw.println("</body>");
        pw.println("</html>");
        pw.close();
    }
}
