package com.christopher.rest.model.dog;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends CrudRepository<Dog, Long> {
//	jpaRepo has paging and sorting; crud is simplier 
	
	// should return type have optional to match ancestor
	Optional<Dog> findByName(String name); // made dynamically; => select * from dog where dog.name == <parameter>
//	Dog findByKeeper(Long keeper_id);
}
