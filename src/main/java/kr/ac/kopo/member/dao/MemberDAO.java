package kr.ac.kopo.member.dao;

import java.util.List;

import kr.ac.kopo.member.vo.MemberVO;

public interface MemberDAO {

    /**
     * ID와 비밀번호를 이용해 회원 조회
     * @param googleId Google ID
     * @param password 비밀번호
     * @return 조회된 회원 정보
     * @throws Exception
     */
    MemberVO selectMemberByIdAndPassword(MemberVO memberVO) throws Exception;

    /**
     * 회원가입 처리
     * @param memberVO 회원 정보 객체
     * @throws Exception
     */
    void insertMember(MemberVO memberVO) throws Exception;
    
    MemberVO selectMemberByNo(int memberNo) throws Exception;

	void updateMember(MemberVO memberVO) throws Exception;

	void deleteMember(int memberNo);

	List<MemberVO> selectAllMembers();

}
