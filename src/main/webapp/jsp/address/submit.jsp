<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>주소 결과</title>
</head>
<body>
    <h2>주소 결과</h2>
    <p>입력한 주소: ${addressVO.address}</p>
    <p>위도: ${addressVO.latitude}</p>
    <p>경도: ${addressVO.longitude}</p>
    <a href="${pageContext.request.contextPath}/index.do">다시 입력하기</a>
</body>
</html>
