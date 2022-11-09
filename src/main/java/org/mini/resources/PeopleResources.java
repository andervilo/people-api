package org.mini.resources;

import java.util.List;

import org.mini.entities.People;
import org.mini.repositories.PeopleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/people")
public class PeopleResources {
	
	private final PeopleRepository peopleRepository;
	
	@GetMapping
	public ResponseEntity<List<People>> getPeople() {
		return ResponseEntity.ok(peopleRepository.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<People> getPeopleById(@PathVariable Long id) {
		return ResponseEntity.ok(peopleRepository.findById(id).get());
	}

	@PostMapping
	public ResponseEntity<People> savePeople(@RequestBody People people) {
		System.out.println(people);
		return ResponseEntity.ok(peopleRepository.save(people));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<People> updatePeople(@PathVariable Long id, People people) {
		return ResponseEntity.ok(peopleRepository.save(people));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletePeople(@PathVariable Long id) {
		peopleRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
