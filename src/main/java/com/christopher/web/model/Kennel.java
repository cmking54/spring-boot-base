package com.christopher.web.model;

import java.util.ArrayList;
import java.util.List;

public class Kennel {
	private List<Dog> kennel;
	public Kennel() {
		kennel = new ArrayList<>();
	}
	public Kennel(List<Dog> kennel) {
		this.setDogs(kennel);
	}
	public List<Dog> getDogs() {
		return kennel;
	}
	public void setDogs(List<Dog> dogs) {
		this.kennel = dogs;
	}
	public void addDog(Dog d) {
		kennel.add(d);
	}
	@Override
	public String toString() {
		return "Kennel [kennel=" + kennel + "]";
	}
}
