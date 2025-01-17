package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.address.vo.AddressVO;

public class AddressController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 클라이언트에서 받은 데이터를 처리
        String address = request.getParameter("address");
        double latitude = Double.parseDouble(request.getParameter("latitude"));
        double longitude = Double.parseDouble(request.getParameter("longitude"));
        
        System.out.println("주소: " + address);
        System.out.println("위도: " + latitude);
        System.out.println("경도: " + longitude);

        // AddressVO에 데이터 저장
        AddressVO addressVO = new AddressVO(address, latitude, longitude);
        request.setAttribute("addressVO", addressVO);

        // 데이터를 처리한 후 JSP로 포워딩
        return "/jsp/address/submit.jsp"; // 결과 페이지로 이동
    }
}
