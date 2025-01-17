package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.board.service.BoardService;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class BoardDeleteController implements Controller {

    private BoardService boardService;

    public BoardDeleteController() {
        this.boardService = new BoardService();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int boardId = Integer.parseInt(request.getParameter("boardId"));
        String boardArea = request.getParameter("boardArea");

        // 게시글 삭제 처리
        boardService.deleteBoard(boardId);

        // URL 인코딩 처리
        String encodedBoardArea = URLEncoder.encode(boardArea, StandardCharsets.UTF_8.toString());

        // 리다이렉트 URL 반환
        return "redirect:/board/list.do?boardArea=" + encodedBoardArea;
    }
}
