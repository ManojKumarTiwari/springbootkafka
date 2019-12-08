package com.maddy.springbootkafkadec2019.kafkaconsumer.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.maddy.springbootkafkadec2019.kafkaconsumer.json.CustomLocalDateDeserializer;

public class Employee {

	@JsonProperty("employee_id")
	private String employeeId;
	
	private String name;
	
	@JsonProperty("date_of_joining")
	@JsonDeserialize(using = CustomLocalDateDeserializer.class)
	private LocalDate doj;

	public Employee() {
	}

	public Employee(String employeeId, String name, LocalDate doj) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.doj = doj;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", doj=" + doj + "]";
	}

}
