package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;

public class BoardUpdateFormController implements Controller {

    private BoardService boardService;

    public BoardUpdateFormController() {
        this.boardService = new BoardService();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 요청 파라미터로 전달된 boardId를 통해 게시글 정보 조회
        int boardId = Integer.parseInt(request.getParameter("boardId"));
        BoardVO boardVO = boardService.getBoardById(boardId);

        // 게시글 정보를 request 속성에 설정
        request.setAttribute("boardVO", boardVO);

        // 수정 폼 JSP로 이동
        return "/jsp/board/updateForm.jsp";
    }
}
