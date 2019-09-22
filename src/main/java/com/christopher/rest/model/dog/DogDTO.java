package com.christopher.rest.model.dog;

import lombok.ToString;

public class DogDTO {
	private long dog_id;
//	keeper_id;
//	@NotNull // might need this
	private String name, breed, size;
//	public long getKeeperId() {
//		return keeper_id;
//	}
//	public void setKeeperId(long keeper_id) {
//		this.keeper_id = keeper_id;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public long getDogId() {
		return dog_id;
	}
	public void setDogId(long dogId) {
		dog_id = dogId;		
	}
	@Override
	public String toString() {
		return "DogDTO [dog_id=" + dog_id + ", name=" + name + ", breed=" + breed + ", size=" + size + "]";
	}
	
}
