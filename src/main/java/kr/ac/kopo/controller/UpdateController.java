package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.MemberVO;

public class UpdateController implements Controller {
    private MemberService memberService;

    public UpdateController() {
        this.memberService = new MemberService();
    }

	@Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		MemberVO memberVO2 = (MemberVO)session.getAttribute("loginMember");
		
		String no = request.getParameter("no");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String area = request.getParameter("area");
		
		MemberVO memberVO = new MemberVO();
		
		memberVO.setMemberNo(Integer.valueOf(no));
		memberVO.setName(name);
		memberVO.setEmail(email);
		memberVO.setArea(area);
		
		
        System.out.println(memberVO.toString());
        
        memberService.update(memberVO);
        
        memberVO2.setName(name);
		memberVO2.setEmail(email);
		memberVO2.setArea(area);
        
        session.setAttribute("loginMember", memberService.login(memberVO2));
        
        return "redirect:/index.do";
    }
}
