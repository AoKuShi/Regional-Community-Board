package kr.ac.kopo.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;

public class BoardViewController implements Controller {

    private BoardService boardService;

    public BoardViewController() {
        this.boardService = new BoardService();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int boardId = Integer.parseInt(request.getParameter("boardId"));
        BoardVO boardVO = boardService.getBoardById(boardId);
        boardService.viewCountUp(boardId);
        request.setAttribute("boardVO", boardVO);
        List<BoardVO> updatedreplyList = boardService.getRepliesByBoardId(boardId);
        request.setAttribute("replyList", updatedreplyList);
        request.setAttribute("area", boardService.getBoardById(boardId).getBoardArea());
        return "/jsp/board/view.jsp";
    }
}
