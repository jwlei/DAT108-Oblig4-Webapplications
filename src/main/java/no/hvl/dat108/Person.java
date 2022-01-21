package no.hvl.dat108;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig4", name = "person")
public class Person {

	@Id
	private String mobil;
	private String fornavn;
	private String etternavn;
	private String passordhash;
	private String passordsalt;
	private String kjonn;
	
	public Person() {
	}
	
	public Person(String mobil, String fornavn, String etternavn, String passordhash, String passordsalt, String kjonn) {
		this.mobil = mobil;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.passordhash = passordhash;
		this.passordsalt = passordsalt;
		this.kjonn = kjonn;
	}

	/* 
	 * Get/Set 
	 */
	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getPassordhash() {
		return passordhash;
	}

	public void setPassordhash(String passord) {
		this.passordhash = passord;
	}

	public String getPassordsalt() {
		return passordsalt;
	}

	public void setPassordsalt(String passordsalt) {
		this.passordsalt = passordsalt;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}

	@Override
	public String toString() {
		return "Person [mobil=" + mobil + ", fornavn=" + fornavn + ", etternavn=" + etternavn + ", passordhash="
				+ passordhash + ", passordsalt=" + passordsalt + ", kjonn=" + kjonn + "]";
	}

	
}
