package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the korisnik_564_17 database table.
 * 
 */
@Entity
@Table(name="korisnik_564_17")
@NamedQuery(name="Korisnik56417.findAll", query="SELECT k FROM Korisnik56417 k")
public class Korisnik56417 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKorisnik;

	@Temporal(TemporalType.DATE)
	private Date datumIsteka;

	private String ime;

	private String password;

	private String prezime;

	private String username;
	
	//bi-directional many-to-one association to Izvestaj56417
	@OneToMany(mappedBy="korisnik56417")
	private List<Izvestaj56417> izvestaj56417s;

	//bi-directional many-to-one association to Komentar56417
	@OneToMany(mappedBy="korisnik56417")
	private List<Komentar56417> komentar56417s;

	//bi-directional many-to-one association to Rezervacijasmestaja56417
	@OneToMany(mappedBy="korisnik56417")
	private List<Rezervacijasmestaja56417> rezervacijasmestaja56417s;

	//bi-directional many-to-many association to Role56417
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="korisnik56417s")
	private List<Role56417> role56417s=new ArrayList<>();

	//bi-directional many-to-one association to Slika56417
	@OneToMany(mappedBy="korisnik56417")
	private List<Slika56417> slika56417s;

	//bi-directional many-to-one association to Zakazivanjeznamenitosti56417
	@OneToMany(mappedBy="korisnik56417")
	private List<Zakazivanjeznamenitosti56417> zakazivanjeznamenitosti56417s;

	public Korisnik56417() {
	}

	public int getIdKorisnik() {
		return this.idKorisnik;
	}

	public void setIdKorisnik(int idKorisnik) {
		this.idKorisnik = idKorisnik;
	}

	public Date getDatumIsteka() {
		return this.datumIsteka;
	}

	public void setDatumIsteka(Date datumIsteka) {
		this.datumIsteka = datumIsteka;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Izvestaj56417> getIzvestaj56417s() {
		return this.izvestaj56417s;
	}

	public void setIzvestaj56417s(List<Izvestaj56417> izvestaj56417s) {
		this.izvestaj56417s = izvestaj56417s;
	}

	public Izvestaj56417 addIzvestaj56417(Izvestaj56417 izvestaj56417) {
		getIzvestaj56417s().add(izvestaj56417);
		izvestaj56417.setKorisnik56417(this);

		return izvestaj56417;
	}

	public Izvestaj56417 removeIzvestaj56417(Izvestaj56417 izvestaj56417) {
		getIzvestaj56417s().remove(izvestaj56417);
		izvestaj56417.setKorisnik56417(null);

		return izvestaj56417;
	}

	public List<Komentar56417> getKomentar56417s() {
		return this.komentar56417s;
	}

	public void setKomentar56417s(List<Komentar56417> komentar56417s) {
		this.komentar56417s = komentar56417s;
	}

	public Komentar56417 addKomentar56417(Komentar56417 komentar56417) {
		getKomentar56417s().add(komentar56417);
		komentar56417.setKorisnik56417(this);

		return komentar56417;
	}

	public Komentar56417 removeKomentar56417(Komentar56417 komentar56417) {
		getKomentar56417s().remove(komentar56417);
		komentar56417.setKorisnik56417(null);

		return komentar56417;
	}

	public List<Rezervacijasmestaja56417> getRezervacijasmestaja56417s() {
		return this.rezervacijasmestaja56417s;
	}

	public void setRezervacijasmestaja56417s(List<Rezervacijasmestaja56417> rezervacijasmestaja56417s) {
		this.rezervacijasmestaja56417s = rezervacijasmestaja56417s;
	}

	public Rezervacijasmestaja56417 addRezervacijasmestaja56417(Rezervacijasmestaja56417 rezervacijasmestaja56417) {
		getRezervacijasmestaja56417s().add(rezervacijasmestaja56417);
		rezervacijasmestaja56417.setKorisnik56417(this);

		return rezervacijasmestaja56417;
	}

	public Rezervacijasmestaja56417 removeRezervacijasmestaja56417(Rezervacijasmestaja56417 rezervacijasmestaja56417) {
		getRezervacijasmestaja56417s().remove(rezervacijasmestaja56417);
		rezervacijasmestaja56417.setKorisnik56417(null);

		return rezervacijasmestaja56417;
	}

	public List<Role56417> getRole56417s() {
		return this.role56417s;
	}

	public void setRole56417s(List<Role56417> role56417s) {
		this.role56417s = role56417s;
	}

	public List<Slika56417> getSlika56417s() {
		return this.slika56417s;
	}

	public void setSlika56417s(List<Slika56417> slika56417s) {
		this.slika56417s = slika56417s;
	}

	public Slika56417 addSlika56417(Slika56417 slika56417) {
		getSlika56417s().add(slika56417);
		slika56417.setKorisnik56417(this);

		return slika56417;
	}

	public Slika56417 removeSlika56417(Slika56417 slika56417) {
		getSlika56417s().remove(slika56417);
		slika56417.setKorisnik56417(null);

		return slika56417;
	}

	public List<Zakazivanjeznamenitosti56417> getZakazivanjeznamenitosti56417s() {
		return this.zakazivanjeznamenitosti56417s;
	}

	public void setZakazivanjeznamenitosti56417s(List<Zakazivanjeznamenitosti56417> zakazivanjeznamenitosti56417s) {
		this.zakazivanjeznamenitosti56417s = zakazivanjeznamenitosti56417s;
	}

	public Zakazivanjeznamenitosti56417 addZakazivanjeznamenitosti56417(Zakazivanjeznamenitosti56417 zakazivanjeznamenitosti56417) {
		getZakazivanjeznamenitosti56417s().add(zakazivanjeznamenitosti56417);
		zakazivanjeznamenitosti56417.setKorisnik56417(this);

		return zakazivanjeznamenitosti56417;
	}

	public Zakazivanjeznamenitosti56417 removeZakazivanjeznamenitosti56417(Zakazivanjeznamenitosti56417 zakazivanjeznamenitosti56417) {
		getZakazivanjeznamenitosti56417s().remove(zakazivanjeznamenitosti56417);
		zakazivanjeznamenitosti56417.setKorisnik56417(null);

		return zakazivanjeznamenitosti56417;
	}

	public void addRole(Role56417 role) {
		role56417s.add(role);
		
	}

}