package kr.ac.kopo.board.dao;

import java.util.List;
import kr.ac.kopo.board.vo.BoardVO;

public interface BoardDAO {
    // 전체 게시글 조회
    List<BoardVO> selectAllBoard() throws Exception;

    // 게시글 추가
    void insertBoard(BoardVO boardVO) throws Exception;

    // 게시글 삭제
    void deleteBoard(int boardId) throws Exception;

    // 특정 게시글 조회
    BoardVO selectBoardById(int boardId) throws Exception;

	void viewCountUp(int boardId);

	List<BoardVO> selectBoardByArea(String boardArea);

	int getBoardCountByArea(String boardArea);

	List<BoardVO> getBoardsByAreaWithPagination(String boardArea, int currentPage, int itemsPerPage);

	void likeCountUp(int boardId);

	void updateBoardById(BoardVO boardVO);

	void addReply(BoardVO boardVO);

	boolean checkLikeExists(int boardId, String ipAddress);

	boolean addLike(int boardId, String ipAddress);

	List<BoardVO> findRepliesByBoardId(int boardId);
}
