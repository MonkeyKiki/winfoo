package com.orange.upro.winfoo.manager;

import java.util.List;

import com.orange.upro.winfoo.model.Pgm;

public interface PgmManager {

	void insertPgm(Pgm pgm);
	
	void deletePgm(int id);

	List<Pgm> findAllPgms();

	Pgm findPgm(int id);
	
}
