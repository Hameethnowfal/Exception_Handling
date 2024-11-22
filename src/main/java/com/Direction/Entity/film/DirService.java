package com.Direction.Entity.film;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class DirService {
	
	private List<Director> directors= new ArrayList<>();
	
	
	public List<Director> findAll(){
		return directors;
	}
	
	public Director save(Director director) {
		directors.add(director);
		return director;
	}
	
	public Director findOne(int id){
		for(Director director:directors) {
			if(director.getId()==id) {
			return director;
			}
		}
		return null;
	}
	
	public Director deleteById(int id) {
		Iterator <Director> iterator= directors.iterator();
		while(iterator.hasNext()) {
			Director director=iterator.next();
			if(director.getId()==id) {
				iterator.remove();
				return director;
			}
		}
		return null;
	}
}
