package it.gianluca.MySpring;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SpettacoliDao implements GenericDao<Spettacoli> {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	ApplicationContext applicationContext;

	@Override
	public int save(Spettacoli t) {
		return jdbcTemplate.update("INSERT INTO spettacoli (titolo, autore, regista, prezzo) VALUES(?, ?, ?, ?)",
				t.getTitolo(), t.getAutore(), t.getRegista(), t.getPrezzo());
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("DELETE FROM spettacoli WHERE id_spettacolo=" + id);
	}

	@Override
	public Spettacoli findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Spettacoli> findAll() {
		List<Spettacoli> spettacoli = new ArrayList<Spettacoli>();
		jdbcTemplate.queryForList("SELECT * FROM spettacoli").forEach(spettacoliRow -> {
			int id = 0;
			Object idObj = spettacoliRow.get("id_spettacolo");
			if (idObj != null) {
				id = ((Integer) idObj).intValue();
			}
			int idTeatro = 0;
			idObj = spettacoliRow.get("id_teatro");
			if (idObj != null) {
				idTeatro = ((Integer) idObj).intValue();
			}
			spettacoli.add(new Spettacoli(id, (String) spettacoliRow.get("titolo"),
					(String) spettacoliRow.get("autore"), (String) spettacoliRow.get("regista"),
					((BigDecimal) spettacoliRow.get("prezzo")).floatValue(), idTeatro));
		});
		return spettacoli;
	}

	@Override
	public Spettacoli update(int id, Spettacoli spettacoli) {
		jdbcTemplate.update("Update spettacoli SET titolo='" + spettacoli.getTitolo() + "', autore='"
				+ spettacoli.getAutore() + "', regista='" + spettacoli.getRegista() + "', prezzo='"
				+ spettacoli.getPrezzo() + "' WHERE id_spettacolo = " + id + " ");
		return spettacoli;
	}

	/*
	 * @Override public List<Spettacoli> findAll() { // TODO Auto-generated method
	 * stub return null; }
	 */
}
