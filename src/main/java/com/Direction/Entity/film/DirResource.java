package com.Direction.Entity.film;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class DirResource {
	
	@Autowired
	DirService service;
	
	@GetMapping("/directors")
	public List<Director> findAllDir(){
		return service.findAll();
	}
	
	@GetMapping("/directors/{id}")
	public Director findDir(@PathVariable int id){
		Director dir=service.findOne(id);
		if(dir==null) {
			throw new DirNotFoundException("id "+ id);
		}
		return dir;
	}
	
	@GetMapping("/directors/hateoas/{id}")
	public EntityModel<Director> findDir_hateoas(@PathVariable int id){
		Director dir=service.findOne(id);
		if(dir==null){
			throw new DirNotFoundException("id "+id);
		}
		EntityModel<Director> resource=EntityModel.of(dir);
		WebMvcLinkBuilder linkTo=linkTo(methodOn(this.getClass()).findAllDir());
		resource.add(linkTo.withRel("all-directors"));
		return resource;
	}
	
	@PostMapping("/directors")
	public ResponseEntity<Object> createDir(@Valid @RequestBody Director director) {
		Director saved=service.save(director);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(saved.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/directors/{id}")
	public Director deleteDir(@PathVariable int id) {
		Director dir=service.deleteById(id);
		if(dir==null) {
			throw new DirNotFoundException("id "+ id);
		}
		return dir;
	}
}