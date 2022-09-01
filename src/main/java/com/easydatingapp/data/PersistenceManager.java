package com.easydatingapp.data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;

public class PersistenceManager
{
	@PersistenceUnit
	public static EntityManagerFactory _entityManagementFactory = Persistence.createEntityManagerFactory("easydating-pu");
	
	@PersistenceContext
	public static EntityManager _entityManager = _entityManagementFactory.createEntityManager(); 
}

