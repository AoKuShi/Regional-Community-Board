package kr.ac.kopo.member.service;

import java.util.List;

import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.dao.MemberDAOImpl;
import kr.ac.kopo.member.vo.MemberVO;

public class MemberService {

    private MemberDAO memberDAO;

    public MemberService() {
        this.memberDAO = new MemberDAOImpl();
    }

    /**
     * 회원 로그인 메서드
     */
    public MemberVO login(MemberVO memberVO) throws Exception {
        return memberDAO.selectMemberByIdAndPassword(memberVO);
    }

    /**
     * 회원가입 메서드
     */
    public void registerMember(MemberVO memberVO) throws Exception {
        memberDAO.insertMember(memberVO);
    }

	public void update(MemberVO memberVO) throws Exception {
		memberDAO.updateMember(memberVO);
	}

	public void deleteMember(int memberNo) {
		memberDAO.deleteMember(memberNo);
		
	}

	public List<MemberVO> selectAllMembers() {
		return memberDAO.selectAllMembers();
	}

}
