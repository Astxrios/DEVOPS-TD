package com.example.StudentManager;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Students")
public class Student {
	@Id
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="surname")
	private String surname;

	@Column(name="email")
	private String email;

	@Column(name="id_institute")
	private Integer idInstitute;

	@Column(name="id_cursus")
	private Integer idCursus;
	
	
	public Student() {
		super();
	}
	public Student(Integer id, String name, String surname, String email, Integer idInstitute, Integer idCursus) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.idInstitute = idInstitute;
		this.idCursus = idCursus;
	}
	
	
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getIdInstitute() {
		return idInstitute;
	}
	public void setIdInstitute(Integer idInstitute) {
		this.idInstitute = idInstitute;
	}
	public Integer getIdCursus() {
		return idCursus;
	}
	public void setIdCursus(Integer idCursus) {
		this.idCursus = idCursus;
	}
	
	
	
}
