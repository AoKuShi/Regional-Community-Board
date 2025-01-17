package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.member.service.MemberService;

public class UpdateFormController implements Controller {

	@Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute("loginMember") == null) {
            return "redirect:/member/loginForm.do";
        }
        return "/jsp/member/updateForm.jsp";
    }
}
