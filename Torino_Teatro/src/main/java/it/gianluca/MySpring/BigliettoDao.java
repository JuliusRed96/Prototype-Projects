package it.gianluca.MySpring;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class BigliettoDao implements GenericDao<Biglietto> {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	ApplicationContext applicationContext;

	@Override
	public List<Biglietto> findAll() {
		List<Biglietto> biglietto = new ArrayList<Biglietto>();
		jdbcTemplate.queryForList("SELECT * FROM biglietti").forEach(bigliettoRow -> {
			int id = 0;
			Object idObj = bigliettoRow.get("id_operazione");
			if (idObj != null) {
				id = ((Integer) idObj).intValue();
			}
			int idCliente = 0;
			idObj = bigliettoRow.get("id_cliente");
			if (idObj != null) {
				idCliente = ((Integer) idObj).intValue();
			}
			int idReplica = 0;
			idObj = bigliettoRow.get("id_replica");
			if (idObj != null) {
				idReplica = ((Integer) idObj).intValue();
			}
			int quantita = 0;
			idObj = bigliettoRow.get("quantita");
			if (idObj != null) {
				quantita = ((Integer) idObj).intValue();
			}
			biglietto.add(new Biglietto(id, idCliente, idReplica, (LocalDateTime) bigliettoRow.get("data_ora"),
					(String) bigliettoRow.get("tipo_pagamento"), quantita));
		});
		return biglietto;
	}

	@Override
	public int save(Biglietto t) {
		return jdbcTemplate.update("INSERT INTO biglietti (quantita, tipo_pagamento) VALUES(?, ?)", t.getQuantita(),
				t.getTipo_pagamento());
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("DELETE FROM biglietti WHERE id_operazione=" + id);
	}

	@Override
	public Biglietto findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Biglietto update(int id, Biglietto t) {
		// TODO Auto-generated method stub
		return null;
	}
}
