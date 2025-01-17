<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 보기</title>
    <style>
        .container { width: 80%; margin: 20px auto; }
        h2 { text-align: center; }
        .content { border: 1px solid #ccc; padding: 20px; margin: 20px 0; }
        .btn-group { display: flex; justify-content: center; gap: 10px; }
        a, button { text-decoration: none; padding: 10px 20px; border: 1px solid #007bff; color: #007bff; border-radius: 5px; background: none; cursor: pointer; }
        a:hover, button:hover { background-color: #007bff; color: #fff; }
        .replies { margin-top: 40px; border-top: 1px solid #ccc; padding-top: 20px; }
        .reply-item { border-bottom: 1px solid #eee; padding: 10px 0; }
    </style>
</head>
<body>
    <div class="container">
        <h2>${boardVO.boardTitle}</h2>
        <div class="content">
            <p>${boardVO.boardContent}</p>
        </div>
        <div class="btn-group">
            <!-- 목록으로 이동 버튼 -->
            <c:choose>
	            <c:when test="${empty param.boardArea}">
	            	<a href="${pageContext.request.contextPath}/board/list.do?boardArea=${area}">목록으로</a>
	            </c:when>
	            <c:otherwise>
	            	<a href="${pageContext.request.contextPath}/board/list.do?boardArea=${param.boardArea}">목록으로</a>
                </c:otherwise>
            </c:choose>
            
            
            <!-- <c:out value="${sessionScope.loginMember.isAdmin}" /> -->
            
            <!-- 삭제 및 수정 버튼 -->
            
            <c:choose>
	            <c:when test="${not empty sessionScope.loginMember && sessionScope.loginMember.memberNo == boardVO.boardMemberNo}">
	                <a href="${pageContext.request.contextPath}/board/delete.do?boardId=${boardVO.boardId}&boardArea=${param.boardArea}">삭제</a>
	                <a href="${pageContext.request.contextPath}/board/updateForm.do?boardId=${boardVO.boardId}&boardArea=${param.boardArea}">수정</a>
	            </c:when>
	            <c:when test="${not empty sessionScope.loginMember && sessionScope.loginMember.isAdmin == ''}">
				    <a href="${pageContext.request.contextPath}/board/delete.do?boardId=${boardVO.boardId}&boardArea=${param.boardArea}">삭제(관리자)</a>
				</c:when>
            </c:choose>
            

            <!-- 좋아요 버튼 -->
            <form action="${pageContext.request.contextPath}/board/like.do" method="post" style="display: inline;">
                <input type="hidden" name="boardId" value="${boardVO.boardId}">
                <button type="submit">좋아요 (${boardVO.boardGoodCount})</button>
            </form>
        </div>

		<!-- 답글 리스트 -->
		<div class="replies">
		    <h3>답글</h3>
		    <c:if test="${not empty replyList}">
		        <c:forEach var="reply" items="${replyList}">
		            <div class="reply-item">
		                <p><strong>${reply.memberNameByBoardMemberNo}:</strong> ${reply.boardTitle}</p>
		                <p style="font-size: 0.9em; color: #777;">${reply.boardCreateDate}</p>
		            </div>
		        </c:forEach>
		    </c:if>
		    <c:if test="${empty replyList}">
		        <p>답글이 없습니다. 첫 답글을 작성해보세요!</p>
		    </c:if>
		</div>


        <!-- 답글 작성 폼 (로그인 상태에서만 보이도록 설정) -->
        <c:if test="${not empty sessionScope.loginMember}">
            <form action="${pageContext.request.contextPath}/board/addReply.do" method="post" style="margin-top: 20px;">
                <input type="hidden" name="boardId" value="${boardVO.boardId}">
                <input type="hidden" name="loginMemberNo" value="${sessionScope.loginMember.memberNo}">
                <textarea name="replyContent" placeholder="답글을 입력하세요" rows="4" style="width: 100%; padding: 10px; margin-bottom: 10px;" required></textarea>
                <button type="submit" style="background-color: #007bff; color: white; padding: 10px 20px; border: none; border-radius: 5px;">답글 작성</button>
            </form>
        </c:if>
        <c:if test="${empty sessionScope.loginMember}">
            <p style="color: #777; text-align: center;">로그인 후 답글을 작성할 수 있습니다.</p>
        </c:if>
    </div>
</body>
</html>
