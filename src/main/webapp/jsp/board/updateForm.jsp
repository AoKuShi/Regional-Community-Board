<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 수정</title>
    <style>
        form { width: 60%; margin: 20px auto; display: flex; flex-direction: column; gap: 10px; }
        input, textarea, select, button { padding: 10px; font-size: 14px; }
        button { background-color: #007bff; color: white; border: none; cursor: pointer; }
        button:hover { background-color: #0056b3; }
    </style>
</head>
<body>
    <h2 style="text-align: center;">게시글 수정</h2>
	<form action="${pageContext.request.contextPath}/board/update.do" method="post">
	    <input type="hidden" name="boardId" value="${boardVO.boardId}">
	    <input type="hidden" name="boardMemberNo" value="${sessionScope.loginMember.memberNo}">
	    <input type="text" name="boardTitle" placeholder="제목" value="${boardVO.boardTitle}" required>
	    <textarea name="boardContent" placeholder="내용" rows="10" required>${boardVO.boardContent}</textarea>
	    <select name="boardArea" required>
	        <option value="강원" ${boardVO.boardArea == '강원' ? 'selected' : ''}>강원</option>
	        <option value="경기" ${boardVO.boardArea == '경기' ? 'selected' : ''}>경기</option>
	        <option value="경남" ${boardVO.boardArea == '경남' ? 'selected' : ''}>경남</option>
	        <option value="경북" ${boardVO.boardArea == '경북' ? 'selected' : ''}>경북</option>
	        <option value="대구" ${boardVO.boardArea == '대구' ? 'selected' : ''}>대구</option>
	        <option value="대전" ${boardVO.boardArea == '대전' ? 'selected' : ''}>대전</option>
	        <option value="부산" ${boardVO.boardArea == '부산' ? 'selected' : ''}>부산</option>
	        <option value="서울" ${boardVO.boardArea == '서울' ? 'selected' : ''}>서울</option>
	        <option value="세종" ${boardVO.boardArea == '세종' ? 'selected' : ''}>세종</option>
	        <option value="울산" ${boardVO.boardArea == '울산' ? 'selected' : ''}>울산</option>
	        <option value="인천" ${boardVO.boardArea == '인천' ? 'selected' : ''}>인천</option>
	        <option value="전남" ${boardVO.boardArea == '전남' ? 'selected' : ''}>전남</option>
	        <option value="전북" ${boardVO.boardArea == '전북' ? 'selected' : ''}>전북</option>
	        <option value="제주" ${boardVO.boardArea == '제주' ? 'selected' : ''}>제주</option>
	        <option value="충남" ${boardVO.boardArea == '충남' ? 'selected' : ''}>충남</option>
	        <option value="충북" ${boardVO.boardArea == '충북' ? 'selected' : ''}>충북</option>
	        <option value="광주" ${boardVO.boardArea == '광주' ? 'selected' : ''}>광주</option>
	    </select>
	    <button type="submit">수정하기</button>
	</form>
</body>
</html>
