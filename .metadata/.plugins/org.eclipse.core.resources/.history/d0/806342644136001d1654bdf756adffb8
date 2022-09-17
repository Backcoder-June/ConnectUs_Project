package connectus.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import connectus.reservation.ReservationDTO;

@Repository
@Mapper
public interface BoardDAO {
	
	public List<BoardDTO> allBoard();
	
	public BoardDTO oneBoard(int boardid);
	
	public int insertBoard(BoardDTO dto);
	
	public List<ReservationDTO> allReservation(int boardid);
	
	
}
