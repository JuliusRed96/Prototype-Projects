package it.gianluca.MySpring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TeatriDao implements GenericDao<Teatri> {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	ApplicationContext applicationContext;

	@Override
	public int save(Teatri t) {
		return jdbcTemplate.update(
				"INSERT INTO teatri (nome, indirizzo, citta, provincia, telefono, posti) VALUES(?, ?, ?, ?, ?, ?)",
				t.getNome(), t.getIndirizzo(), t.getCitta(), t.getProvincia(), t.getTelefono(), t.getPosti());
	}

	@Override
	public Teatri update(int id, Teatri teatri) {
		jdbcTemplate.update("Update teatri SET nome='" + teatri.getNome() + "', indirizzo='" + teatri.getIndirizzo()
				+ "', citta='" + teatri.getCitta() + "', provincia='" + teatri.getProvincia() + "', telefono='"
				+ teatri.getTelefono() + "', posti='" + teatri.getPosti() + "' WHERE id_teatro = " + id + " ");
		return teatri;
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("DELETE FROM teatri WHERE id_teatro=" + id);
	}

	@Override
	public Teatri findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Teatri> findAll() {
		List<Teatri> teatri = new ArrayList<Teatri>();
		jdbcTemplate.queryForList("SELECT * FROM teatri").forEach(teatriRow -> {
			int id = 0;
			Object idObj = teatriRow.get("id_teatro");
			if (idObj != null) {
				id = ((Integer) idObj).intValue();
			}
			int posti = 0;
			idObj = teatriRow.get("posti");
			if (idObj != null) {
				posti = ((Integer) idObj).intValue();
			}
			teatri.add(new Teatri(id, (String) teatriRow.get("nome"), (String) teatriRow.get("indirizzo"),
					(String) teatriRow.get("citta"), (String) teatriRow.get("provincia"),
					(String) teatriRow.get("telefono"), posti));
		});
		return teatri;
	}
}
