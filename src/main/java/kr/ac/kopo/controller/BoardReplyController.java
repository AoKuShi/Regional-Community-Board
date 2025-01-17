package kr.ac.kopo.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;

public class BoardReplyController implements Controller {

    private BoardService boardService;

    public BoardReplyController() {
        this.boardService = new BoardService();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 요청에서 필요한 데이터 가져오기
        int memberNo = Integer.parseInt(request.getParameter("loginMemberNo"));
        String content = request.getParameter("replyContent");
        int parentBoardId = Integer.parseInt(request.getParameter("boardId")); // 상위 게시글 ID

        // 답글 데이터 설정
        BoardVO boardVO = new BoardVO();
        boardVO.setBoardMemberNo(memberNo);
        boardVO.setBoardTitle(content); // 답글은 기본 제목 설정
        boardVO.setWhosComment(parentBoardId); // 상위 게시글 ID 설정
        
        // 답글 저장
        boardService.addReply(boardVO);
        
        BoardVO updatedBoardVO = boardService.getBoardById(parentBoardId);
        request.setAttribute("boardVO", updatedBoardVO);
        
        List<BoardVO> updatedreplyList = boardService.getRepliesByBoardId(parentBoardId);
        request.setAttribute("replyList", updatedreplyList);
        request.setAttribute("area", boardService.getBoardById(parentBoardId).getBoardArea());

        // 답글 작성 후 상위 게시글 보기 페이지로 리디렉션
        return "/jsp/board/view.jsp";
    }
}
