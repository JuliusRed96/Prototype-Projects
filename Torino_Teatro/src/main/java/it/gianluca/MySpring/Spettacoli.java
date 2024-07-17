package it.gianluca.MySpring;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Spettacoli {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_spettacolo;
	private String titolo;
	private String autore;
	private String regista;
	private float prezzo;
	private int id_teatro;

	protected Spettacoli(int id_spettacolo, String titolo, String autore, String regista, float prezzo, int id_teatro) {
		super();
		this.id_spettacolo = id_spettacolo;
		this.titolo = titolo;
		this.autore = autore;
		this.regista = regista;
		this.prezzo = prezzo;
		this.id_teatro = id_teatro;
	}

	public int getId_spettacolo() {
		return id_spettacolo;
	}

	public void setId_spettacolo(int id_spettacolo) {
		this.id_spettacolo = id_spettacolo;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getRegista() {
		return regista;
	}

	public void setRegista(String regista) {
		this.regista = regista;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public int getId_teatro() {
		return id_teatro;
	}

	public void setId_teatro(int id_teatro) {
		this.id_teatro = id_teatro;
	}
}
