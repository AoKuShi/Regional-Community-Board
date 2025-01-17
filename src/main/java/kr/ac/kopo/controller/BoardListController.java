package kr.ac.kopo.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;

public class BoardListController implements Controller {

    private BoardService boardService;

    public BoardListController() {
        this.boardService = new BoardService();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 캐시 방지 헤더 추가
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        // 요청에서 boardArea 값 가져오기
        String boardArea = request.getParameter("boardArea");
        if (boardArea == null || boardArea.isEmpty()) {
            boardArea = "전체"; // 기본값
        }

        String queryArea = boardArea.equals("전체") ? "%" : boardArea;

        int itemsPerPage = 15; // 한 페이지당 게시글 수
        int totalItems = boardService.getBoardCountByArea(queryArea); // 전체 게시글 수
        int totalPages = (int) Math.ceil((double) totalItems / itemsPerPage);

        // totalPages 계산 후 currentPage 설정
        int currentPage;
        if (request.getParameter("page") != null) {
            currentPage = Integer.parseInt(request.getParameter("page"));
        } else {
            // page 파라미터가 없으면 마지막 페이지를 기본값으로 설정
            currentPage = totalPages;
        }

        int startRow = (currentPage - 1) * itemsPerPage + 1;
        int lastRow = currentPage * itemsPerPage;

        // 현재 페이지에 해당하는 게시글 목록 가져오기
        List<BoardVO> boardList = boardService.getBoardsByAreaWithPagination(queryArea, startRow, lastRow);

        // JSP로 전달할 데이터 설정
        request.setAttribute("boardList", boardList);
        request.setAttribute("boardArea", boardArea);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("totalPages", totalPages);

        return "/jsp/board/list.jsp";
    }
}
