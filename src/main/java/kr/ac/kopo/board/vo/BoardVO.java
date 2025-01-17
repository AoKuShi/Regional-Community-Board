package kr.ac.kopo.board.vo;

public class BoardVO {
    private int boardId;
    private int boardMemberNo;
    private String memberNameByBoardMemberNo;
    private String boardTitle;
    private String boardContent;
    private String boardArea;
    private String boardCreateDate;
    private int boardViewCount;
    private int boardGoodCount;
    private int whosComment;
    
	public BoardVO() {
	}

	public BoardVO(int boardId, int boardMemberNo, String memberNameByBoardMemberNo, String boardTitle,
			String boardContent, String boardArea, String boardCreateDate, int boardViewCount, int boardGoodCount,
			int whosComment) {
		this.boardId = boardId;
		this.boardMemberNo = boardMemberNo;
		this.memberNameByBoardMemberNo = memberNameByBoardMemberNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardArea = boardArea;
		this.boardCreateDate = boardCreateDate;
		this.boardViewCount = boardViewCount;
		this.boardGoodCount = boardGoodCount;
		this.whosComment = whosComment;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getBoardMemberNo() {
		return boardMemberNo;
	}

	public void setBoardMemberNo(int boardMemberNo) {
		this.boardMemberNo = boardMemberNo;
	}

	public String getMemberNameByBoardMemberNo() {
		return memberNameByBoardMemberNo;
	}

	public void setMemberNameByBoardMemberNo(String memberNameByBoardMemberNo) {
		this.memberNameByBoardMemberNo = memberNameByBoardMemberNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardArea() {
		return boardArea;
	}

	public void setBoardArea(String boardArea) {
		this.boardArea = boardArea;
	}

	public String getBoardCreateDate() {
		return boardCreateDate;
	}

	public void setBoardCreateDate(String boardCreateDate) {
		this.boardCreateDate = boardCreateDate;
	}

	public int getBoardViewCount() {
		return boardViewCount;
	}

	public void setBoardViewCount(int boardViewCount) {
		this.boardViewCount = boardViewCount;
	}

	public int getBoardGoodCount() {
		return boardGoodCount;
	}

	public void setBoardGoodCount(int boardGoodCount) {
		this.boardGoodCount = boardGoodCount;
	}

	public int getWhosComment() {
		return whosComment;
	}

	public void setWhosComment(int whosComment) {
		this.whosComment = whosComment;
	}

	@Override
	public String toString() {
		return "BoardVO [boardId=" + boardId + ", boardMemberNo=" + boardMemberNo + ", memberNameByBoardMemberNo="
				+ memberNameByBoardMemberNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardArea=" + boardArea + ", boardCreateDate=" + boardCreateDate + ", boardViewCount="
				+ boardViewCount + ", boardGoodCount=" + boardGoodCount + ", whosComment=" + whosComment + "]";
	}
    
}
