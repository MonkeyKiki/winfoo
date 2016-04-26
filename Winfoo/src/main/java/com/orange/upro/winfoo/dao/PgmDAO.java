package com.orange.upro.winfoo.dao;

import java.util.List;

import com.orange.upro.winfoo.model.Pgm;

public interface PgmDAO {

	void insertPgm(Pgm pgm);

	void deletePgm(Pgm pgm);

	List<Pgm> findAllPgms();

	Pgm findPgm(int id);

}
