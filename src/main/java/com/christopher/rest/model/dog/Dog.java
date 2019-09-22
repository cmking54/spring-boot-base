package com.christopher.rest.model.dog;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@Table(name="dog")
@ToString
public class Dog {
	@Id
	@Column(name="dog_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	above denotes an auto generated value, and strategy is using the databases autoincrement
	private long id;
	
//	@OneToOne
//	@JoinColumn(name="keeper_id", referencedColumnName="keeper_id")
//	@Column(name="keeper_id")
//	private long keeper_id;
//	Below is for relation
//	@OneToOne(mappedBy = "dog_id")
//	private Dog dog;
	
	@Column(name="name")
	private String name;
	
	@Column(name="breed")
	private String breed;
	
	@Column(name="size")
	private String size;

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
		return id;
	}

	public void setDogId(long dogId) {
		id = dogId;
	}

	@Override
	public String toString() {
		return "Dog [id=" + id + ", name=" + name + ", breed=" + breed + ", size=" + size + "]";
	}

//	public void setKeeperId(long keeperId) {
//		keeper_id = keeperId;
//	}
//
//	public long getKeeperId() {
//		return keeper_id;
//	}

}
