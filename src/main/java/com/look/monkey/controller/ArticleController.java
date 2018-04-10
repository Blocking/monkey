package com.look.monkey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/article")
public class ArticleController {
	
	  @RequestMapping("/edit")
	    public String greeting( Model model) {
	        return "article/edit";
	    }

}
