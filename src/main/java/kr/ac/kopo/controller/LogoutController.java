package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	// 세션 무효화
        HttpSession session = request.getSession(false); // 존재하는 세션만 가져오기
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/index.do";
    }
}
