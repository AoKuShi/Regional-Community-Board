package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.member.service.MemberService;

public class MemberDeleteController implements Controller {
    private MemberService memberService = new MemberService();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int memberNo = Integer.parseInt(request.getParameter("no"));
        memberService.deleteMember(memberNo); // 회원 삭제 로직 호출
        HttpSession session = request.getSession(false); // 존재하는 세션만 가져오기
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/index.do"; // 메인 페이지로 리다이렉트
    }
}
