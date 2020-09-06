package com.certait.knockout.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.certait.knockout.model.DataModel;
import com.certait.knockout.model.UIConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class KnockoutController {

	@GetMapping({ "/", "/index" })
	public ModelAndView loadIndex(@ModelAttribute DataModel dataModel) throws JsonProcessingException {

		ModelAndView mav = new ModelAndView("index");

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(new UIConfig(dataModel));

		mav.addObject("initialUIConfig", json);

		return mav;
	}

	@SuppressWarnings("rawtypes")
	@PostMapping("/update")
	@ResponseBody
	public ResponseEntity update(@RequestParam String gender, @RequestParam int age) {
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
