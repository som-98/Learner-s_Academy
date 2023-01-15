package com.cisco.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class StudentClasses {

	@Id
	private int c_id;
	private String c_name;
	
	@OneToMany(targetEntity=LAStudents.class, mappedBy="la", fetch=FetchType.EAGER)
	private List<LAStudents> st = new ArrayList<LAStudents>();
	public StudentClasses() {
		
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public List<LAStudents> getSt() {
		return st;
	}

	public void setSt(List<LAStudents> st) {
		this.st = st;
	}
}
