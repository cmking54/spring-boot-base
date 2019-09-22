package com.christopher.web.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.christopher.web.model.Dog;

@Controller
@RequestMapping("/dogs")
public class WebController {
	private final RestTemplate restTemplate = new RestTemplate(); 
	@GetMapping
	public String getKennel(ModelMap model) {
		String api_endpoint = "http://localhost:8080/api/dogs";
		List<Dog> dogList = Arrays.stream(restTemplate.getForObject(api_endpoint, Dog[].class))
				.collect(Collectors.toList());
		model.addAttribute("kennel", dogList);
		// get data from api
//		Kennel kennel = restTemplate.getForObject(
//				api_endpoint, 
//				Kennel.class);
//		System.out.println(kennel);
//		model.addAttribute("kennel", kennel.getDogs());
		return "dogs"; // classpath:resources/templates/dogs
	}
}
