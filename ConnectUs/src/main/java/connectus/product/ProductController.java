package connectus.product;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
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

import connectus.reservation.ReservationDTO;

@Controller
public class ProductController {

	
	@Autowired
	ProductDAO productDAO;
	
	
	// 홈 
	@GetMapping("/")
	public String home() {
		return "home";
	}

	// 전체 물품 조회
	@GetMapping("/allproduct")
	public String allProduct(Model model) {
		
		List<ProductDTO> list = productDAO.allBoard();
	
		model.addAttribute("allboard", list);
		return "product/allProduct";
	}
	
	// 물품 상세페이지 
	@GetMapping("/product/{productid}")
	public String oneProduct(@PathVariable("productid")int boardid, Model model) {
		
		ProductDTO targetBoard = productDAO.oneBoard(boardid);
		
		List<ReservationDTO> reservList = productDAO.allReservation(boardid);
		
		
		model.addAttribute("reservationList", reservList);
		model.addAttribute("oneBoard", targetBoard);

		return "product/oneProduct";
	}
	
	
	
	//글작성 폼 
	@GetMapping("/registerProduct")
	public String registerProduct() {
		
		return "product/insertProductForm";
	}
	
	// 글작성 
	@PostMapping("/registerProduct")
	public String registerProcess(ProductDTO dto, MultipartFile file1) throws Exception{
		
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
			
//		// 지역 이름 set 	( 이거 동네는 매번 위치를 킬 수 없으니까 회원가입할 때, 혹은 기간에 한번씩만 인증하는식으로 받아서 DTO 에 넣어두고 사용하자 )
//			ApiClient apiClient = new ApiClient(geoapiignore.geoaccess, geoapiignore.geosecret);
//			
//			String geo = apiClient.run(geoapiignore.geoip);
//			
//			int index = geo.indexOf("r3");
//			int index2 = geo.indexOf("lat");
//			
//			String region = geo.substring(index+6, index2-3);
//			System.out.println(region);
		
		String region = "젠킨스동네";
			
			dto.setBoardRegion(region); 
			
			productDAO.insertBoard(dto);
		return "redirect:/allproduct";
	}
	
	
	// 글삭제 
	@PostMapping("/product/{productid}/delete")
	public String deleteProduct(@PathVariable("productid")int boardid) {
		productDAO.deleteBoard(boardid);
		return "redirect:/allproduct";
	}
	
	
	// 글수정
	@GetMapping("/product/{productid}/update")
	public String updateProduct(@PathVariable("productid")int boardid, Model model) {
		model.addAttribute("updateBoard", productDAO.oneBoard(boardid));
		return "product/updateProductForm";
	}

	@PostMapping("/product/{productid}/updateprocess")
	public String updateProductProcess(@PathVariable("productid")int boardid,ProductDTO boardDTO, MultipartFile file1) throws IllegalStateException, IOException {
		// update 할 아이디 set 
		boardDTO.setId(boardid);
		
		// 이미지 다시 Set 
		String savePath = "c:/upload/"; 
		
		if(!file1.isEmpty()) {
			String originalname1 = file1.getOriginalFilename();
			String onlyfilename = originalname1.substring(0, originalname1.indexOf("."));
			String extname = originalname1.substring(originalname1.indexOf("."));
			
			String newname = onlyfilename + "(" + UUID.randomUUID().toString() + ")" + extname; 
			
			File serverfile1 = new File(savePath + newname);
			file1.transferTo(serverfile1);
			boardDTO.setImg(newname); 
			}else {
				boardDTO.setImg("noimg.png");
			}
		
		// update 실행 
		int updateResult = productDAO.updateBoard(boardDTO);
		
		return "redirect:/allproduct";
	}

	
	
	// 검색
	@GetMapping("/searchproduct")
	public String searchList(String item, String search, Model model) {

		HashMap<String, String> map = new HashMap<>();
		map.put("item", item);
		map.put("search", search);

		List<ProductDTO> searchList = productDAO.searchList(map);
		
		model.addAttribute("searchList", searchList);
		return "product/searchList";
	}
	
	
	
	
	
	

	//
}
