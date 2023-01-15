package com.cisco.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Teachers {
	@Id
	@GeneratedValue
	private int rid;
	private int teacher_id;
	private String teacher_name;
	@OneToMany(targetEntity=Classes.class, mappedBy="lat", fetch=FetchType.EAGER)
	private List<Classes> lac = new ArrayList<Classes>();
	public Teachers() {
		
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public List<Classes> getLac() {
		return lac;
	}
	public void setLac(List<Classes> lac) {
		this.lac = lac;
	}
	
}
