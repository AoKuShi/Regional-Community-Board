<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입 완료</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            text-align: center;
            padding: 50px;
        }
        h2 {
            color: #28a745;
        }
        p {
            color: #333;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            font-size: 14px;
            text-decoration: none;
            background-color: #007bff;
            color: white;
            border-radius: 5px;
        }
        a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h2>회원가입이 완료되었습니다!</h2>
    <p>축하합니다. 회원가입이 성공적으로 완료되었습니다.</p>
    <p>서비스 이용을 위해 아래 버튼을 클릭하여 로그인해주세요.</p>
    <a href="${pageContext.request.contextPath}/member/loginForm.do">로그인 페이지로 이동</a>
</body>
</html>
