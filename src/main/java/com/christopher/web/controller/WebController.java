package com.christopher.web.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.christopher.web.model.Dog;

@Controller
@RequestMapping("/dogs")
public class WebController {
	private final RestTemplate restTemplate = new RestTemplate(); 
	private final String URLNameSpace = "http://localhost:8080/api/dog";
	@GetMapping
	public String displayAllAndForms(ModelMap model) {
		displayTable(model);
//		model.addAttribute("message", "hello");
		return "dogs"; // classpath:resources/templates/dogs
	}
	@PostMapping @PutMapping
	public String formSubmit(@ModelAttribute Dog dog, ModelMap model) {
		ResponseEntity<Dog> search = restTemplate.getForEntity(URLNameSpace + "s/" + dog.getName(), Dog.class);
		ResponseEntity<Dog> response;
//		System.out.println(search.getBody());
		if (search.getBody() != null) { // update
			dog.setDogId(search.getBody().getDogId());
			response = restTemplate.exchange(URLNameSpace + "s", HttpMethod.PUT, new HttpEntity<Dog>(dog), Dog.class);
		} else {
			response = restTemplate.postForEntity(URLNameSpace + "s", dog, Dog.class);
		}
		//displayTable(model);
		return "redirect:/dogs"; // post-redirect-get; stops resubmission on refresh
	}
	
	@RequestMapping("/passed/{id}")
	public String removeDog(@PathVariable String id) {
//		System.out.println("DELETE:" + URLNameSpace + "s/passed/" + id);
//		restTemplate.exchange(URLNameSpace + "s/passed/" + id, HttpMethod.DELETE, null, null);
		restTemplate.delete(URLNameSpace + "s/passed/" + id);
		return "redirect:/dogs";
	}
	
	private void displayTable(ModelMap model) {
		String api_endpoint = URLNameSpace + "s";
		List<Dog> dogList = Arrays.stream(restTemplate.getForObject(api_endpoint, Dog[].class))
				.collect(Collectors.toList());
		model.addAttribute("kennel", dogList);
		model.addAttribute("dog", new Dog());
	}
}
