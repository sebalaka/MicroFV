package sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by RENT on 2017-09-13.
 */
@Controller
public class MainPageController {

	@Autowired
	public MainPageController() {
	}

	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public String showMainPage(Model model){
		model.addAttribute("index");
		return "index";
	}
}
