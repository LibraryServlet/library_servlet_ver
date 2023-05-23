<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>도서 관리</title>
    <style>
        @font-face {
            font-family: 'HANAMDAUM';
            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-2@1.0/HANAMDAUM.woff2') format('woff2');
            font-weight: 400;
            font-style: normal;
        }

        body {
            background-color: #f2f2f2;
            background-image: url("https://ifh.cc/g/KMY6r2.jpg");
            background-size: cover;
            font-family: 'HANAMDAUM', Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .welcome {
            float: right;
            margin-top: 100px;
            border: red;
        }

        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }

        li {
            margin-right: 10px;
            margin-bottom: 10px;
        }

        li a {
            display: block;
            padding: 10px;
            background-color: #4caf50;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
            text-align: center;
        }

        li a:hover {
            background-color: #45a049;
            transition: 0.3s ease-in;
        }
    </style>
</head>
<body>
<div class="welcome">
    <h1>환영합니다!</h1>
    <ul>
        <li><a href="insert.jsp">도서 추가</a></li>
        <li><a href="list">도서 목록</a></li>
    </ul>
</div>
</body>
</html>
