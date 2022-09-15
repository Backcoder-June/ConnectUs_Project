package connectus.board;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

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
		model.addAttribute("oneBoard", targetBoard);

		return "oneboard";
	}
	
	
	@GetMapping("/registerBoard")
	public String registerBoard() {
		
		return "insertBoardForm";
	}
	
	@PostMapping("/registerBoard")
	public String registerProcess(BoardDTO dto, MultipartFile file1) throws IOException{
		
		String savePath = "c:/upload/"; 
		
		
		if(!file1.isEmpty()) {
			String originalname1 = file1.getOriginalFilename();
			String onlyfilename = originalname1.substring(0, originalname1.indexOf("."));
			String extname = originalname1.substring(originalname1.indexOf("."));
			
			String newname = onlyfilename + "(" + UUID.randomUUID().toString() + ")" + extname; 
			
			File serverfile1 = new File(savePath + newname);
			
			file1.transferTo(serverfile1);
			
			
			dto.setImg(newname);
			
		boardDAO.insertBoard(dto);
		
		
		}
		return "redirect:/allboard";
	}
	

	//
}