package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the planinarskidom_564_17 database table.
 * 
 */
@Entity
@Table(name="planinarskidom_564_17")
@NamedQuery(name="Planinarskidom56417.findAll", query="SELECT p FROM Planinarskidom56417 p")
public class Planinarskidom56417 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPlaninarskiDom;

	private String naziv;

	//bi-directional many-to-one association to Planina56417
	@ManyToOne
	@JoinColumn(name="Planina_idPlanina")
	private Planina56417 planina56417;

	//bi-directional many-to-one association to Rezervacijasmestaja56417
	@OneToMany(mappedBy="planinarskidom56417")
	private List<Rezervacijasmestaja56417> rezervacijasmestaja56417s;

	public Planinarskidom56417() {
	}

	public int getIdPlaninarskiDom() {
		return this.idPlaninarskiDom;
	}

	public void setIdPlaninarskiDom(int idPlaninarskiDom) {
		this.idPlaninarskiDom = idPlaninarskiDom;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Planina56417 getPlanina56417() {
		return this.planina56417;
	}

	public void setPlanina56417(Planina56417 planina56417) {
		this.planina56417 = planina56417;
	}

	public List<Rezervacijasmestaja56417> getRezervacijasmestaja56417s() {
		return this.rezervacijasmestaja56417s;
	}

	public void setRezervacijasmestaja56417s(List<Rezervacijasmestaja56417> rezervacijasmestaja56417s) {
		this.rezervacijasmestaja56417s = rezervacijasmestaja56417s;
	}

	public Rezervacijasmestaja56417 addRezervacijasmestaja56417(Rezervacijasmestaja56417 rezervacijasmestaja56417) {
		getRezervacijasmestaja56417s().add(rezervacijasmestaja56417);
		rezervacijasmestaja56417.setPlaninarskidom56417(this);

		return rezervacijasmestaja56417;
	}

	public Rezervacijasmestaja56417 removeRezervacijasmestaja56417(Rezervacijasmestaja56417 rezervacijasmestaja56417) {
		getRezervacijasmestaja56417s().remove(rezervacijasmestaja56417);
		rezervacijasmestaja56417.setPlaninarskidom56417(null);

		return rezervacijasmestaja56417;
	}

}