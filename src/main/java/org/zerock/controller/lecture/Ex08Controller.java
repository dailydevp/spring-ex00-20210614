package org.zerock.controller.lecture;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.controller.lecture.domain.User;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/ex08/*")
public class Ex08Controller {

//	....
	@RequestMapping("/sub08")
	public String method08(User user) {
		
		log.info("ex08, sub08 method");
		
		return "ex08/sub02";
	}
	
	@RequestMapping("/sub09")
	public void method09 (@ModelAttribute("age") int age,
			@ModelAttribute("name") String name) {
		log.info("ex08, sub09 method");
		
		log.info(age);
		log.info(name);
		
	}
}
