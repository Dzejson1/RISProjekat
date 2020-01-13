package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the slika_564_17 database table.
 * 
 */
@Entity
@Table(name="slika_564_17")
@NamedQuery(name="Slika56417.findAll", query="SELECT s FROM Slika56417 s")
public class Slika56417 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSlika;

	@Lob
	private byte[] pic;

	//bi-directional many-to-one association to Korisnik56417
	@ManyToOne
	@JoinColumn(name="Korisnik_idKorisnik")
	private Korisnik56417 korisnik56417;

	//bi-directional many-to-one association to Planina56417
	@ManyToOne
	@JoinColumn(name="Planina_idPlanina")
	private Planina56417 planina56417;

	public Slika56417() {
	}

	public int getIdSlika() {
		return this.idSlika;
	}

	public void setIdSlika(int idSlika) {
		this.idSlika = idSlika;
	}

	public byte[] getPic() {
		return this.pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
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