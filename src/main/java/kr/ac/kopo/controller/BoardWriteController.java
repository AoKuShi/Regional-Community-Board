package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class BoardWriteController implements Controller {

    private BoardService boardService;

    public BoardWriteController() {
        this.boardService = new BoardService();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
    	int memberNo = Integer.parseInt(request.getParameter("boardMemberNo"));
        String title = request.getParameter("boardTitle");
        String content = request.getParameter("boardContent");
        String area = request.getParameter("boardArea");

        BoardVO boardVO = new BoardVO();
        boardVO.setBoardMemberNo(memberNo);
        boardVO.setBoardTitle(title);
        boardVO.setBoardContent(content);
        boardVO.setBoardArea(area);
        
        boardService.addBoard(boardVO);
        
        // URL 인코딩 처리
        String encodedBoardArea = URLEncoder.encode(area, StandardCharsets.UTF_8.toString());
        
        return "redirect:/board/list.do?boardArea="+encodedBoardArea;
        
//        BoardListController boardlistc = new BoardListController();
//
//        return boardlistc.handleRequest(request, response);
    }
}
