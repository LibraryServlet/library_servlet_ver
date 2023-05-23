<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>도서 추가</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        #regbox {
            width: 300px;
            background-color: #f2f2f2;
            padding: 20px;
        }

        label {
            display: block;
            width: 100px;
            float: left;
            color: #333;
        }

        input[type="text"] {
            width: 180px;
            padding: 5px;
        }

        input[type="submit"],
        input[type="reset"] {
            padding: 5px 10px;
            margin-top: 10px;
            background-color: #4caf50;
            color: #fff;
            border: none;
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
    <fieldset id="regbox">
        <%--@declare id="name"--%><%--@declare id="author"--%><%--@declare id="publisher"--%><%--@declare id="isbn"--%><%--@declare id="releaseyear"--%><%--@declare id="count"--%><%--@declare id="summary"--%><%--@declare id="image"--%><%--@declare id="category"--%><legend style="color: #555;">도서 추가</legend>
        <label for="name">책 이름</label>
        <label>
            <input type="text" name="name"/>
        </label><br/>
        <label for="author">작가</label>
        <label>
            <input type="text" name="author"/>
        </label><br/>
        <label for="publisher">출판사</label>
        <label>
            <input type="text" name="publisher"/>
        </label><br/>
        <label for="isbn">ISBN</label>
        <label>
            <input type="text" name="isbn"/>
        </label><br/>
        <label for="releaseYear">출판 연도</label>
        <label>
            <input type="text" name="releaseYear"/>
        </label><br/>
        <label for="count">수량</label>
        <label>
            <input type="text" name="count"/>
        </label><br/>
        <label for="summary">요약</label>
        <label>
            <input type="text" name="summary"/>
        </label><br/>
        <label for="image">이미지</label>
        <label>
            <input type="text" name="image"/>
        </label><br/>
        <label for="category">카테고리</label>
        <label>
            <input type="text" name="category"/>
        </label><br/>
        <input type="submit" value="추가">
        <input type="reset" value="취소" onclick="goBack()"/>
    </fieldset>
</form>
</body>
</html>