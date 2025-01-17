package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.member.service.MemberService;

public class AdminMemberDeleteController implements Controller {

    private MemberService memberService = new MemberService();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 회원 번호 파라미터 추출
        String noStr = request.getParameter("no");
        int memberNo = Integer.parseInt(noStr);
        
        // 회원 삭제 로직 호출
        memberService.deleteMember(memberNo);

        // 삭제 후 회원 관리 페이지로 리다이렉트
        return "redirect:/member/adminMember.do";
    }
}
