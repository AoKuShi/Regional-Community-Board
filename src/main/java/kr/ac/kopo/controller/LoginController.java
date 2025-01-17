package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.MemberVO;

public class LoginController implements Controller {

    private MemberService memberService;

    public LoginController() {
        this.memberService = new MemberService();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 요청에서 아이디와 비밀번호 가져오기
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        // MemberVO 객체 생성 및 설정
        MemberVO member = new MemberVO();
        member.setMemberId(id);
        member.setPassword(password);
        
        
        // 회원 서비스 호출
        MemberVO loginMember = memberService.login(member);

        if (loginMember != null) {
            // 로그인 성공 시 세션에 사용자 정보 저장
            HttpSession session = request.getSession();
            session.setAttribute("loginMember", loginMember);

            // 메인 페이지로 리다이렉트
            return "redirect:/index.do";
        } else {
            // 로그인 실패 시 에러 메시지와 함께 로그인 페이지로 이동
            request.setAttribute("errorMessage", "아이디 또는 비밀번호가 올바르지 않습니다.");
            return "/jsp/member/loginForm.jsp";
        }
    }

}
