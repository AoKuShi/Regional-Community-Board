<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${param.boardArea} 게시판</title>
    <style>
        body { font-family: Arial, sans-serif; text-align: center; margin-top: 50px; }
        table { width: 80%; margin: 20px auto; border-collapse: collapse; }
        th, td { border: 1px solid #ccc; padding: 10px; text-align: center; }
        th { background-color: #f4f4f4; }
        a { text-decoration: none; color: #007bff; }
        a:hover { text-decoration: underline; }
        .btn { text-decoration: none; padding: 10px 20px; border: 1px solid #007bff; color: #007bff; border-radius: 5px; margin: 10px; }
        .btn:hover { background-color: #007bff; color: #fff; }
        .btn-group { margin-top: 20px; }
        .pagination { margin-top: 20px; }
        .pagination a { margin: 0 5px; text-decoration: none; padding: 5px 10px; border: 1px solid #007bff; border-radius: 3px; color: #007bff; }
        .pagination a.active, .pagination a:hover { background-color: #007bff; color: #fff; }
    </style>
</head>
<body>
    <!-- currentPage 기본값을 1로 설정 -->
    <c:set var="currentPage" value="${param.page != null ? param.page : totalPages}" />
    
    <h2>${param.boardArea} 게시판</h2>
    <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>조회수</th>
                <th>지역</th>
                <th>좋아요</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="board" items="${boardList}" varStatus="status">
                <c:if test="${status.index < 30}">
                    <tr>
                        <td>${board.boardId}</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/board/view.do" method="post" style="margin: 0;">
                                <input type="hidden" name="boardId" value="${board.boardId}">
                                <input type="hidden" name="boardArea" value="${param.boardArea}">
                                <input type="hidden" name="boardNo" value="${board.boardMemberNo}">
                                <input type="hidden" name="memberNo" value="${sessionScope.loginMember.memberNo}">
                                <button type="submit" style="background: none; border: none; color: #007bff; text-decoration: underline; cursor: pointer;">
                                    ${board.boardTitle}
                                </button>
                            </form>
                        </td>
                        <td>${board.memberNameByBoardMemberNo}</td>
                        <td>${board.boardCreateDate}</td>
                        <td>${board.boardViewCount}</td>
                        <td>${board.boardArea}</td>
                        <td>${board.boardGoodCount}</td>
                    </tr>
                </c:if>
            </c:forEach>
        </tbody>
    </table>

	<div class="pagination">
	    <c:forEach var="i" begin="1" end="${totalPages}">
	        <a href="${pageContext.request.contextPath}/board/list.do?boardArea=${param.boardArea}&page=${i}"
	           class="${currentPage == i ? 'active' : ''}">
	            ${i}
	        </a>
	    </c:forEach>
	</div>

    <div class="btn-group">
        <c:if test="${not empty sessionScope.loginMember}">
            <a class="btn" href="${pageContext.request.contextPath}/board/writeForm.do?area=${param.boardArea}">게시글 작성</a>
        </c:if>
        <a class="btn" href="${pageContext.request.contextPath}/index.do">처음으로</a>
    </div>
</body>
</html>
