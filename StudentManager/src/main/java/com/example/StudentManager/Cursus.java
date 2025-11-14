package com.example.StudentManager;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cursus")
public class Cursus {
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cursus() {
		super();
	}

	public Cursus(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
		System.out.println("in 'Cursus constructor'" + id);
	}

	@Id
	@Column(name="idCursus")
	private Integer id;

	@Column(name="name")
	private String name;
	

}
