package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the planina_564_17 database table.
 * 
 */
@Entity
@Table(name="planina_564_17")
@NamedQuery(name="Planina56417.findAll", query="SELECT p FROM Planina56417 p")
public class Planina56417 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPlanina;

	private String naziv;

	//bi-directional many-to-one association to Izvestaj56417
	@OneToMany(mappedBy="planina56417")
	private List<Izvestaj56417> izvestaj56417s;

	//bi-directional many-to-one association to Planinarskidom56417
	@OneToMany(mappedBy="planina56417")
	private List<Planinarskidom56417> planinarskidom56417s;

	//bi-directional many-to-one association to Slika56417
	@OneToMany(mappedBy="planina56417")
	private List<Slika56417> slika56417s;

	//bi-directional many-to-one association to Staza56417
	@OneToMany(mappedBy="planina56417")
	private List<Staza56417> staza56417s;

	public Planina56417() {
	}

	public int getIdPlanina() {
		return this.idPlanina;
	}

	public void setIdPlanina(int idPlanina) {
		this.idPlanina = idPlanina;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Izvestaj56417> getIzvestaj56417s() {
		return this.izvestaj56417s;
	}

	public void setIzvestaj56417s(List<Izvestaj56417> izvestaj56417s) {
		this.izvestaj56417s = izvestaj56417s;
	}

	public Izvestaj56417 addIzvestaj56417(Izvestaj56417 izvestaj56417) {
		getIzvestaj56417s().add(izvestaj56417);
		izvestaj56417.setPlanina56417(this);

		return izvestaj56417;
	}

	public Izvestaj56417 removeIzvestaj56417(Izvestaj56417 izvestaj56417) {
		getIzvestaj56417s().remove(izvestaj56417);
		izvestaj56417.setPlanina56417(null);

		return izvestaj56417;
	}

	public List<Planinarskidom56417> getPlaninarskidom56417s() {
		return this.planinarskidom56417s;
	}

	public void setPlaninarskidom56417s(List<Planinarskidom56417> planinarskidom56417s) {
		this.planinarskidom56417s = planinarskidom56417s;
	}

	public Planinarskidom56417 addPlaninarskidom56417(Planinarskidom56417 planinarskidom56417) {
		getPlaninarskidom56417s().add(planinarskidom56417);
		planinarskidom56417.setPlanina56417(this);

		return planinarskidom56417;
	}

	public Planinarskidom56417 removePlaninarskidom56417(Planinarskidom56417 planinarskidom56417) {
		getPlaninarskidom56417s().remove(planinarskidom56417);
		planinarskidom56417.setPlanina56417(null);

		return planinarskidom56417;
	}

	public List<Slika56417> getSlika56417s() {
		return this.slika56417s;
	}

	public void setSlika56417s(List<Slika56417> slika56417s) {
		this.slika56417s = slika56417s;
	}

	public Slika56417 addSlika56417(Slika56417 slika56417) {
		getSlika56417s().add(slika56417);
		slika56417.setPlanina56417(this);

		return slika56417;
	}

	public Slika56417 removeSlika56417(Slika56417 slika56417) {
		getSlika56417s().remove(slika56417);
		slika56417.setPlanina56417(null);

		return slika56417;
	}

	public List<Staza56417> getStaza56417s() {
		return this.staza56417s;
	}

	public void setStaza56417s(List<Staza56417> staza56417s) {
		this.staza56417s = staza56417s;
	}

	public Staza56417 addStaza56417(Staza56417 staza56417) {
		getStaza56417s().add(staza56417);
		staza56417.setPlanina56417(this);

		return staza56417;
	}

	public Staza56417 removeStaza56417(Staza56417 staza56417) {
		getStaza56417s().remove(staza56417);
		staza56417.setPlanina56417(null);

		return staza56417;
	}

}