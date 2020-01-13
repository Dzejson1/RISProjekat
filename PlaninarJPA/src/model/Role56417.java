package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the role_564_17 database table.
 * 
 */
@Entity
@Table(name="role_564_17")
@NamedQuery(name="Role56417.findAll", query="SELECT r FROM Role56417 r")
public class Role56417 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRole_564_17;

	private String name;

	//bi-directional many-to-many association to Korisnik56417
	@ManyToMany
	@JoinTable(
		name="korisnik_has_role_564_17"
		, joinColumns={
			@JoinColumn(name="role_564_17_idRole_564_17")
			}
		, inverseJoinColumns={
			@JoinColumn(name="korisnik_564_17_idKorisnik")
			}
		)
	private List<Korisnik56417> korisnik56417s=new ArrayList<>();

	public Role56417() {
	}

	public int getIdRole_564_17() {
		return this.idRole_564_17;
	}

	public void setIdRole_564_17(int idRole_564_17) {
		this.idRole_564_17 = idRole_564_17;
	}  

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Korisnik56417> getKorisnik56417s() {
		return this.korisnik56417s;
	}

	public void setKorisnik56417s(List<Korisnik56417> korisnik56417s) {
		this.korisnik56417s = korisnik56417s;
	}

	public void addUser(Korisnik56417 u) {
		korisnik56417s.add(u);
		
	}

}