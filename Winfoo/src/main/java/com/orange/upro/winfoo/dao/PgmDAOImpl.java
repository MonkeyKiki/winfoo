package com.orange.upro.winfoo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.orange.upro.winfoo.model.Pgm;

@Repository
public class PgmDAOImpl implements PgmDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertPgm(Pgm pgm) {
		entityManager.persist(pgm);
	}

	@Override
	public void deletePgm(Pgm pgm) {
		entityManager.remove(pgm);
	}

	@Override
	public void deleteAllPgms() {
		entityManager.createNamedQuery("Pgm.deleteAll").executeUpdate();
	}

	@Override
	public List<Pgm> findAllPgms() {
		return entityManager.createNamedQuery("Pgm.findAll", Pgm.class).getResultList();
	}

	@Override
	public Pgm findPgm(int id) {
		return entityManager.find(Pgm.class, id);
	}

}
