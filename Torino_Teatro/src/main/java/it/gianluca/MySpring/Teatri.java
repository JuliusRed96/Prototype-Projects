package it.gianluca.MySpring;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Teatri {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_teatro;
	private String nome;
	private String indirizzo;
	private String citta;
	private String provincia;
	private String telefono;
	private int posti;

	protected Teatri(int id_teatro, String nome, String indirizzo, String citta, String provincia, String telefono,
			int posti) {
		super();
		this.id_teatro = id_teatro;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.provincia = provincia;
		this.telefono = telefono;
		this.posti = posti;
	}

	public int getId_teatro() {
		return id_teatro;
	}

	public void setCod_teatro(int id_teatro) {
		this.id_teatro = id_teatro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getPosti() {
		return posti;
	}

	public void setPosti(int posti) {
		this.posti = posti;
	}
}
