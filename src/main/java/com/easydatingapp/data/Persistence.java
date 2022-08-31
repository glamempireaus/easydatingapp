package com.easydatingapp.data;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class Persistence {

   @PersistenceContext
   public static EntityManager _entityManager;
}