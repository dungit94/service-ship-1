package com.service.ship.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.service.ship.model.CategoryResponseDto;
import com.service.ship.model.HairSampleResponseDto;
import com.service.ship.model.OurTeamResponseDto;
import com.service.ship.model.ServiceResponseDto;

@Controller
public class HomeController {

//	@Value("${title.message}")
	private String title;

    @Autowired
    protected HttpSession session;
	
	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("title", title);
		return "home"; // view
	}

	public void getCategory() {
		List<CategoryResponseDto> lstCategory = new ArrayList<CategoryResponseDto>();
		CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
		categoryResponseDto.setId(1);
		categoryResponseDto.setName("Ví trị");
		categoryResponseDto.setSessionId("#about");
		CategoryResponseDto categoryResponseDto1 = new CategoryResponseDto();
		categoryResponseDto1.setId(2);
		categoryResponseDto1.setName("Dịch vụ");
		categoryResponseDto1.setSessionId("#features");
		
		CategoryResponseDto categoryResponseDto2 = new CategoryResponseDto();
		categoryResponseDto2.setId(3);
		categoryResponseDto2.setName("Mẫu tóc");
		categoryResponseDto2.setSessionId("#portfolio");
		
		CategoryResponseDto categoryResponseDto3 = new CategoryResponseDto();
		categoryResponseDto3.setId(4);
		categoryResponseDto3.setName("Đối tác");
		categoryResponseDto3.setSessionId("#partners");
		
		CategoryResponseDto categoryResponseDto4 = new CategoryResponseDto();
		categoryResponseDto4.setId(5);
		categoryResponseDto4.setName("Đội ngũ");
		categoryResponseDto4.setSessionId("#team");
		
		CategoryResponseDto categoryResponseDto5 = new CategoryResponseDto();
		categoryResponseDto5.setId(6);
		categoryResponseDto5.setName("Liên hệ");
		categoryResponseDto5.setSessionId("#contact");
		
		lstCategory.add(categoryResponseDto);
		lstCategory.add(categoryResponseDto1);
		lstCategory.add(categoryResponseDto2);
		lstCategory.add(categoryResponseDto3);
		lstCategory.add(categoryResponseDto4);
		lstCategory.add(categoryResponseDto5);
		
		
		session.setAttribute("listCategory", lstCategory);
	}
	/**
	 * load page index
	 * @param model
	 * @return String
	 * @author DungNQ
	 */
	@GetMapping("/index")
	public String indexPage(Model model) {
		// set session
		getCategory();
//		Test dữ liệu giả start
		List<ServiceResponseDto> lstServiceResponseDto = new ArrayList<ServiceResponseDto>();
		for (int i = 0; i < 9; i++) {
			ServiceResponseDto serviceResponseDto = new ServiceResponseDto();
			serviceResponseDto.setId(i);
			serviceResponseDto.setContent("INFRA theme looks awesome at any size, be it a Laptop screen, Mobile or Tablet");
			serviceResponseDto.setTitle("Fully Responsive Design");
			serviceResponseDto.setLinkImage("fa fa-television");
			lstServiceResponseDto.add(serviceResponseDto);
		}
		List<HairSampleResponseDto> lstHairSampleResponseDto = new ArrayList<HairSampleResponseDto>();
		for (int i = 0; i < 9; i++) {
			HairSampleResponseDto hairSampleResponseDto = new HairSampleResponseDto();
			hairSampleResponseDto.setId(i);
			hairSampleResponseDto.setTitle("Undercut");
			hairSampleResponseDto.setLinkImage("images/demo/undercut.jpg");
			hairSampleResponseDto.setContent("Chất VL");
			lstHairSampleResponseDto.add(hairSampleResponseDto);
		}
		List<OurTeamResponseDto> lstourTeamResponseDto = new ArrayList<OurTeamResponseDto>();
		for (int i = 0; i < 5; i++) {
			OurTeamResponseDto ourTeamResponseDto = new OurTeamResponseDto();
			ourTeamResponseDto.setId(i);
			ourTeamResponseDto.setPosition("CEO");
			ourTeamResponseDto.setName("NGUYỄN VĂN HẾT");;
			ourTeamResponseDto.setContent("Chất VL");
			ourTeamResponseDto.setLinkImage("images/demo/undercut.jpg");;
			lstourTeamResponseDto.add(ourTeamResponseDto);
		}
		model.addAttribute("title", title);
		model.addAttribute("lstServiceResponseDto", lstServiceResponseDto);
		model.addAttribute("lstHairSampleResponseDto", lstHairSampleResponseDto);
		model.addAttribute("lstourTeamResponseDto", lstourTeamResponseDto);
//		Test dữ liệu giả end
		return "index"; 
	}
}
