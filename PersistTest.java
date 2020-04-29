package com.godoro.jpa;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistTest {
	public static void main(String[] args) {
		
		School schl=new School(0,"Aydin Collage");
		schl.setStudentList(new ArrayList<Student>());
		
		
		Student stdnt1=new Student(0,"Tesla",100);
		stdnt1.setSchl(schl);
		schl.getStudentList().add(stdnt1);
		
		Student stdnt2=new Student(0,"Edison",80);
		stdnt2.setSchl(schl);
		schl.getStudentList().add(stdnt2);
		
		
		Student stdnt3=new Student(0,"Newton",95);
		stdnt3.setSchl(schl);
		schl.getStudentList().add(stdnt3);
		
		

		EntityManagerFactory factory=Persistence
				.createEntityManagerFactory("my-persistence-unit");
		EntityManager entityManager=factory.createEntityManager();
		
		
		entityManager.getTransaction().begin();
		entityManager.persist(schl);
		
		entityManager.getTransaction().commit();
		
		
		entityManager.close();
		
		System.out.println(schl.getShcoolId()+" "+schl.getSchollName());
		for(Student stdnt:schl.studentList)
		{
			System.out.println(stdnt.getStudentId()+" "+stdnt.getStudentName()+" "+stdnt.getStudentNote());
		}
		
		
	}

}
