package com.service.ship.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.service.ship.model.HairSampleResponseDto;
import com.service.ship.model.OurTeamResponseDto;
import com.service.ship.model.ServiceResponseDto;

@Controller
public class HomeController {

	@Value("${title.message}")
	private String title;

	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("title", title);
		return "home"; // view
	}

	/**
	 * load page index
	 * @param model
	 * @return String
	 * @author DungNQ
	 */
	@GetMapping("/index")
	public String indexPage(Model model) {
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
