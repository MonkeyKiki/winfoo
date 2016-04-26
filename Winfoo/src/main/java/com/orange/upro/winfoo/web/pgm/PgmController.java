package com.orange.upro.winfoo.web.pgm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/pgm")
public class PgmController {

	@RequestMapping(method = RequestMethod.GET)
	public String pgm() {
		return "pgm";
	}

}