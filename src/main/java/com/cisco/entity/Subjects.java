package com.cisco.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Subjects {
@Id
@GeneratedValue
private int subject_id;
private String subject_name;
@ManyToOne
private Classes lacc;
public Subjects() {
	
}
public int getSubject_id() {
	return subject_id;
}
public void setSubject_id(int subject_id) {
	this.subject_id = subject_id;
}
public String getSubject_name() {
	return subject_name;
}
public void setSubject_name(String subject_name) {
	this.subject_name = subject_name;
}
public Classes getLacc() {
	return lacc;
}
public void setLacc(Classes lacc) {
	this.lacc = lacc;
}

}
