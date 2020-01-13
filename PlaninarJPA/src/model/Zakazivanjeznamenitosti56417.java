package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the zakazivanjeznamenitosti_564_17 database table.
 * 
 */
@Entity
@Table(name="zakazivanjeznamenitosti_564_17")
@NamedQuery(name="Zakazivanjeznamenitosti56417.findAll", query="SELECT z FROM Zakazivanjeznamenitosti56417 z")
public class Zakazivanjeznamenitosti56417 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idZakazivanjeZnamenitosti;

	@Temporal(TemporalType.DATE)
	private Date datum;

	//bi-directional many-to-one association to Korisnik56417
	@ManyToOne
	@JoinColumn(name="Korisnik_idKorisnik")
	private Korisnik56417 korisnik56417;

	//bi-directional many-to-one association to Znamenitost56417
	@ManyToOne
	@JoinColumn(name="Znamenitost_idZnamenitost")
	private Znamenitost56417 znamenitost56417;

	public Zakazivanjeznamenitosti56417() {
	}

	public int getIdZakazivanjeZnamenitosti() {
		return this.idZakazivanjeZnamenitosti;
	}

	public void setIdZakazivanjeZnamenitosti(int idZakazivanjeZnamenitosti) {
		this.idZakazivanjeZnamenitosti = idZakazivanjeZnamenitosti;
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

	public Znamenitost56417 getZnamenitost56417() {
		return this.znamenitost56417;
	}

	public void setZnamenitost56417(Znamenitost56417 znamenitost56417) {
		this.znamenitost56417 = znamenitost56417;
	}

}