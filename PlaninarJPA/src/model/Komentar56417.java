package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the komentar_564_17 database table.
 * 
 */
@Entity
@Table(name="komentar_564_17")
@NamedQuery(name="Komentar56417.findAll", query="SELECT k FROM Komentar56417 k")
public class Komentar56417 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKomentar;

	private String opis;

	//bi-directional many-to-one association to Korisnik56417
	@ManyToOne
	@JoinColumn(name="Korisnik_idKorisnik")
	private Korisnik56417 korisnik56417;

	//bi-directional many-to-one association to Znamenitost56417
	@ManyToOne
	@JoinColumn(name="Znamenitost_idZnamenitost")
	private Znamenitost56417 znamenitost56417;

	public Komentar56417() {
	}

	public int getIdKomentar() {
		return this.idKomentar;
	}

	public void setIdKomentar(int idKomentar) {
		this.idKomentar = idKomentar;
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

	public Znamenitost56417 getZnamenitost56417() {
		return this.znamenitost56417;
	}

	public void setZnamenitost56417(Znamenitost56417 znamenitost56417) {
		this.znamenitost56417 = znamenitost56417;
	}

}