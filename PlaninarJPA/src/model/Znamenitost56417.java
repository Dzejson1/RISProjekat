package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the znamenitost_564_17 database table.
 * 
 */
@Entity
@Table(name="znamenitost_564_17")
@NamedQuery(name="Znamenitost56417.findAll", query="SELECT z FROM Znamenitost56417 z")
public class Znamenitost56417 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idZnamenitost;

	private String opis;

	private byte potrebnoZakazati;

	@Lob
	private byte[] slika;

	//bi-directional many-to-one association to Komentar56417
	@OneToMany(mappedBy="znamenitost56417")
	private List<Komentar56417> komentar56417s;

	//bi-directional many-to-one association to Zakazivanjeznamenitosti56417
	@OneToMany(mappedBy="znamenitost56417")
	private List<Zakazivanjeznamenitosti56417> zakazivanjeznamenitosti56417s;

	//bi-directional many-to-one association to Staza56417
	@ManyToOne
	@JoinColumn(name="Staza_idStaza")
	private Staza56417 staza56417;

	//bi-directional many-to-one association to Tipznamenitosti56417
	@ManyToOne
	@JoinColumn(name="TipZnamenitosti_idTipZnamenitosti")
	private Tipznamenitosti56417 tipznamenitosti56417;

	public Znamenitost56417() {
	}

	public int getIdZnamenitost() {
		return this.idZnamenitost;
	}

	public void setIdZnamenitost(int idZnamenitost) {
		this.idZnamenitost = idZnamenitost;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public byte getPotrebnoZakazati() {
		return this.potrebnoZakazati;
	}

	public void setPotrebnoZakazati(byte potrebnoZakazati) {
		this.potrebnoZakazati = potrebnoZakazati;
	}

	public byte[] getSlika() {
		return this.slika;
	}

	public void setSlika(byte[] slika) {
		this.slika = slika;
	}

	public List<Komentar56417> getKomentar56417s() {
		return this.komentar56417s;
	}

	public void setKomentar56417s(List<Komentar56417> komentar56417s) {
		this.komentar56417s = komentar56417s;
	}

	public Komentar56417 addKomentar56417(Komentar56417 komentar56417) {
		getKomentar56417s().add(komentar56417);
		komentar56417.setZnamenitost56417(this);

		return komentar56417;
	}

	public Komentar56417 removeKomentar56417(Komentar56417 komentar56417) {
		getKomentar56417s().remove(komentar56417);
		komentar56417.setZnamenitost56417(null);

		return komentar56417;
	}

	public List<Zakazivanjeznamenitosti56417> getZakazivanjeznamenitosti56417s() {
		return this.zakazivanjeznamenitosti56417s;
	}

	public void setZakazivanjeznamenitosti56417s(List<Zakazivanjeznamenitosti56417> zakazivanjeznamenitosti56417s) {
		this.zakazivanjeznamenitosti56417s = zakazivanjeznamenitosti56417s;
	}

	public Zakazivanjeznamenitosti56417 addZakazivanjeznamenitosti56417(Zakazivanjeznamenitosti56417 zakazivanjeznamenitosti56417) {
		getZakazivanjeznamenitosti56417s().add(zakazivanjeznamenitosti56417);
		zakazivanjeznamenitosti56417.setZnamenitost56417(this);

		return zakazivanjeznamenitosti56417;
	}

	public Zakazivanjeznamenitosti56417 removeZakazivanjeznamenitosti56417(Zakazivanjeznamenitosti56417 zakazivanjeznamenitosti56417) {
		getZakazivanjeznamenitosti56417s().remove(zakazivanjeznamenitosti56417);
		zakazivanjeznamenitosti56417.setZnamenitost56417(null);

		return zakazivanjeznamenitosti56417;
	}

	public Staza56417 getStaza56417() {
		return this.staza56417;
	}

	public void setStaza56417(Staza56417 staza56417) {
		this.staza56417 = staza56417;
	}

	public Tipznamenitosti56417 getTipznamenitosti56417() {
		return this.tipznamenitosti56417;
	}

	public void setTipznamenitosti56417(Tipznamenitosti56417 tipznamenitosti56417) {
		this.tipznamenitosti56417 = tipznamenitosti56417;
	}

}