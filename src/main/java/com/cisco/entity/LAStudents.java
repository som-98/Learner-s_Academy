package com.cisco.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class LAStudents {

	@Id
	private int rollno;
	private String student_name;
	@OneToOne
	private Classes la;
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public Classes getLa() {
		return la;
	}
	public void setLa(Classes la) {
		this.la = la;
	}
}
