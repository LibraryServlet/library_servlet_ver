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

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    private final LibraryService libraryService = new LibraryService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter pw = response.getWriter();
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>도서 목록</title>");
        pw.println("<style>");
        pw.println("body {\n" +
                "            text-decoration: none;\n" +
                "        }");
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
        pw.println("  border-style: none;");
        pw.println("  width: 100%;");
        pw.println("  border-radius: 15px;"); //
        pw.println("  background-color: white;"); //
        pw.println("  opacity: 0.7;");
        pw.println("  margin-top: 20px;");
        pw.println("}");
        pw.println("th {");
        //pw.println("  border: 1px solid black;");
        pw.println("  border-radius: 15px;"); //
        pw.println("  padding: 8px;");
        pw.println("  text-align: left;");
        pw.println("}");
        pw.println("td {");
        pw.println("  border: 1px solid black;");
        //pw.println("  border-radius: 15px;"); //
        pw.println("  padding: 8px;");
        pw.println("  text-align: left;");
        pw.println("}");
        pw.println("tr:nth-child(even) {");
        pw.println("  background-color: white;");
        pw.println("}");
        pw.println(".search-form {");
        pw.println("  display: flex;");
        pw.println("  justify-content: flex-end;");
        pw.println("  align-items: center;");
        pw.println("}");
        pw.println(".search-form label {");
        pw.println("  margin-right: 10px;");
        pw.println("}");
        pw.println(".search-form select, .search-form input[type='submit'] {");
        pw.println("  padding: 5px;");
        pw.println("}");
        pw.println(".search-form input[type='text'] {");
        pw.println("  padding: 10px;");

        pw.println("}");
        pw.println(".action-buttons {");
        pw.println("  display: flex;");
        pw.println("  justify-content: flex-end;");
        pw.println("  align-items: center;");
        pw.println("}");
        pw.println(".action-buttons button {");
        pw.println("  margin-left: 5px;");
        pw.println("  padding: 5px;");
        pw.println("}");
        pw.println(".quantity-input {");
        pw.println("  width: 60px;");
        pw.println("}");
        pw.println(".button-container button {");
        pw.println("  padding: 10px 20px;");
        pw.println("  font-size: 16px;");
        pw.println("  background-color: #4caf50;");
        pw.println("  border: none;");
        pw.println("  border-radius: 4px;");
        pw.println("  color: white;");
        pw.println("  cursor: pointer;");
        pw.println("}");
        pw.println("h1 { text-align: center; }");

        pw.println(".button-container {");
        pw.println("  display: flex;");
        pw.println("  justify-content: flex-end;");
        pw.println("  margin-top: 20px;");
        pw.println("}");
        pw.println(".button-container button input[type=\"submit\"] {");
        pw.println("  margin-left: 5px;");
        pw.println("  padding: 5px;");
        pw.println("  border: none;");
        pw.println("  border-radius: 4px;");
        pw.println("  background-color: #4caf50;");
        pw.println("  color: white;");
        pw.println("  cursor: pointer;");
        pw.println("}");
        pw.println(".button-container button:hover {");
        pw.println("  background-color: #4caf50;");
        pw.println("}");

        pw.println("</style>");

        pw.println("<script>");
        pw.println("function goToMainPage() {");
        pw.println("  window.location.href = '/';");
        pw.println("}");
        pw.println("function goToList() {");
        pw.println("  window.location.href = '/list';");
        pw.println("}");
        pw.println("function sortByName() {");
        pw.println("  window.location.href = '/sort?type=name';");
        pw.println("}");
        pw.println("function sortByYear() {");
        pw.println("  window.location.href = '/sort?type=year';");
        pw.println("}");
        pw.println("</script>");

        pw.println("</head>");
        pw.println("<body>");

        pw.println("<h1 onclick='goToList()' style='text-decoration: underline; cursor: pointer;'>도서 목록</h1>");

        pw.println("<div class='search-form'>");
        pw.println("<form action='/search' method='GET'>");
        //pw.println("<label for='search-category'>검색 항목:</label>");
        pw.println("<select id='search-category' name='category'>");
        pw.println("<option value='title'>책 이름</option>");
        pw.println("<option value='author'>저자</option>");
        pw.println("<option value='publisher'>출판사</option>");
        pw.println("<option value='isbn'>ISBN</option>");
        pw.println("</select>");
        pw.println("<input type='text' name='search' placeholder='검색어'/>");
        pw.println("<input type='submit' value='검색'/>");
        pw.println("</form>");
        pw.println("</div>");

        pw.println("<div class='button-container'>");
        pw.println("<button onclick='sortByName()'>이름 정렬</button>");
        pw.println("<button onclick='sortByYear()'>연도 정렬</button>");
        pw.println("</div>");

        pw.println("<table>");
        pw.println("<tr>");
        pw.println("<th>이름</th>");
        pw.println("<th>저자</th>");
        pw.println("<th>출판사</th>");
        pw.println("<th>출시 연도</th>");
        pw.println("<th>수량</th>");
        pw.println("<th>삭제</th>");
        pw.println("</tr>");

        List<Library> libraryList = new ArrayList<>();

        if (request.getAttribute("searchResults") == null) {
            libraryList = libraryService.findAll();
        } else if(request.getAttribute("searchResults")!=null){
            libraryList = (List<Library>) request.getAttribute("searchResults");
        }

        if (request.getAttribute("sortedLibraryList") != null) {
            libraryList = (List<Library>) request.getAttribute("sortedLibraryList");
        }

        for (Library library : libraryList) {
            pw.println("<tr>");
            pw.println("<td><a href='/list/" + library.getId() + "'>" + library.getName() + "</a></td>");
            pw.println("<td>" + library.getAuthor() + "</td>");
            pw.println("<td>" + library.getPublisher() + "</td>");
            pw.println("<td>" + library.getReleaseYear() + "년" + "</td>");
            pw.println("<td>" + library.getCount() + "권" + "</td>");

            pw.println("<input type='hidden' name='id' value='" + library.getId() + "'/>");
            pw.println("<td><a href='delete?id=" + library.getId() + "'>삭제</a></td>");

            pw.println("</tr>");
        }

        pw.println("</table>");

        pw.println("<div class='button-container'>");
        pw.println("<button onclick='goToMainPage()'>메인페이지</button>"); //
        pw.println("</div>");

        pw.println("</body>");
        pw.println("</html>");
    }
}