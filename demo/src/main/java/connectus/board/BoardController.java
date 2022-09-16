package connectus.board;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import connectus.ApiClient;
import connectus.geoapiignore;
import connectus.reservation.ReservationDTO;

@Controller
public class BoardController {
	
	
	@Autowired
	BoardDAO boardDAO;
	
	
	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/allboard")
	public String allboard(Model model) {
		
		List<BoardDTO> list = boardDAO.allBoard();
		
		model.addAttribute("allboard", list);
		
		return "allboard";
	}
	
	
	@GetMapping("/board/{boardid}")
	public String oneBoard(@PathVariable("boardid")int boardid, Model model) {
		
		BoardDTO targetBoard = boardDAO.oneBoard(boardid);
		
		List<ReservationDTO> reservList = boardDAO.allReservation(boardid);
		
		
		model.addAttribute("reservationList", reservList);
		model.addAttribute("oneBoard", targetBoard);

		return "oneboard";
	}
	
	
	@GetMapping("/registerBoard")
	public String registerBoard() {
		
		return "insertBoardForm";
	}
	
	@PostMapping("/registerBoard")
	public String registerProcess(BoardDTO dto, MultipartFile file1) throws Exception{
		
		String savePath = "c:/upload/"; 
		
		
		// 이미지 이름 set 
		if(!file1.isEmpty()) {
			String originalname1 = file1.getOriginalFilename();
			String onlyfilename = originalname1.substring(0, originalname1.indexOf("."));
			String extname = originalname1.substring(originalname1.indexOf("."));
			
			String newname = onlyfilename + "(" + UUID.randomUUID().toString() + ")" + extname; 
			
			File serverfile1 = new File(savePath + newname);
			
			file1.transferTo(serverfile1);
			
			dto.setImg(newname); 
			}else {
				dto.setImg("noimg.png");
			}

			
		// 지역 이름 set 	( 이거 동네는 매번 위치를 킬 수 없으니까 회원가입할 때, 혹은 기간에 한번씩만 인증하는식으로 받아서 DTO 에 넣어두고 사용하자 )
			ApiClient apiClient = new ApiClient(geoapiignore.geoaccess, geoapiignore.geosecret);
			
			String geo = apiClient.run(geoapiignore.geoip);
			
			int index = geo.indexOf("r3");
			int index2 = geo.indexOf("lat");
			
			String region = geo.substring(index+6, index2-3);
			
			System.out.println(region);
			
			
			dto.setBoardRegion(region); 
			

			
		boardDAO.insertBoard(dto);
		
		
		
		return "redirect:/allboard";
	}
	

	//
}
