<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>마이페이지</title>
    <style>
        form { width: 300px; margin: 50px auto; display: flex; flex-direction: column; gap: 10px; }
        input, select, button { padding: 10px; font-size: 14px; }
        button { background-color: #007bff; color: white; border: none; cursor: pointer; }
        button:hover { background-color: #0056b3; }
        input[readonly] {
            color: gray; /* 읽기 전용 필드 글자색 변경 */
            background-color: #f3f3f3; /* 읽기 전용 배경색 설정 */
        }
        .center-button {
            margin: 20px auto;
            text-align: center;
        }
        .center-button a, .center-button button {
            display: inline-block;
            padding: 10px 20px;
            text-decoration: none;
            background-color: #dc3545; /* 탈퇴 버튼 색상 */
            color: white;
            border-radius: 5px;
        }
        .center-button button:hover {
            background-color: #c82333;
        }
        .center-button a {
            background-color: #28a745;
        }
        .center-button a:hover {
            background-color: #218838;
        }
        .form-actions { /* 버튼 그룹을 추가하여 레이아웃을 조정 */
            display: flex;
            gap: 10px;
            justify-content: center; /* 버튼을 중앙에 정렬 */
        }
    </style>
</head>
<body>
    <h2 style="text-align: center;">내 정보 열람, 수정</h2>
    <form action="${pageContext.request.contextPath}/member/update.do" method="post">
        <input type="hidden" name="no" value="${sessionScope.loginMember.memberNo}">
        <input type="text" name="id" value="${sessionScope.loginMember.memberId}" readonly>
        <input type="password" name="password" placeholder="********" readonly>
        <input type="text" name="name" value="${sessionScope.loginMember.name}" required>
        <input type="email" name="email" value="${sessionScope.loginMember.email}">
        <select name="area" required>
            <!-- 지역 선택 옵션 -->
            <option value="서울" ${sessionScope.loginMember.area == '서울' ? 'selected' : ''}>서울</option>
            <option value="강원" ${sessionScope.loginMember.area == '강원' ? 'selected' : ''}>강원</option>
            <option value="경기" ${sessionScope.loginMember.area == '경기' ? 'selected' : ''}>경기</option>
            <option value="경남" ${sessionScope.loginMember.area == '경남' ? 'selected' : ''}>경남</option>
            <option value="경북" ${sessionScope.loginMember.area == '경북' ? 'selected' : ''}>경북</option>
            <option value="광주" ${sessionScope.loginMember.area == '광주' ? 'selected' : ''}>광주</option>
            <option value="대구" ${sessionScope.loginMember.area == '대구' ? 'selected' : ''}>대구</option>
            <option value="대전" ${sessionScope.loginMember.area == '대전' ? 'selected' : ''}>대전</option>
            <option value="부산" ${sessionScope.loginMember.area == '부산' ? 'selected' : ''}>부산</option>
            <option value="세종" ${sessionScope.loginMember.area == '세종' ? 'selected' : ''}>세종</option>
            <option value="울산" ${sessionScope.loginMember.area == '울산' ? 'selected' : ''}>울산</option>
            <option value="인천" ${sessionScope.loginMember.area == '인천' ? 'selected' : ''}>인천</option>
            <option value="전남" ${sessionScope.loginMember.area == '전남' ? 'selected' : ''}>전남</option>
            <option value="전북" ${sessionScope.loginMember.area == '전북' ? 'selected' : ''}>전북</option>
            <option value="제주" ${sessionScope.loginMember.area == '제주' ? 'selected' : ''}>제주</option>
            <option value="충남" ${sessionScope.loginMember.area == '충남' ? 'selected' : ''}>충남</option>
            <option value="충북" ${sessionScope.loginMember.area == '충북' ? 'selected' : ''}>충북</option>
        </select>
        <div class="form-actions">
            <button type="submit">수정하기</button>
            <button type="submit" formaction="${pageContext.request.contextPath}/member/delete.do" formmethod="post" onclick="return confirm('정말로 회원 탈퇴를 하시겠습니까?');">회원 탈퇴</button>
        </div>
    </form>
    <div class="center-button">
        <a href="${pageContext.request.contextPath}/index.do">처음으로</a>
    </div>
</body>
</html>