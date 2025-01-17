package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class BoardUpdateController implements Controller {

    private BoardService boardService;

    public BoardUpdateController() {
        this.boardService = new BoardService();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 파라미터 값 가져오기
        int boardId = Integer.parseInt(request.getParameter("boardId"));
        int memberNo = Integer.parseInt(request.getParameter("boardMemberNo"));
        String title = request.getParameter("boardTitle");
        String content = request.getParameter("boardContent");
        String area = request.getParameter("boardArea");

        // BoardVO 객체에 데이터 설정
        BoardVO boardVO = new BoardVO();
        boardVO.setBoardId(boardId);  // 수정할 게시글 ID
        boardVO.setBoardMemberNo(memberNo);
        boardVO.setBoardTitle(title);
        boardVO.setBoardContent(content);
        boardVO.setBoardArea(area);

        // 게시글 업데이트 처리
        boardService.updateBoard(boardVO);

        // URL 인코딩 처리
        String encodedBoardArea = URLEncoder.encode(area, StandardCharsets.UTF_8.toString());

        // 수정 완료 후 게시글 목록 페이지로 리디렉션
        return "redirect:/board/list.do?boardArea=" + encodedBoardArea;
    }
}
