<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>회원가입</title>
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
        <%--@declare id="name"--%>
        <legend style="color: #555;">회원가입</legend>
        <label for="name">이름</label>
        <label>
            <input type="text" name="name"/>
        </label><br/>
        <input type="submit" value="가입">
        <input type="reset" value="취소" onclick="goBack()"/>
    </fieldset>
</form>
</body>
</html>