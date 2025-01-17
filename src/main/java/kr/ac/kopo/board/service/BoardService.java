package kr.ac.kopo.board.service;

import java.util.List;
import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.board.dao.BoardDAOImpl;
import kr.ac.kopo.board.vo.BoardVO;

public class BoardService {

    private BoardDAO boardDAO;

    public BoardService() {
        this.boardDAO = new BoardDAOImpl();
    }

    /**
     * 모든 게시글을 조회하는 메서드
     */
    public List<BoardVO> getAllBoards() throws Exception {
        return boardDAO.selectAllBoard();
    }
    
    public List<BoardVO> getBoardsByArea(String boardArea) throws Exception {
        return boardDAO.selectBoardByArea(boardArea);
    }

    /**
     * 게시글을 추가하는 메서드
     */
    public void addBoard(BoardVO boardVO) throws Exception {
        boardDAO.insertBoard(boardVO);
    }

    /**
     * 특정 ID의 게시글을 조회하는 메서드
     */
    public BoardVO getBoardById(int boardId) throws Exception {
        return boardDAO.selectBoardById(boardId);
    }

    /**
     * 특정 ID의 게시글을 삭제하는 메서드
     */
    public void deleteBoard(int boardId) throws Exception {
        boardDAO.deleteBoard(boardId);
    }

	public void viewCountUp(int boardId) {
		boardDAO.viewCountUp(boardId);
	}

    public int getBoardCountByArea(String boardArea) {
        return boardDAO.getBoardCountByArea(boardArea);
    }

    public List<BoardVO> getBoardsByAreaWithPagination(String boardArea, int startRow, int lastRow) {
        return boardDAO.getBoardsByAreaWithPagination(boardArea, startRow, lastRow);
    }

	public void likeCountUp(int boardId) {
		boardDAO.likeCountUp(boardId);
		
	}

	public void updateBoard(BoardVO boardVO) {
		boardDAO.updateBoardById(boardVO);
		
	}

	public void addReply(BoardVO boardVO) {
		boardDAO.addReply(boardVO);
		
	}

	public boolean addLike(int boardId, String ipAddress) {
        if (!boardDAO.checkLikeExists(boardId, ipAddress)) {
            return boardDAO.addLike(boardId, ipAddress);
        }
        return false;
    }
	
	public List<BoardVO> getRepliesByBoardId(int boardId) {
        return boardDAO.findRepliesByBoardId(boardId);
    }
}
