package org.seckill.web;

import java.util.List;

import org.seckill.entity.Seckill;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping()
	public String test() {
		System.out.println("adnksensjnsd");
		return "list";
	}
}
