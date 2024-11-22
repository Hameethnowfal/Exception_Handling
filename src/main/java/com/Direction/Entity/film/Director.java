package com.Direction.Entity.film;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Director")
public class Director {
	
	@Id
	@GeneratedValue
	private int id;
	@Column(name="Dir_name")
	private String name;
	private int year;
	
	@OneToMany(mappedBy="director")
	public List<Film> film;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getYear() {
		return year;
	}
	public List<Film> getFilm() {
		return film;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setFilm(List<Film> film) {
		this.film = film;
	}
	
	@Override
	public String toString() {
		return "Director [id=" + id + ", name=" + name + ", year=" + year + ", film=" + film + "]";
	}
}
