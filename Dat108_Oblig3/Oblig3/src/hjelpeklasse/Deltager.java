 package hjelpeklasse;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="oblig3_dat108", name="deltager")
public class Deltager {
	
	
	@Id
	private String mobilnr;
	private String fornavn;
	private String etternavn;
	private String hashpassord;
	private String saltpassord;
	
	
	public String getSaltpassord() {
		return saltpassord;
	}

	public void setSaltpassord(String saltpassord) {
		this.saltpassord = saltpassord;
	}

	private String kjonn;
	
	public Deltager() {
		
	}
	
	@Override
	public String toString() {
		return "Deltager [mobilnr=" + mobilnr + ", fornavn=" + fornavn + ", etternavn=" + etternavn + ", kjonn=" + kjonn
				+ "]";
	}

	public Deltager(String fornavn, String etternavn, String mobilnr, String hashpassord, String saltpassord, String kjonn) {
		super();
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.mobilnr = mobilnr;
		this.hashpassord = hashpassord;
		this.saltpassord = saltpassord;
		this.kjonn = kjonn;
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

	public String getMobilnr() {
		return mobilnr;
	}

	public void setMobilnr(String mobilnr) {
		this.mobilnr = mobilnr;
	}

	public String getHashpassord() {
		return hashpassord;
	}

	public void setHashpassord(String hashpassord) {
		this.hashpassord = hashpassord;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}

	
	
}
