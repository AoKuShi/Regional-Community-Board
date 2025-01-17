package kr.ac.kopo.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.util.NetworkUtil;

public class BoardLikeController implements Controller {

    private BoardService boardService;

    public BoardLikeController() {
        boardService = new BoardService();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int boardId = Integer.parseInt(request.getParameter("boardId"));
        String clientIp = NetworkUtil.getClientIP(request);
        
        boolean likeAdded = boardService.addLike(boardId, clientIp);
        if (likeAdded) {
            boardService.likeCountUp(boardId);
        }
        
        BoardVO updatedBoardVO = boardService.getBoardById(boardId);
        request.setAttribute("boardVO", updatedBoardVO);
        
        List<BoardVO> updatedreplyList = boardService.getRepliesByBoardId(boardId);
        request.setAttribute("replyList", updatedreplyList);
        request.setAttribute("area", boardService.getBoardById(boardId).getBoardArea());
        return "/jsp/board/view.jsp";
    }
}
