package net.tuxun.customer.module.controller.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {

	@RequestMapping("toIndex")
	public String toIndex(){
		return "index/index";
	}
}
