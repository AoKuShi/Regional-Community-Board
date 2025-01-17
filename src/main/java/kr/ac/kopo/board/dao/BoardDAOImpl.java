package kr.ac.kopo.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.mybatis.MyConfig;

public class BoardDAOImpl implements BoardDAO {

    private SqlSession sqlSession;

    public BoardDAOImpl() {
        sqlSession = new MyConfig().getInstance();
    }

    @Override
    public List<BoardVO> selectAllBoard() throws Exception {
    	sqlSession.commit();
        return sqlSession.selectList("dao.BoardDAO.selectAllBoard");
    }

    @Override
    public void insertBoard(BoardVO boardVO) throws Exception {
        sqlSession.insert("dao.BoardDAO.insertBoard", boardVO);
        sqlSession.commit();
    }

    @Override
    public void deleteBoard(int boardId) throws Exception {
        sqlSession.delete("dao.BoardDAO.deleteBoard", boardId);
        sqlSession.commit();
    }

    @Override
    public BoardVO selectBoardById(int boardId) throws Exception {
    	sqlSession.commit();
        return sqlSession.selectOne("dao.BoardDAO.selectBoardById", boardId);
    }

	@Override
	public void viewCountUp(int boardId) {
		sqlSession.update("dao.BoardDAO.viewCountUpById", boardId);
		sqlSession.commit();
	}

	@Override
	public void likeCountUp(int boardId) {
		sqlSession.update("dao.BoardDAO.goodCountUpById", boardId);
		sqlSession.commit();
		
	}

	@Override
	public List<BoardVO> selectBoardByArea(String boardArea) {
    	sqlSession.commit();
        return sqlSession.selectList("dao.BoardDAO.selectBoardByArea", boardArea);
	}

	@Override
	public int getBoardCountByArea(String boardArea) {
		return sqlSession.selectOne("dao.BoardDAO.getBoardCountByArea", boardArea);
	}

	@Override
	public List<BoardVO> getBoardsByAreaWithPagination(String boardArea, int startRow, int lastRow) {
	    // 파라미터를 Map으로 생성
	    Map<String, Object> params = new HashMap<>();
	    params.put("boardArea", boardArea);
	    params.put("startRow", startRow);
	    params.put("lastRow", lastRow);
	    // MyBatis 호출
	    sqlSession.commit();
	    return sqlSession.selectList("dao.BoardDAO.getBoardsByAreaWithPagination", params);
	}

	@Override
	public void updateBoardById(BoardVO boardVO) {
		sqlSession.update("dao.BoardDAO.updateBoardById", boardVO);
		sqlSession.commit();
		
	}

	@Override
	public void addReply(BoardVO boardVO) {
		sqlSession.insert("dao.BoardDAO.addReply", boardVO);
        sqlSession.commit();
	}

	@Override
	public boolean checkLikeExists(int boardId, String ipAddress) {
	    Map<String, Object> params = new HashMap<>();
	    params.put("boardId", boardId);
	    params.put("ipAddress", ipAddress);
	    
	    int count = sqlSession.selectOne("dao.BoardDAO.checkLikeExists", params);
	    sqlSession.commit();

	    return count > 0; // 좋아요가 이미 존재하면 true 반환
	}


	@Override
	public boolean addLike(int boardId, String ipAddress) {
	    Map<String, Object> params = new HashMap<>();
	    params.put("boardId", boardId);
	    params.put("ipAddress", ipAddress);

	    int affectedRows = sqlSession.insert("dao.BoardDAO.addLike", params);
	    sqlSession.commit();

	    return affectedRows > 0; // 데이터 삽입 성공 시 true 반환
	}

	@Override
	public List<BoardVO> findRepliesByBoardId(int boardId) {
		sqlSession.commit();
		return sqlSession.selectList("dao.BoardDAO.findRepliesByBoardId", boardId);
	}




}
