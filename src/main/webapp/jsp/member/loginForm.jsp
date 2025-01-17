<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
    <style>
        form { width: 300px; margin: 50px auto; display: flex; flex-direction: column; gap: 10px; }
        input, button { padding: 10px; font-size: 14px; }
        button { background-color: #007bff; color: white; border: none; cursor: pointer; }
        button:hover { background-color: #0056b3; }
        .error { color: red; font-size: 12px; text-align: center; }
        .center-button {
            margin: 20px auto;
            text-align: center;
        }
        .center-button a, .center-button button {
            display: inline-block;
            padding: 10px 20px;
            text-decoration: none;
            background-color: #FEE500; /* 카카오 컬러 */
            color: black; /* 글자색 검정 */
            border-radius: 5px;
        }
        .center-button a:hover, .center-button button:hover {
            background-color: #E0C800;
        }
    </style>
    <script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
    <script type="text/javascript">
        // 카카오 SDK 초기화
        Kakao.init('e41bbd12f048f22aa52f278fd46120ee'); // 앱 생성 시 발급받은 키 입력

        // 카카오 로그인 버튼을 클릭 이벤트에 연결
        function loginWithKakao() {
            Kakao.Auth.login({
                success: function(authObj) {
                    // 로그인 성공 시, 예를 들어 서버로 토큰을 보내 세션을 생성할 수 있습니다.
                    window.location.href = '${pageContext.request.contextPath}/member/kakaoLogin.do?token=' + authObj.access_token;
                },
                fail: function(err) {
                    alert(JSON.stringify(err));
                }
            });
        }
    </script>
</head>
<body>
    <h2 style="text-align: center;">로그인</h2>
    <c:if test="${not empty errorMsg}">
        <p class="error">${errorMsg}</p>
    </c:if>
    <form action="${pageContext.request.contextPath}/member/login.do" method="post">
        <input type="text" name="id" placeholder="ID" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">로그인</button>
    </form>
    <div class="center-button">
        <button onclick="loginWithKakao();" style="background-color: #FEE500; color: black;">카카오 로그인</button>
    </div>
    <div class="center-button">
	    <a href="${pageContext.request.contextPath}/index.do" style="display: inline-block; padding: 10px 20px; text-decoration: none; background-color: #28a745; color: white; border-radius: 5px;">처음으로</a>
	</div>
</body>
</html>
