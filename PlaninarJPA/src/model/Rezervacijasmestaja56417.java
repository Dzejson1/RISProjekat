package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the rezervacijasmestaja_564_17 database table.
 * 
 */
@Entity
@Table(name="rezervacijasmestaja_564_17")
@NamedQuery(name="Rezervacijasmestaja56417.findAll", query="SELECT r FROM Rezervacijasmestaja56417 r")
public class Rezervacijasmestaja56417 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRezervacijaSmestaja;

	@Temporal(TemporalType.DATE)
	private Date datum;

	//bi-directional many-to-one association to Korisnik56417
	@ManyToOne
	@JoinColumn(name="Korisnik_idKorisnik")
	private Korisnik56417 korisnik56417;

	//bi-directional many-to-one association to Planinarskidom56417
	@ManyToOne
	@JoinColumn(name="PlaninarskiDom_idPlaninarskiDom")
	private Planinarskidom56417 planinarskidom56417;

	public Rezervacijasmestaja56417() {
	}

	public int getIdRezervacijaSmestaja() {
		return this.idRezervacijaSmestaja;
	}

	public void setIdRezervacijaSmestaja(int idRezervacijaSmestaja) {
		this.idRezervacijaSmestaja = idRezervacijaSmestaja;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Korisnik56417 getKorisnik56417() {
		return this.korisnik56417;
	}

	public void setKorisnik56417(Korisnik56417 korisnik56417) {
		this.korisnik56417 = korisnik56417;
	}

	public Planinarskidom56417 getPlaninarskidom56417() {
		return this.planinarskidom56417;
	}

	public void setPlaninarskidom56417(Planinarskidom56417 planinarskidom56417) {
		this.planinarskidom56417 = planinarskidom56417;
	}

}