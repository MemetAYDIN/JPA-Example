package com.godoro.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class QueryTest {
	
	public static void main(String[] args) {
		
		
		EntityManagerFactory factory=Persistence
				.createEntityManagerFactory("my-persistence-unit");
		EntityManager entityManager=factory.createEntityManager();
		
		long shcoolId=1;
		
		String jpq="select student from Student as student "
				+ "where student.schl.shcoolId= :shcoolId";
		TypedQuery<Student> query=entityManager.createQuery(jpq, Student.class);
		
		
		query.setParameter("shcoolId", shcoolId);
		
		List<Student> studentList=query.getResultList();
		
		
		entityManager.close();
		
		for(Student student:studentList)
		{
			System.out.println(student.getStudentId()+" "+student.getStudentName()
								+" "+student.getStudentNote()
								+" "+student.getSchl().getShcoolId()
								+" "+student.getSchl().getSchollName());
		}

	}

}
