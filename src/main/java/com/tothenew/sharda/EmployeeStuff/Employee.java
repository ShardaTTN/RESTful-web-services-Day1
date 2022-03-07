package com.tothenew.sharda.EmployeeStuff;

import javax.validation.constraints.Size;

public class Employee {
	
	private Integer id;
	
	@Size(min = 4, message = "Name should be of atleast 4 characters!")
	private String name;
	private Integer age;
	
	public Employee() {
		
	}
	
	public Employee(Integer id, String name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return String.format("Employee [id=%s, name=%s, age=%s]", id, name, age);
	}
}