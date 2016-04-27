package com.orange.upro.winfoo.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orange.upro.winfoo.dao.PgmDAO;
import com.orange.upro.winfoo.model.Pgm;

@Service
public class PgmManagerImpl implements PgmManager {

	@Autowired
	private PgmDAO pgmDAO;

	@Transactional
	@Override
	public void insertPgm(Pgm pgm) {
		pgmDAO.insertPgm(pgm);
	}

	@Transactional
	@Override
	public void deletePgm(int id) {
		Pgm pgm = pgmDAO.findPgm(id);
		pgmDAO.deletePgm(pgm);
	}

	@Transactional
	@Override
	public void deleteAllPgms() {
		pgmDAO.deleteAllPgms();
	}

	@Override
	public List<Pgm> findAllPgms() {
		return pgmDAO.findAllPgms();
	}

	@Override
	public Pgm findPgm(int id) {
		return pgmDAO.findPgm(id);
	}


}
