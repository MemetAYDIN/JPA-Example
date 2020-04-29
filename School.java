package com.godoro.jpa;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class School {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long shcoolId;
	private String schollName;
	@OneToMany(mappedBy = "schl", cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	List<Student> studentList;
	
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	public School(long shcoolId, String schollName) {
		this.shcoolId = shcoolId;
		this.schollName = schollName;
	}
	public School() {
	}
	public long getShcoolId() {
		return shcoolId;
	}
	public void setShcoolId(long shcoolId) {
		this.shcoolId = shcoolId;
	}
	public String getSchollName() {
		return schollName;
	}
	public void setSchollName(String schollName) {
		this.schollName = schollName;
	}


	
	
}
