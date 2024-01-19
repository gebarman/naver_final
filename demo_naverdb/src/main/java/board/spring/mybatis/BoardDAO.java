package board.spring.mybatis;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BoardDAO {
	
	public int insertBoardDTO(BoardDTO dto);

	public List<BoardDTO> pagingBoardlist(HashMap<String, Integer> map);
	
	int getTotalBoard();

	public void increViewcount(int seq);

	public BoardDTO selectOneBoard(int seq);

	public void deleteBoard(int seq);

	public void updateBoard(BoardDTO dto);
	

}
