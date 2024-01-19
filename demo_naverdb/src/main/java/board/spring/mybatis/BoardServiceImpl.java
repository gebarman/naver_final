package board.spring.mybatis;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardDAO dao;

	@Override
	public int registerBoard(BoardDTO dto) {
		
		return dao.insertBoardDTO(dto);
	}
	
	@Override
	public int getTotalBoard() {
		
		return dao.getTotalBoard();
		
	}
	@Override
	public List<BoardDTO> pagingBoardlist(int pagenum, int pagecount) {
		
		int idxStart = (pagenum - 1) * pagecount;
		HashMap<String, Integer> map = new HashMap<>();
		map.put("idxStart", idxStart);
		map.put("pagecount", pagecount);
		
		return dao.pagingBoardlist(map);
	}

	@Override
	public BoardDTO boarddetail(int seq) {
		//viewcount 증가
		dao.increViewcount(seq);
		//dto 가지고 오기
		return dao.selectOneBoard(seq);
	}

	@Override
	public void deleteBoard(int seq) {
		
		dao.deleteBoard(seq);
		
	}

	@Override
	public void updateBoard(BoardDTO dto) {
		
		dao.updateBoard(dto);
		
	}
	
	
	
}
