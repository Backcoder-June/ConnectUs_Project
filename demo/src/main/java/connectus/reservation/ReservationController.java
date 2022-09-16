package connectus.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import connectus.board.BoardDAO;

@Controller
public class ReservationController {
	
	@Autowired
	ReservationDAO reservationDAO; 
	
	@PostMapping("/board/{boardid}/reservationinput")
	public String reservationinput(@PathVariable("boardid")int boardid, String userid, Model model) {
		
		model.addAttribute("boardId", boardid);
		model.addAttribute("userId", userid);
		return "reservationinput";
	}
	
	
	@PostMapping("/board/reservationinput")
	public String reservation(ReservationDTO dto) {

		reservationDAO.insertReservation(dto);
		
		return "redirect:/allboard";
	}
	
	@GetMapping("/board/result")
	public String result() {
		
		return "result"; 
	}
	
	
	

}
