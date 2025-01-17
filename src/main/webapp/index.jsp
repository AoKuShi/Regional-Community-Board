<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>지역별 게시판</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }
        #map {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            z-index: 1;
        }
        .content {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            z-index: 2;
            background-color: rgba(255, 255, 255, 0.8);
            padding: 20px 0;
            text-align: center;
            box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
        }
        .content h1 {
            margin: 0;
            font-size: 2em;
            color: #333;
        }
        .content p {
            margin: 10px 0;
            font-size: 1em;
            color: #666;
        }
        .btn-group {
            margin-top: 20px;
        }
        .btn-group a {
            text-decoration: none;
            padding: 10px 20px;
            border: 1px solid #007bff;
            color: #007bff;
            border-radius: 5px;
            margin: 5px;
            display: inline-block;
        }
        .btn-group a:hover {
            background-color: #007bff;
            color: #fff;
        }
        .area {
            position: absolute;
            width: auto;
            padding: 5px;
            border: 1px solid #004c80;
            background: #fff;
            color: #004c80;
            font-size: 12px;
            font-weight: bold;
            text-align: center;
        }
        #selectedArea {
            margin-top: 10px;
            padding: 5px;
            font-size: 1em;
            width: 80%;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <div id="map"></div>
    <div class="content">
        <h1>지역별 게시판</h1>
        <p>한국의 각 지역별로 게시글을 열람, 작성할 수 있는 서비스입니다.</p>
        <select id="selectedArea">
            <option value="전체">(전체)</option>
            <option value="강원" ${sessionScope.loginMember.area == '강원' ? 'selected' : ''}>강원</option>
            <option value="경기" ${sessionScope.loginMember.area == '경기' ? 'selected' : ''}>경기</option>
            <option value="경남" ${sessionScope.loginMember.area == '경남' ? 'selected' : ''}>경남</option>
            <option value="경북" ${sessionScope.loginMember.area == '경북' ? 'selected' : ''}>경북</option>
            <option value="광주" ${sessionScope.loginMember.area == '광주' ? 'selected' : ''}>광주</option>
            <option value="대구" ${sessionScope.loginMember.area == '대구' ? 'selected' : ''}>대구</option>
            <option value="대전" ${sessionScope.loginMember.area == '대전' ? 'selected' : ''}>대전</option>
            <option value="부산" ${sessionScope.loginMember.area == '부산' ? 'selected' : ''}>부산</option>
            <option value="서울" ${sessionScope.loginMember.area == '서울' ? 'selected' : ''}>서울</option>
            <option value="세종" ${sessionScope.loginMember.area == '세종' ? 'selected' : ''}>세종</option>
            <option value="울산" ${sessionScope.loginMember.area == '울산' ? 'selected' : ''}>울산</option>
            <option value="인천" ${sessionScope.loginMember.area == '인천' ? 'selected' : ''}>인천</option>
            <option value="전남" ${sessionScope.loginMember.area == '전남' ? 'selected' : ''}>전남</option>
            <option value="전북" ${sessionScope.loginMember.area == '전북' ? 'selected' : ''}>전북</option>
            <option value="제주" ${sessionScope.loginMember.area == '제주' ? 'selected' : ''}>제주</option>
            <option value="충남" ${sessionScope.loginMember.area == '충남' ? 'selected' : ''}>충남</option>
            <option value="충북" ${sessionScope.loginMember.area == '충북' ? 'selected' : ''}>충북</option>
        </select>
        <div class="btn-group">
            <c:choose>
                <c:when test="${not empty sessionScope.loginMember}">
                	<c:choose>
                		<c:when test="${sessionScope.loginMember.isAdmin == ''}">
                			<a href="#" class="btn" id="boardListLink">게시글 관리</a>
                			<a href="${pageContext.request.contextPath}/member/adminMember.do" class="btn">회원 관리</a>
                		</c:when>
                		<c:otherwise>
                			<a href="#" class="btn" id="boardListLink">게시판 보기</a>
                		</c:otherwise>
                	</c:choose>
                    <a href="${pageContext.request.contextPath}/member/logout.do" class="btn">로그아웃</a>
                    <a href="${pageContext.request.contextPath}/member/updateForm.do" class="btn">마이페이지</a>
                </c:when>
                <c:otherwise>
                    <a href="#" class="btn" id="boardListLink">게시판 보기</a>
                    <a href="${pageContext.request.contextPath}/member/loginForm.do" class="btn">로그인</a>
                    <a href="${pageContext.request.contextPath}/member/registerForm.do" class="btn">회원가입</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e41bbd12f048f22aa52f278fd46120ee"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        var mapContainer = document.getElementById('map'),
            mapOption = {
                center: new kakao.maps.LatLng(37.566826, 126.9786567), // 초기 중심좌표
                level: 12 // 초기 확대 레벨
            };

        var map = new kakao.maps.Map(mapContainer, mapOption),
            customOverlay = new kakao.maps.CustomOverlay({}),
            polygons = [],
            areas = [],
            selectedPolygon = null; // 현재 선택된 폴리곤

        // GeoJSON 데이터 로드
        function loadGeoData() {
            $.getJSON("json/sido.json", function (geojson) {
                geojson.features.forEach(function (feature) {
                    var area = createArea(feature);
                    areas.push(area);
                    displayArea(area);
                });
            });
        }

        function createArea(feature) {
            var coordinates = feature.geometry.coordinates[0].map(function (coord) {
                return new kakao.maps.LatLng(coord[1], coord[0]);
            });
            return {
                name: feature.properties.SIG_KOR_NM,
                path: coordinates,
                location: feature.properties.CTPRVN_CD
            };
        }

        function displayArea(area) {
            var polygon = new kakao.maps.Polygon({
                map: map,
                path: area.path,
                strokeWeight: 2,
                strokeColor: '#004c80',
                strokeOpacity: 0.8,
                fillColor: '#fff',
                fillOpacity: 0.7
            });

            polygons.push(polygon);

            kakao.maps.event.addListener(polygon, 'mouseover', function () {
                if (polygon !== selectedPolygon) {
                    polygon.setOptions({ fillColor: '#09f' });
                }
                customOverlay.setContent('<div class="area">' + area.name + '</div>');
                customOverlay.setPosition(polygon.getPath()[0]);
                customOverlay.setMap(map);
            });

            kakao.maps.event.addListener(polygon, 'mouseout', function () {
                if (polygon !== selectedPolygon) {
                    polygon.setOptions({ fillColor: '#fff' });
                }
                customOverlay.setMap(null);
            });

            kakao.maps.event.addListener(polygon, 'click', function () {
                if (selectedPolygon) {
                    selectedPolygon.setOptions({ fillColor: '#fff' });
                }
                selectedPolygon = polygon;
                polygon.setOptions({ fillColor: '#09f' });

                updateSelect(area.name);
                map.panTo(polygon.getPath()[0]);
            });
        }

        function updateSelect(selectedName) {
            var selectElement = document.getElementById('selectedArea');
            for (var i = 0; i < selectElement.options.length; i++) {
                if (selectElement.options[i].value === selectedName) {
                    selectElement.selectedIndex = i;
                    break;
                }
            }
        }

        document.getElementById('boardListLink').addEventListener('click', function () {
            var selectedArea = document.getElementById('selectedArea').value;
            var contextPath = '<%= request.getContextPath() %>';
            var targetUrl = contextPath + '/board/list.do?boardArea=' + encodeURIComponent(selectedArea);
            window.location.href = targetUrl;
        });

        document.getElementById('selectedArea').addEventListener('change', function () {
            var selectedAreaName = this.value;
            var matchedArea = areas.find(function (area) {
                return area.name === selectedAreaName;
            });

            if (matchedArea) {
                if (selectedPolygon) {
                    selectedPolygon.setOptions({ fillColor: '#fff' });
                }
                var matchedPolygon = polygons[areas.indexOf(matchedArea)];
                matchedPolygon.setOptions({ fillColor: '#09f' });
                selectedPolygon = matchedPolygon;

                map.panTo(matchedPolygon.getPath()[0]);
            }
        });

        loadGeoData();
    </script>
</body>
</html>
