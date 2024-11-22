package com.Direction.Entity.film;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Film")
public class Film {
	
	@Id
	@GeneratedValue
	private int id;
	@Column(name="film_name")
	private String name;
	private int year;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="director_id")
	public Director director;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getYear() {
		return year;
	}
	public Director getDirector() {
		return director;
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
	public void setDirector(Director director) {
		this.director = director;
	}
	
	@Override
	public String toString() {
		return "Film [id=" + id + ", name=" + name + ", year=" + year + "]";
	}
}