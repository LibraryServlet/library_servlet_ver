package com.example.library_servlet.controller;

import com.example.library_servlet.service.LibraryService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class ListServlet extends HttpServlet {
    private final LibraryService libraryService = new LibraryService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=euc-kr");

        PrintWriter pw = response.getWriter();
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>사용자 목록</title>");
        pw.println("<style>");
        pw.println("table {");
        pw.println("  border-collapse: collapse;");
        pw.println("  width: 100%;");
        pw.println("}");
        pw.println("th, td {");
        pw.println("  border: 1px solid black;");
        pw.println("  padding: 8px;");
        pw.println("  text-align: left;");
        pw.println("}");
        pw.println("tr:nth-child(even) {");
        pw.println("  background-color: #f2f2f2;");
        pw.println("}");
        pw.println("</style>");

        pw.println("<script>");
        pw.println("function submitForm(userId) {");
        pw.println("  document.getElementById('updateForm' + userId).submit();");
        pw.println("}");
        pw.println("</script>");

        pw.println("</head>");
        pw.println("<body>");

        pw.println("<h1>사용자 목록</h1>");
        pw.println("<table>");
        pw.println("<tr>");
        pw.println("<th>이름</th>");
        pw.println("<th>삭제</th>");
        pw.println("<th>수정</th>");
        pw.println("</tr>");

        LinkedList<User> userList = userRepository.getUserList();

        for (User user : userList) {
            pw.println("<tr>");
            pw.println("<td>" + user.getName() + "</td>");
            pw.println("<td><a href='delete?id=" + user.getId() + "'>삭제</a></td>");

            pw.println("<td>");
            pw.println("<a href='#' onclick='submitForm(" + user.getId() + ")'>수정</a>");
            pw.println("<form id='updateForm" + user.getId() + "' method='post' action='updateok' style='display:none;'>");
            pw.println("<input type='hidden' name='id' value='" + user.getId() + "'/>");
            pw.println("<input type='hidden' name='updateName' value='독수리'/>");
            pw.println("</form>");
            pw.println("</td>");

            pw.println("</tr>");
        }

        pw.println("</table>");
        pw.println("<br>");
        pw.println("<a href='/'>메인페이지로 이동</a>");

        pw.println("</body>");
        pw.println("</html>");
    }
}