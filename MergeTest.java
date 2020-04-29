package com.godoro.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MergeTest {
	public static void main(String[] args) {
		long dataId=1;
		
		EntityManagerFactory factory=Persistence
				.createEntityManagerFactory("my-persistence-unit");
		EntityManager entityManager=factory.createEntityManager();
		
		
		//yazma işlemi için mutlaka transction kullanılmalı. Okurken lazım değil
		entityManager.getTransaction().begin();
		Data data=entityManager.find(Data.class, dataId);
		data.setDataName("Yeni ad");
		data.setDataValue(99.123);
		entityManager.merge(data);
		
		entityManager.getTransaction().commit();
		
		
		entityManager.close();
		
		
	}

}
