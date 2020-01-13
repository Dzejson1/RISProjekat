package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipznamenitosti_564_17 database table.
 * 
 */
@Entity
@Table(name="tipznamenitosti_564_17")
@NamedQuery(name="Tipznamenitosti56417.findAll", query="SELECT t FROM Tipznamenitosti56417 t")
public class Tipznamenitosti56417 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTipZnamenitosti;

	private String opis;

	//bi-directional many-to-one association to Znamenitost56417
	@OneToMany(mappedBy="tipznamenitosti56417")
	private List<Znamenitost56417> znamenitost56417s;

	public Tipznamenitosti56417() {
	}

	public int getIdTipZnamenitosti() {
		return this.idTipZnamenitosti;
	}

	public void setIdTipZnamenitosti(int idTipZnamenitosti) {
		this.idTipZnamenitosti = idTipZnamenitosti;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public List<Znamenitost56417> getZnamenitost56417s() {
		return this.znamenitost56417s;
	}

	public void setZnamenitost56417s(List<Znamenitost56417> znamenitost56417s) {
		this.znamenitost56417s = znamenitost56417s;
	}

	public Znamenitost56417 addZnamenitost56417(Znamenitost56417 znamenitost56417) {
		getZnamenitost56417s().add(znamenitost56417);
		znamenitost56417.setTipznamenitosti56417(this);

		return znamenitost56417;
	}

	public Znamenitost56417 removeZnamenitost56417(Znamenitost56417 znamenitost56417) {
		getZnamenitost56417s().remove(znamenitost56417);
		znamenitost56417.setTipznamenitosti56417(null);

		return znamenitost56417;
	}

}