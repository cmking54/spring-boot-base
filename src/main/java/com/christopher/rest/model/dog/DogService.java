package com.christopher.rest.model.dog;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class DogService {

	private final DogRepository repository;
	private final DogMapper mapper;
	
	public DogService(DogRepository repository, DogMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public Kennel findAll() {
		List<DogDTO> dogs = new ArrayList<>();
		repository.findAll().forEach(dog -> dogs.add(mapper.toDTO(dog)));
		return new Kennel(dogs);
	}

	public DogDTO find(String name) {
		Optional<Dog> dog = repository.findByName(name); // not unique and crashes
		
		return (dog.isPresent()) ? mapper.toDTO(dog.get()) : null;
	}

	public DogDTO save(DogDTO new_dog) {
		return mapper.toDTO(repository.save(mapper.toModel(new_dog)));
	}

	public DogDTO update(DogDTO dog_change) {
		System.out.println(dog_change);
		Optional<Dog> dog = repository.findById(dog_change.getDogId());
		if (dog.isPresent()) {
			Dog meta_dog = dog.get();
			if (dog_change.getBreed() == null) {
				dog_change.setBreed(meta_dog.getBreed());
			}
			if (dog_change.getName() == null) {
				dog_change.setName(meta_dog.getName());
			}
			if (dog_change.getSize() == null) {
				dog_change.setSize(meta_dog.getSize());
			}
			return save(dog_change);
		}
		throw new IllegalArgumentException();
	}

	public void delete(Long moved_on_dog) {
		repository.deleteById(moved_on_dog);
	}
	public class Kennel {
		private List<DogDTO> kennel;
		public Kennel(List<DogDTO> kennel) {
			this.setKennel(kennel);
		}
		public void setKennel(List<DogDTO> kennel) {
			this.kennel = kennel;
		}
		public List<DogDTO> getKennel() {
			return kennel;
		}
	}
}
