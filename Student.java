package com.godoro.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long studentId;
	private String studentName;
	private int studentNote;
	@ManyToOne @JoinColumn(name = "shcoolId")
	private School schl;
	

	public School getSchl() {
		return schl;
	}
	public void setSchl(School schl) {
		this.schl = schl;
	}
	public Student(long studentId, String studentName, int studentNote) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentNote = studentNote;
	}
	public Student() {
	}
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentNote() {
		return studentNote;
	}
	public void setStudentNote(int studentNote) {
		this.studentNote = studentNote;
	}

}
