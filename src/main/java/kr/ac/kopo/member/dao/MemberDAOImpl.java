package kr.ac.kopo.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import kr.ac.kopo.member.vo.MemberVO;
import kr.ac.kopo.mybatis.MyConfig;

public class MemberDAOImpl implements MemberDAO {

    private SqlSession sqlSession;

    public MemberDAOImpl() {
        sqlSession = new MyConfig().getInstance();
    }

    /**
     * ID와 비밀번호로 회원 조회
     */
    @Override
    public MemberVO selectMemberByIdAndPassword(MemberVO memberVO) throws Exception {
    	sqlSession.commit();
        return sqlSession.selectOne("dao.MemberDAO.selectMemberByIdAndPassword", memberVO);
    }

    /**
     * 회원가입 처리
     */
    @Override
    public void insertMember(MemberVO memberVO) throws Exception {
        sqlSession.insert("dao.MemberDAO.insertMember", memberVO);
        sqlSession.commit();
    }

	@Override
	public MemberVO selectMemberByNo(int memberNo) throws Exception {
		MemberVO params = new MemberVO();
		params.setMemberNo(memberNo);
		return sqlSession.selectOne("dao.MemberDAO.selectMemberByNo", params);
	}

	@Override
	public void updateMember(MemberVO memberVO) throws Exception {
	    sqlSession.update("dao.MemberDAO.updateMember", memberVO);
	    sqlSession.commit(); // 반드시 커밋 호출
	}

	@Override
	public void deleteMember(int memberNo) {
		sqlSession.delete("dao.MemberDAO.deleteMember", memberNo);
	    sqlSession.commit(); // 반드시 커밋 호출
	}

	@Override
	public List<MemberVO> selectAllMembers() {
		sqlSession.commit();
		return sqlSession.selectList("dao.MemberDAO.selectAllMembers");
	}
}
