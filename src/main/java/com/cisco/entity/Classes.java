package com.cisco.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Classes {
@Id
private int class_id;
private String class_name;
@ManyToOne
private Teachers lat;
@OneToMany(targetEntity=Subjects.class, mappedBy="lacc", fetch=FetchType.EAGER)
private List<Subjects> las = new ArrayList<Subjects>();

public Classes() {
	super();
}
public int getClass_id() {
	return class_id;
}
public void setClass_id(int class_id) {
	this.class_id = class_id;
}
public String getClass_name() {
	return class_name;
}
public void setClass_name(String class_name) {
	this.class_name = class_name;
}
public Teachers getLat() {
	return lat;
}
public void setLat(Teachers lat) {
	this.lat = lat;
}
public List<Subjects> getLas() {
	return las;
}
public void setLas(List<Subjects> las) {
	this.las = las;
}
}
