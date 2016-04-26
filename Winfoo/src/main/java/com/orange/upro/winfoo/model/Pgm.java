package com.orange.upro.winfoo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the pgm database table.
 * 
 */
@Entity
@NamedQuery(name="Pgm.findAll", query="SELECT p FROM Pgm p")
public class Pgm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="ANNEE_DEMANDE")
	private int anneeDemande;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_ECHANGE_DO_DMGP")
	private Date dateEchangeDoDmgp;

	private String deployeur;

	@Column(name="DO")
	private String do_;

	private int dpt;

	private String dr;

	private int etude;

	@Column(name="EXTENSION_OLT")
	private int extensionOlt;

	private String logement;

	@Column(name="LOT_PUBLIE")
	private int lotPublie;

	@Column(name="LOTS_DEPLOYES")
	private String lotsDeployes;

	@Column(name="MISE_EN_SERVICE_1_OLT")
	private String miseEnService1Olt;

	@Column(name="NRA_IMPACTES")
	private String nraImpactes;

	@Column(name="NRO_IMPACTES")
	private String nroImpactes;

	private String olt;

	@Column(name="PREV_RACCORDABLE_DOO_DONC")
	private int prevRaccordableDooDonc;

	@Column(name="PREVISION_DATE_PUBLICATION")
	private Timestamp previsionDatePublication;

	private String priorite;

	private Timestamp republication;

	@Column(name="VILLES_FTTH")
	private String villesFtth;

	@Column(name="ZM_LOT")
	private int zmLot;

	private String zone;

	public Pgm() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAnneeDemande() {
		return this.anneeDemande;
	}

	public void setAnneeDemande(int anneeDemande) {
		this.anneeDemande = anneeDemande;
	}

	public Date getDateEchangeDoDmgp() {
		return this.dateEchangeDoDmgp;
	}

	public void setDateEchangeDoDmgp(Date dateEchangeDoDmgp) {
		this.dateEchangeDoDmgp = dateEchangeDoDmgp;
	}

	public String getDeployeur() {
		return this.deployeur;
	}

	public void setDeployeur(String deployeur) {
		this.deployeur = deployeur;
	}

	public String getDo_() {
		return this.do_;
	}

	public void setDo_(String do_) {
		this.do_ = do_;
	}

	public int getDpt() {
		return this.dpt;
	}

	public void setDpt(int dpt) {
		this.dpt = dpt;
	}

	public String getDr() {
		return this.dr;
	}

	public void setDr(String dr) {
		this.dr = dr;
	}

	public int getEtude() {
		return this.etude;
	}

	public void setEtude(int etude) {
		this.etude = etude;
	}

	public int getExtensionOlt() {
		return this.extensionOlt;
	}

	public void setExtensionOlt(int extensionOlt) {
		this.extensionOlt = extensionOlt;
	}

	public String getLogement() {
		return this.logement;
	}

	public void setLogement(String logement) {
		this.logement = logement;
	}

	public int getLotPublie() {
		return this.lotPublie;
	}

	public void setLotPublie(int lotPublie) {
		this.lotPublie = lotPublie;
	}

	public String getLotsDeployes() {
		return this.lotsDeployes;
	}

	public void setLotsDeployes(String lotsDeployes) {
		this.lotsDeployes = lotsDeployes;
	}

	public String getMiseEnService1Olt() {
		return this.miseEnService1Olt;
	}

	public void setMiseEnService1Olt(String miseEnService1Olt) {
		this.miseEnService1Olt = miseEnService1Olt;
	}

	public String getNraImpactes() {
		return this.nraImpactes;
	}

	public void setNraImpactes(String nraImpactes) {
		this.nraImpactes = nraImpactes;
	}

	public String getNroImpactes() {
		return this.nroImpactes;
	}

	public void setNroImpactes(String nroImpactes) {
		this.nroImpactes = nroImpactes;
	}

	public String getOlt() {
		return this.olt;
	}

	public void setOlt(String olt) {
		this.olt = olt;
	}

	public int getPrevRaccordableDooDonc() {
		return this.prevRaccordableDooDonc;
	}

	public void setPrevRaccordableDooDonc(int prevRaccordableDooDonc) {
		this.prevRaccordableDooDonc = prevRaccordableDooDonc;
	}

	public Timestamp getPrevisionDatePublication() {
		return this.previsionDatePublication;
	}

	public void setPrevisionDatePublication(Timestamp previsionDatePublication) {
		this.previsionDatePublication = previsionDatePublication;
	}

	public String getPriorite() {
		return this.priorite;
	}

	public void setPriorite(String priorite) {
		this.priorite = priorite;
	}

	public Timestamp getRepublication() {
		return this.republication;
	}

	public void setRepublication(Timestamp republication) {
		this.republication = republication;
	}

	public String getVillesFtth() {
		return this.villesFtth;
	}

	public void setVillesFtth(String villesFtth) {
		this.villesFtth = villesFtth;
	}

	public int getZmLot() {
		return this.zmLot;
	}

	public void setZmLot(int zmLot) {
		this.zmLot = zmLot;
	}

	public String getZone() {
		return this.zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

}