package board.spring.mybatis;

import java.util.List;

public interface BoardService {

	int registerBoard(BoardDTO dto);

	List<BoardDTO> pagingBoardlist(int pagenum, int pagecount);
	
	int getTotalBoard();

	BoardDTO boarddetail(int seq);

	void deleteBoard(int seq);

	void updateBoard(BoardDTO dto);

		
}
