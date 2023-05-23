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

        String idParam = request.getPathInfo().substring(1); // URL에서 {id} 값을 추출
        long id = Integer.parseInt(idParam);

        if (request.getRequestURI().endsWith("/countMinus")) {
            libraryService.countMinus(id, 1);
            response.sendRedirect("/list/" + id); // 권수를 조절한 후 도서 상세 정보 페이지로 리디렉션
            return;
        }

        if (request.getRequestURI().endsWith("/countPlus")) {
            libraryService.countPlus(id, 1);
            response.sendRedirect("/list/" + id); // 권수를 조절한 후 도서 상세 정보 페이지로 리디렉션
            return;
        }


        response.setContentType("text/html;charset=UTF-8");

        PrintWriter pw = response.getWriter();
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>도서 상세 정보</title>");
        pw.println("<style>");
        pw.println("body::before {\n" +
                "            position: fixed;\n" +
                "            top: 0;\n" +
                "            left: 0;\n" +
                "            right: 0;\n" +
                "            bottom: 0;\n" +
                "            background-image: url(\"https://ifh.cc/g/KMY6r2.jpg\");\n" +
                "            background-size: cover;\n" +
                "            -webkit-filter: blur(5px);\n" +
                "            -moz-filter: blur(5px);\n" +
                "            -o-filter: blur(5px);\n" +
                "            -ms-filter: blur(5px);\n" +
                "            filter: blur(5px);\n" +
                "            transform: scale(1.02);\n" +
                "            z-index: -1;\n" +
                "            content: \"\";\n" +
                "        }");
        pw.println("table {");
        pw.println("  border-collapse: collapse;");
        pw.println("  width: 80%;");
        pw.println("  margin: 0 auto;");
        pw.println("  background-color: #f9f9f9;");
        pw.println("  opacity: 0.8;");
        pw.println("}");
        pw.println("td {");
        pw.println("  border: 1px solid black;");
        pw.println("  padding: 12px;");
        pw.println("  text-align: left;");
        pw.println("}");
        pw.println("th {");
        pw.println("  border: 1px solid black;");
        pw.println("  padding: 17px;");
        pw.println("  text-align: center;");
        pw.println("}");
        pw.println(".image-container {");
        pw.println("  display: flex;");
        pw.println("  justify-content: center;");
        pw.println("  align-items: center;");
        pw.println("  padding: 10px;");
        pw.println("}");
        pw.println(".image-container img {");
        pw.println("  max-width: 300px;");
        pw.println("  max-height: 300px;");
        pw.println("  margin: 0 auto;");
        pw.println("}");
        pw.println("h1 { text-align: center; }");
        pw.println(".button-container {");
        pw.println("  display: flex;");
        pw.println("  justify-content: center;");
        pw.println("  margin-top: 20px;");
        pw.println("}");
        pw.println(".button-container button {");
        pw.println("  margin: 0 10px;");
        pw.println("  padding: 10px 20px;");
        pw.println("  border: none;");
        pw.println("  border-radius: 4px;");
        pw.println("  background-color: #4CAF50;");
        pw.println("  color: white;");
        pw.println("  cursor: pointer;");
        pw.println("}");
        pw.println(".button-container button:hover {");
        pw.println("  background-color: #45a049;");
        pw.println("}");
        pw.println("</style>");
        pw.println("</head>");
        pw.println("<body>");

        Library library = libraryService.findById(id);
        if (library != null) {
            pw.println("<h1>도서 상세 정보</h1>");
            pw.println("<table>");
            pw.println("<tr><th>이름</th><td>" + library.getName() + "</td></tr>");
            pw.println("<tr><th>저자</th><td>" + library.getAuthor() + "</td></tr>");
            pw.println("<tr><th>출판사</th><td>" + library.getPublisher() + "</td></tr>");
            pw.println("<tr><th>ISBN</th><td>" + library.getIsbn() + "</td></tr>");
            pw.println("<tr><th>출시연도</th><td>" + library.getReleaseYear() + "년" + "</td></tr>");
            pw.println("<tr><th>수량</th><td>");
            pw.println(library.getCount() + "권");
            pw.println("<button onclick='countPlus(" + library.getId() + ")'>+</button>");
            pw.println("<button onclick='countMinus(" + library.getId() + ")'>-</button>");
            pw.println("</td></tr>");
            pw.println("<tr><th>요약</th><td>" + library.getSummary() + "</td></tr>");
            pw.println("<tr><th>표지</th><td class='image-container'><img src='" + library.getImage() + "'></td></tr>");
            pw.println("<tr><th>카테고리</th><td>" + library.getCategory() + "</td></tr>");
            pw.println("</table>");
        } else {
            pw.println("<h1>도서를 찾을 수 없습니다.</h1>");
        }

        pw.println("<div class='button-container'>");
        pw.println("  <button onclick='goBack()'>뒤로 가기</button>");
        pw.println("  <button onclick='editLibrary(" + library.getId() + ")'>수정</button>");
        pw.println("</div>");

        pw.println("<script>");

        pw.println("function goBack() {");
        pw.println("  window.location.href = '/list';");
        pw.println("}");
        pw.println("function editLibrary(id) {");
        pw.println("  window.location.href = '/update?id=' + id;");
        pw.println("}");
        pw.println("function countMinus(id) {");
        pw.println("  window.location.href = '/countMinus?id=' + id;");
        pw.println("}");
        pw.println("function countPlus(id) {");
        pw.println("  window.location.href = '/countPlus?id=' + id;");
        pw.println("}");

        pw.println("</script>");

        pw.println("</body>");
        pw.println("</html>");
    }
}