package com.example.library_servlet.controller;

import com.example.library_servlet.domain.Library;
import com.example.library_servlet.service.LibraryService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/list/*")
public class DetailServlet extends HttpServlet {
    private final LibraryService libraryService = new LibraryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter pw = response.getWriter();
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>도서 상세 정보</title>");
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
        pw.println(".go-back-button {");
        pw.println("  padding: 10px 20px;");
        pw.println("  font-size: 16px;");
        pw.println("  background-color: #f2f2f2;");
        pw.println("  border: none;");
        pw.println("  border-radius: 4px;");
        pw.println("  cursor: pointer;");
        pw.println("}");
        pw.println(".edit-button {");
        pw.println("  padding: 10px 20px;");
        pw.println("  font-size: 16px;");
        pw.println("  background-color: #f2f2f2;");
        pw.println("  border: none;");
        pw.println("  border-radius: 4px;");
        pw.println("  cursor: pointer;");
        pw.println("}");
        pw.println("</style>");
        pw.println("</head>");
        pw.println("<body>");

        String idParam = request.getPathInfo().substring(1); // URL에서 {id} 값을 추출
        long id = Integer.parseInt(idParam);

        Library library = libraryService.findById(id);
        if (library != null) {
            pw.println("<h1>도서 상세 정보</h1>");
            pw.println("<table>");
            pw.println("<tr><th>이름</th><td>" + library.getName() + "</td></tr>");
            pw.println("<tr><th>저자</th><td>" + library.getAuthor() + "</td></tr>");
            pw.println("<tr><th>출판사</th><td>" + library.getPublisher() + "</td></tr>");
            pw.println("<tr><th>수량</th><td>" + library.getCount() + "권" + "</td></tr>");
            pw.println("</table>");
            pw.println("<br>");
            pw.println("<button class='edit-button' onclick='editLibrary(" + library.getId() + ")'>수정</button>");
        } else {
            pw.println("<h1>도서를 찾을 수 없습니다.</h1>");
        }

        pw.println("<br>");
        pw.println("<button class='go-back-button' onclick='goBack()'>뒤로 가기</button>");
        pw.println("<script>");
        pw.println("function goBack() {");
        pw.println("  window.history.back();");
        pw.println("}");
        pw.println("function editLibrary(id) {");
        pw.println("  window.location.href = '/update?id=' + id;");
        pw.println("}");
        pw.println("</script>");

        pw.println("</body>");
        pw.println("</html>");
    }
}