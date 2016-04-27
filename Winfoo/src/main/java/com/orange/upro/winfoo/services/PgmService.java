package com.orange.upro.winfoo.services;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.orange.upro.winfoo.manager.PgmManager;
import com.orange.upro.winfoo.model.Pgm;
import com.orange.upro.winfoo.model.PgmResponse;

/**
 * Service REST pour les PGM
 * 
 * @author Joseph Beaufils
 *
 */
@Path("/pgm")
@Component
public class PgmService {

	@Autowired
	private PgmManager pgmManager;

	/**
	 * Retourne la liste des PGM
	 * 
	 * @return La liste au format JSON jTable
	 */
	@POST
	@Path("/list")
	@Produces("application/json")
	public Response getPgmList() {
		List<Pgm> pgms = pgmManager.findAllPgms();

		PgmResponse response = new PgmResponse();
		response.Result = "OK";
		response.Records = pgms;

		return Response.status(200).entity(response).build();
	}

//	@POST
//	@Path("/create")
//	@Produces("application/json")
//	public Response createPgm(@FormParam("anneeDemande") Integer anneeDemande) {
//		Pgm pgm = new Pgm();
//		pgm.setAnneeDemande(anneeDemande);
//		
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		entityManager.getTransaction().begin();
//		entityManager.persist(pgm);
//		entityManager.getTransaction().commit();
//		entityManager.close();
//		
//		PgmResponse response = new PgmResponse();
//		response.Result = "OK";
//		response.Record = pgm;
//
//		return Response.status(200).entity(response).build();
//	}

	@POST
	@Path("/delete")
	@Produces("application/json")
	public Response deletePgm(@FormParam("id") Integer id) {
		pgmManager.deletePgm(id);
		
		PgmResponse response = new PgmResponse();
		response.Result = "OK";

		return Response.status(200).entity(response).build();
	}
	
}
