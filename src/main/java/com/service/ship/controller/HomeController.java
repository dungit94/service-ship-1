package com.service.ship.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@Value("${title.message}")
	private String title;

	@GetMapping("/")
	public String homePage(Model model) {

		model.addAttribute("title", title);

		return "home"; // view
	}
}
