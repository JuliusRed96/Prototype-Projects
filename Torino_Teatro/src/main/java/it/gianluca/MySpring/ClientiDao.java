package it.gianluca.MySpring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ClientiDao implements GenericDao<Clienti> {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	ApplicationContext applicationContext;

	@Override
	public int save(Clienti t) {
		return jdbcTemplate.update(
				"INSERT INTO clienti (nome, cognome, telefono, email, login, password) VALUES(?, ?, ?, ?, ?, ?)",
				t.getNome(), t.getCognome(), t.getTelefono(), t.getEmail(), t.getLogin(), t.getPassword());
	}

	@Override
	public Clienti update(int id, Clienti clienti) {
		jdbcTemplate.update("Update clienti SET nome='" + clienti.getNome() + "', cognome='" + clienti.getCognome()
				+ "', telefono='" + clienti.getTelefono() + "', email='" + clienti.getEmail() + "', login='"
				+ clienti.getLogin() + "', password='" + clienti.getPassword() + "' WHERE id_cliente = " + id + " ");
		return clienti;
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("DELETE FROM clienti WHERE id_cliente=" + id);
	}

	@Override
	public Clienti findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Clienti> findAll() {
		List<Clienti> clienti = new ArrayList<Clienti>();
		jdbcTemplate.queryForList("SELECT * FROM clienti")
				.forEach(clienteRow -> clienti.add(new Clienti((int) clienteRow.get("id_cliente"),
						(String) clienteRow.get("nome"), (String) clienteRow.get("cognome"),
						(String) clienteRow.get("telefono"), (String) clienteRow.get("email"),
						(String) clienteRow.get("login"), (String) clienteRow.get("password"))));
		return clienti;
	}
}
