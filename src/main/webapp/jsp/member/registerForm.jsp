<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <style>
        form { width: 300px; margin: 50px auto; display: flex; flex-direction: column; gap: 10px; }
        input, select, button { padding: 10px; font-size: 14px; }
        button { background-color: #28a745; color: white; border: none; cursor: pointer; }
        button:hover { background-color: #218838; }
        .center-button {
            margin: 20px auto;
            text-align: center;
        }
        .center-button a {
            display: inline-block;
            padding: 10px 20px;
            text-decoration: none;
            background-color: #007bff;
            color: white;
            border-radius: 5px;
        }
        .center-button a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h2 style="text-align: center;">회원가입</h2>
    <form action="${pageContext.request.contextPath}/member/register.do" method="post">
        <input type="text" name="Id" placeholder="ID" required>
        <input type="password" name="password" placeholder="Password" required>
        <input type="text" name="name" placeholder="이름" required>
        <input type="email" name="email" placeholder="이메일">
        <select name="area" required>
            <option value="서울" selected>서울</option>
            <option value="강원">강원</option>
            <option value="경기">경기</option>
            <option value="경남">경남</option>
            <option value="경북">경북</option>
            <option value="광주">광주</option>
            <option value="대구">대구</option>
            <option value="대전">대전</option>
            <option value="부산">부산</option>
            <option value="세종">세종</option>
            <option value="울산">울산</option>
            <option value="인천">인천</option>
            <option value="전남">전남</option>
            <option value="전북">전북</option>
            <option value="제주">제주</option>
            <option value="충남">충남</option>
            <option value="충북">충북</option>
        </select>
        <button type="submit">회원가입</button>
    </form>
    <div class="center-button">
        <a href="${pageContext.request.contextPath}/index.do">처음으로</a>
    </div>
</body>
</html>