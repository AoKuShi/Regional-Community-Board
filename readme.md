# 지역별 게시판 (Regional Community Board)

## 📅 프로젝트 기간
- 2024년 8월 ~ 2024년 9월 (약 1개월)

## 📝 프로젝트 설명
이 프로젝트는 지도 인터페이스를 기반으로 하는 지역별 게시판 웹 서비스입니다. 사용자는 지도를 통해 특정 지역을 선택하고, 해당 지역의 게시물을 확인하거나 새로운 게시물을 작성할 수 있습니다. 카카오 지도 API와 소셜 로그인 기능을 활용하여 사용자 경험을 향상시키는 데 중점을 두었습니다.

## ✨ 주요 기능
- **지도 기반 지역 선택**: 카카오 지도 API를 활용하여 대한민국 지도를 표시하고, 사용자가 시/도 단위로 지역을 선택할 수 있습니다.
- **지역별 게시판**: 선택된 지역에 따라 해당 지역의 게시물만 필터링하여 보여줍니다.
- **게시물 CRUD**: 사용자는 게시물을 작성, 조회, 수정, 삭제할 수 있습니다.
- **사용자 인증**: 일반 로그인 및 카카오 소셜 로그인을 지원합니다.
- **관리자 기능**: 관리자는 모든 회원 및 게시물을 관리할 수 있습니다.
- **반응형 웹**: 다양한 디바이스에서 최적화된 화면을 제공합니다.

## 🛠️ 사용 기술
- **Backend**: JSP, Jakarta Servlet, MyBatis, Oracle DB
- **Frontend**: jQuery, JavaScript, HTML/CSS
- **API**: Kakao Map API, Kakao Login API

## 🏛️ 시스템 아키텍처
이 프로젝트는 MVC(Model-View-Controller) 패턴을 기반으로 설계되었습니다.
- **Controller**: `DispatcherServlet`이 Front Controller 역할을 수행하며, `*.do` 형태의 모든 요청을 받아 `HandlerMapping`을 통해 적절한 Controller에 매핑합니다.
- **Model**: `Service`와 `DAO` 계층으로 비즈니스 로직과 데이터베이스 접근을 처리합니다. `MyBatis`를 사용하여 데이터베이스와 상호작용합니다.
- **View**: JSP를 사용하여 사용자 인터페이스를 렌더링합니다.

## 🔧 실행 방법
1. **데이터베이스 설정**: Oracle DB에 `MEMBER` 및 `BOARD` 테이블을 생성하고, `src/main/resources/kr/ac/kopo/mybatis/mybatis-config.xml` 파일에 데이터베이스 연결 정보를 설정합니다.
2. **API 키 설정**: `index.jsp` 파일과 `loginForm.jsp` 파일에 있는 Kakao API 키를 유효한 키로 변경합니다.
3. **서버 실행**: Apache Tomcat과 같은 서블릿 컨테이너에 프로젝트를 배포하고 서버를 실행합니다.
4. **애플리케이션 접속**: 웹 브라우저에서 `http://localhost:포트번호/프로젝트명`으로 접속합니다.