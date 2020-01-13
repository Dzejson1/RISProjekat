package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the izvestaj_564_17 database table.
 * 
 */
@Entity
@Table(name="izvestaj_564_17")
@NamedQuery(name="Izvestaj56417.findAll", query="SELECT i FROM Izvestaj56417 i")
public class Izvestaj56417 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIzvestaj;

	private String opis;

	//bi-directional many-to-one association to Korisnik56417
	@ManyToOne
	@JoinColumn(name="Korisnik_idKorisnik")
	private Korisnik56417 korisnik56417;

	//bi-directional many-to-one association to Planina56417
	@ManyToOne
	@JoinColumn(name="Planina_idPlanina")
	private Planina56417 planina56417;

	public Izvestaj56417() {
	}

	public int getIdIzvestaj() {
		return this.idIzvestaj;
	}

	public void setIdIzvestaj(int idIzvestaj) {
		this.idIzvestaj = idIzvestaj;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Korisnik56417 getKorisnik56417() {
		return this.korisnik56417;
	}

	public void setKorisnik56417(Korisnik56417 korisnik56417) {
		this.korisnik56417 = korisnik56417;
	}

	public Planina56417 getPlanina56417() {
		return this.planina56417;
	}

	public void setPlanina56417(Planina56417 planina56417) {
		this.planina56417 = planina56417;
	}

}