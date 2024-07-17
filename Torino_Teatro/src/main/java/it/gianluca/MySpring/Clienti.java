package it.gianluca.MySpring;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Clienti {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_cliente;
	private String cognome;
	private String nome;
	private String telefono;
	private String email;
	private String login;
	private String password;

	public Clienti(int id_cliente, String cognome, String nome, String telefono, String email, String login,
			String password) {
		super();
		this.id_cliente = id_cliente;
		this.cognome = cognome;
		this.nome = nome;
		this.telefono = telefono;
		this.email = email;
		this.login = login;
		this.password = password;
	}

	public int getId_Cliente() {
		return id_cliente;
	}

	public void setCodCliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
