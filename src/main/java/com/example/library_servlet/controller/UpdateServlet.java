package com.example.library_servlet.controller;

import com.example.library_servlet.entity.Library;
import com.example.library_servlet.service.LibraryService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

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
        pw.println("<head>");
        pw.println("<title>도서 수정</title>");

        pw.println("<script>\n" +
                "function validateForm() {\n" +
                "    let releaseYearInput = document.getElementsByName('releaseYear')[0];\n" +
                "\n" +
                "    let releaseYear = parseInt(releaseYearInput.value);\n" +
                "\n" +
                "    if (isNaN(releaseYear)) {\n" +
                "        alert('출판 연도는 숫자만 입력해야 합니다.');\n" +
                "        releaseYearInput.value = '';\n" +
                "        releaseYearInput.focus();\n" +
                "        return false;\n" +
                "    }\n" +
                "\n" +
                "    return true;\n" +
                "}\n" +
                "</script>");

        pw.println("<style>");
        pw.println("@font-face {\n" +
                "            font-family: 'HANAMDAUM';\n" +
                "            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-2@1.0/HANAMDAUM.woff2') format('woff2');\n" +
                "            font-weight: 400;\n" +
                "            font-style: normal;\n" +
                "        }");
        pw.println("body {\n" +
                "            text-decoration: none;\n" +
                "            font-family: 'HANAMDAUM', Arial, sans-serif;\n" +
                "            display: flex;\n" +
                "            justify-content: center;\n" +
                "            align-items: center;\n" +
                "            height: 100vh;\n" +
                "            background-color: #f5f5f5;\n" +
                "        }");
        pw.println("#regbox {\n" +
                "            width: 400px;\n" + "height: 100vh;"+
                "            background-color: #fff;\n" +
                "            padding: 20px;\n" +
                "            border: 1px solid #ccc;\n" +
                "            border-radius: 5px;\n" +
                "            margin: auto;\n" +
                "            margin-top: 10%; \n" +
                "        }");
        pw.println("#regbox textarea{" +
                "resize: none;" +
                "width: 100%}");
        pw.println("label {");
        pw.println("  display: block;");
        pw.println("  margin-top: 10px;");
        pw.println("  margin-bottom: 10px;");
        pw.println("}");
        pw.println("#regbox input[type='text'], input[type='number'], textarea {");
        pw.println("width: 100%;\n" +
                "            height: 32px;\n" +
                "            font-size: 15px;\n" +
                "            border: 0;\n" +
                "            border-radius: 15px;\n" +
                "            outline: none;\n" +
                "            padding-left: 10px;\n" +
                "            background-color: rgb(233, 233, 233);" +
                "            margin: auto" +
                "}");
        pw.println("textarea {");
        pw.println("  height: 150px;");
        pw.println("}");
        pw.println("h1 { text-align: center; }");
        pw.println("input[type='submit'] {");
        pw.println("  margin-bottom: 50px;");
        pw.println("  margin-top: 50px;");
        pw.println("  margin-left: 150px;");
        pw.println("  padding: 8px 12px;");
        pw.println("  font-size: 16px;");
        pw.println("  background-color: #4CAF50;");
        pw.println("  border: none;");
        pw.println("  border-radius: 4px;");
        pw.println("  color: white;");
        pw.println("}");
        pw.println("<style>");
        pw.println("label { font-weight: bold; }");
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
        pw.println("input[type='text'] { width: 300px; padding: 5px; }");
        pw.println("input[type='submit'] { " +
                "background-color: #4CAF50; " +
                "margin-top: 50px; " +
                "color: white; " +
                "padding: 10px 20px; " +
                "border: none; " +
                "cursor: pointer; " +
                "margin-bottom: 15px;" +
                "font-family: 'HANAMDAUM', Arial, sans-serif;}");
        pw.println("</style>");

        pw.println("</head>");
        pw.println("<body>");

        pw.println("<form method='post' action='updateok' onsubmit='return validateForm()'>");
        pw.println("<div id=\"regbox\">");
        pw.println("<h1>도서 수정</h1>");
        pw.println("<input type='hidden' name='id' value='" + id + "'>");
        pw.println("<label for='name'>책 이름</label>");
        pw.println("<input type='text' name='name' value='" + lib.getName() + "'><br/>");
        pw.println("<label for='author'>작가</label>");
        pw.println("<input type='text' name='author' value='" + lib.getAuthor() + "'><br/>");
        pw.println("<label for='publisher'>출판사</label>");
        pw.println("<input type='text' name='publisher' value='" + lib.getPublisher() + "'><br/>");
        pw.println("<label for='isbn'>ISBN</label>");
        pw.println("<input type='text' name='isbn' value='" + lib.getIsbn() + "'><br/>");
        pw.println("<label for='releaseYear'>출판 연도</label>");
        pw.println("<input type='number' name='releaseYear' value='" + lib.getReleaseYear() + "'><br/>");
        pw.println("<input type='hidden' name='count' value='" + lib.getCount() + "'>");
        pw.println("<label for='summary'>요약</label>");
        pw.println("<textarea name='summary'>" + lib.getSummary() + "</textarea><br/>");
        pw.println("<label for='image'>이미지</label>");
        pw.println("<input type='text' name='image' value='" + lib.getImage() + "'><br/>");
        pw.println("<label for='category'>카테고리</label>");
        pw.println("<input type='text' name='category' value='" + lib.getCategory() + "'><br/>");

        pw.println("<input type='submit' value='수정 완료'/><br/>");
        pw.println("</form>");

        pw.println("</body>");
        pw.println("</html>");
        pw.close();
    }
}