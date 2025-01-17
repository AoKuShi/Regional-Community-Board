<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 관리</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        table, th, td {
            border: 1px solid #ccc;
        }
        th, td {
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #f4f4f4;
        }
        .btn {
            text-decoration: none;
            padding: 5px 10px;
            border: 1px solid #007bff;
            color: #007bff;
            border-radius: 5px;
            margin: 5px;
            display: inline-block;
        }
        .btn:hover {
            background-color: #007bff;
            color: #fff;
        }
    </style>
</head>
<body>
    <h1>회원 관리</h1>
    <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>아이디</th>
                <th>이름</th>
                <th>이메일</th>
                <th>지역</th>
                <th>관리자 여부</th>
                <th>가입일</th>
                <th>관리</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="member" items="${memberList}">
                <tr>
                    <td>${member.memberNo}</td>
                    <td>${member.memberId}</td>
                    <td>${member.name}</td>
                    <td>${member.email}</td>
                    <td>${member.area}</td>
                    <td>${member.isAdmin}</td>
                    <td>${member.startDate}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/member/adminMemberDelete.do" method="post">
                            <input type="hidden" name="no" value="${member.memberNo}" />
                            <button type="submit" class="btn">삭제</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="center-button">
		<a href="${pageContext.request.contextPath}/index.do" style="display: inline-block; padding: 10px 20px; text-decoration: none; background-color: #28a745; color: white; border-radius: 5px;">처음으로</a>
	</div>
</body>
</html>
