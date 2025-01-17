package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.MemberVO;

public class MemberRegisterController implements Controller {

    private MemberService memberService;

    public MemberRegisterController() {
        this.memberService = new MemberService();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 요청 파라미터 가져오기
        String memberId = request.getParameter("Id"); // 테이블의 MEMBER_ID에 대응
        String password = request.getParameter("password"); // 테이블의 MEMBER_PASSWORD에 대응
        String name = request.getParameter("name"); // 테이블의 MEMBER_NAME에 대응
        String email = request.getParameter("email"); // 테이블의 MEMBER_EMAIL에 대응
        String area = request.getParameter("area"); // 테이블의 MEMBER_AREA에 대응

        // MemberVO 객체 생성 및 값 설정
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberId(memberId);
        memberVO.setPassword(password);
        memberVO.setName(name);
        memberVO.setEmail(email != null ? email : "NONE-EMAIL");
        memberVO.setArea(area != null ? area : "서울");

        // 서비스 호출을 통한 회원 등록 처리
        memberService.registerMember(memberVO);

        // 성공적으로 회원가입 후 로그인 페이지로 리다이렉트
        return "/jsp/member/register.jsp";
    }
}
