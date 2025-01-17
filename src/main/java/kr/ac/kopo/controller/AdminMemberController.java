package kr.ac.kopo.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.MemberVO;

public class AdminMemberController implements Controller {

    private MemberService memberService;

    public AdminMemberController() {
        this.memberService = new MemberService();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 회원 목록 조회
        List<MemberVO> memberList = memberService.selectAllMembers();

        // 조회된 회원 목록을 request 객체에 저장
        request.setAttribute("memberList", memberList);

        // memberList.jsp로 이동
        return "/jsp/member/memberList.jsp";
    }
}
