package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the staza_564_17 database table.
 * 
 */
@Entity
@Table(name="staza_564_17")
@NamedQuery(name="Staza56417.findAll", query="SELECT s FROM Staza56417 s")
public class Staza56417 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idStaza;

	@Lob
	private byte[] mapa;

	private String opis;

	private int tezina;

	//bi-directional many-to-one association to Planina56417
	@ManyToOne
	@JoinColumn(name="Planina_idPlanina")
	private Planina56417 planina56417;

	//bi-directional many-to-one association to Znamenitost56417
	@OneToMany(mappedBy="staza56417")
	private List<Znamenitost56417> znamenitost56417s;

	public Staza56417() {
	}

	public int getIdStaza() {
		return this.idStaza;
	}

	public void setIdStaza(int idStaza) {
		this.idStaza = idStaza;
	}

	public byte[] getMapa() {
		return this.mapa;
	}

	public void setMapa(byte[] mapa) {
		this.mapa = mapa;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public int getTezina() {
		return this.tezina;
	}

	public void setTezina(int tezina) {
		this.tezina = tezina;
	}

	public Planina56417 getPlanina56417() {
		return this.planina56417;
	}

	public void setPlanina56417(Planina56417 planina56417) {
		this.planina56417 = planina56417;
	}

	public List<Znamenitost56417> getZnamenitost56417s() {
		return this.znamenitost56417s;
	}

	public void setZnamenitost56417s(List<Znamenitost56417> znamenitost56417s) {
		this.znamenitost56417s = znamenitost56417s;
	}

	public Znamenitost56417 addZnamenitost56417(Znamenitost56417 znamenitost56417) {
		getZnamenitost56417s().add(znamenitost56417);
		znamenitost56417.setStaza56417(this);

		return znamenitost56417;
	}

	public Znamenitost56417 removeZnamenitost56417(Znamenitost56417 znamenitost56417) {
		getZnamenitost56417s().remove(znamenitost56417);
		znamenitost56417.setStaza56417(null);

		return znamenitost56417;
	}

}