package com.christopher.rest.controller.dog;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.christopher.rest.model.dog.DogDTO;
import com.christopher.rest.model.dog.DogService;

@RestController
@RequestMapping("/api")
public class DogRestController {
	@Autowired
	private final DogService service;
	
	public DogRestController(DogService service) {
		this.service = service;
	}
	
	@GetMapping("/dogs")
	public ResponseEntity<List<DogDTO>> findAll() {
		return ResponseEntity.ok(service.findAll().getKennel());
	}
	
	@GetMapping("/dogs/{name}")
	public ResponseEntity<DogDTO> find(@PathVariable String name) {
		return ResponseEntity.ok(service.find(name));
	}
	
	@PostMapping("/dogs")
	public ResponseEntity<DogDTO> create(@RequestBody @Valid DogDTO new_dog) throws URISyntaxException {
		DogDTO result = service.save(new_dog);
		return ResponseEntity.created(new URI("/api/dogs/" + result.getDogId())).body(result);
	}
	
	@PutMapping("/dogs")
	public ResponseEntity<DogDTO> update(@RequestBody @Valid DogDTO dog_change) {
		DogDTO result = service.update(dog_change);
		return ResponseEntity.ok().body(result);
	}
	
	@DeleteMapping("/dogs/passed/{moved_on_dog}")
	public ResponseEntity<Void> delete(@PathVariable String moved_on_dog) {
		service.delete(Long.valueOf(moved_on_dog));
		return ResponseEntity.ok().build(); // ? => builder
	}
}
