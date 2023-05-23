<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>도서 추가</title>
    <style>
        body::before {
            position: fixed;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background-image: url("https://ifh.cc/g/KMY6r2.jpg");
            background-size: cover;
            -webkit-filter: blur(5px);
            -moz-filter: blur(5px);
            -o-filter: blur(5px);
            -ms-filter: blur(5px);
            filter: blur(5px);
            transform: scale(1.02);
            z-index: -1;
            content: "";
        }

        #regbox {
            width: 400px;
            background-color: #fff;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin: auto;
        }

        label {
            display: block;
            margin-bottom: 10px;
            color: #333;
        }

        input[type="text"] {
            width: 100%;
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"],
        input[type="reset"] {
            padding: 5px 10px;
            margin-top: 10px;
            background-color: #4caf50;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover,
        input[type="reset"]:hover {
            background-color: #45a049;
        }
    </style>
    <script>
        function goBack() {
            history.back();
        }
    </script>
</head>
<body>
<form method="get" action="insert">
    <div id="regbox">
        <%--@declare id="name"--%><%--@declare id="author"--%><%--@declare id="publisher"--%><%--@declare id="isbn"--%><%--@declare id="releaseyear"--%><%--@declare id="count"--%><%--@declare id="summary"--%><%--@declare id="image"--%><%--@declare id="category"--%>
        <h2 style="color: #555;">도서 추가</h2>
        <label for="name">책 이름</label>
        <input type="text" name="name" required/><br/>
        <label for="author">작가</label>
        <input type="text" name="author" required/><br/>
        <label for="publisher">출판사</label>
        <input type="text" name="publisher" required/><br/>
        <label for="isbn">ISBN</label>
        <input type="text" name="isbn" required/><br/>
        <label for="releaseYear">출판 연도</label>
        <input type="text" name="releaseYear" required/><br/>
        <label for="count">수량</label>
        <input type="text" name="count" required/><br/>
        <label for="summary">요약</label>
        <input type="text" name="summary" required/><br/>
        <label for="image">이미지</label>
        <input type="text" name="image" required/><br/>
        <label for="category">카테고리</label>
        <input type="text" name="category" required/><br/>
        <input type="submit" value="추가">
        <input type="reset" value="취소" onclick="goBack()"/>
    </div>
</form>
</body>
</html>