<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 작성</title>
    <style>
        form { width: 60%; margin: 20px auto; display: flex; flex-direction: column; gap: 10px; }
        input, textarea, select, button { padding: 10px; font-size: 14px; }
        button { background-color: #007bff; color: white; border: none; cursor: pointer; }
        button:hover { background-color: #0056b3; }
    </style>
</head>
<body>
    <h2 style="text-align: center;">게시글 작성</h2>
    <form action="${pageContext.request.contextPath}/board/write.do">
        <input type="hidden" name="boardMemberNo" value="${sessionScope.loginMember.memberNo}">
        <input type="text" name="boardTitle" placeholder="제목" required>
        <textarea name="boardContent" placeholder="내용" rows="10" required></textarea>
        <select name="boardArea" required>
            <option value="강원" ${param.area == '강원' ? 'selected' : ''}>강원</option>
            <option value="경기" ${param.area == '경기' ? 'selected' : ''}>경기</option>
            <option value="경남" ${param.area == '경남' ? 'selected' : ''}>경남</option>
            <option value="경북" ${param.area == '경북' ? 'selected' : ''}>경북</option>
            <option value="대구" ${param.area == '대구' ? 'selected' : ''}>대구</option>
            <option value="대전" ${param.area == '대전' ? 'selected' : ''}>대전</option>
            <option value="부산" ${param.area == '부산' ? 'selected' : ''}>부산</option>
            <option value="서울" ${param.area == '서울' ? 'selected' : ''}>서울</option>
            <option value="세종" ${param.area == '세종' ? 'selected' : ''}>세종</option>
            <option value="울산" ${param.area == '울산' ? 'selected' : ''}>울산</option>
            <option value="인천" ${param.area == '인천' ? 'selected' : ''}>인천</option>
            <option value="전남" ${param.area == '전남' ? 'selected' : ''}>전남</option>
            <option value="전북" ${param.area == '전북' ? 'selected' : ''}>전북</option>
            <option value="제주" ${param.area == '제주' ? 'selected' : ''}>제주</option>
            <option value="충남" ${param.area == '충남' ? 'selected' : ''}>충남</option>
            <option value="충북" ${param.area == '충북' ? 'selected' : ''}>충북</option>
            <option value="광주" ${param.area == '광주' ? 'selected' : ''}>광주</option>
        </select>
        <button type="submit">작성하기</button>
    </form>
</body>
</html>
