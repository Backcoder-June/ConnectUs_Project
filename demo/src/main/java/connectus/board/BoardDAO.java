package connectus.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BoardDAO {
	
	public List<BoardDTO> allBoard();
	
	public BoardDTO oneBoard(int boardid);
	
	public int insertBoard(BoardDTO dto);
	
	
}
