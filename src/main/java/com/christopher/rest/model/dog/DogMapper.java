package com.christopher.rest.model.dog;

import org.springframework.stereotype.Component;

@Component
public class DogMapper {
	Dog toModel(DogDTO client) {
		Dog dog = new Dog();
		dog.setDogId(client.getDogId());
		dog.setName(client.getName());
		dog.setBreed(client.getBreed());
		dog.setSize(client.getSize());
//		dog.setKeeperId(client.getKeeperId());
//		System.out.println(client.getName());
//		System.out.println();
//		System.out.println(dog.getName());
		return dog;
	}
	DogDTO toDTO(Dog server) {
		DogDTO dog = new DogDTO();
		dog.setDogId(server.getDogId());
		dog.setName(server.getName());
		dog.setBreed(server.getBreed());
		dog.setSize(server.getSize());
//		dog.setKeeperId(server.getKeeperId());
		return dog;
	}
}
