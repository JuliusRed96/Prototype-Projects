package it.gianluca.MySpring;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ReplicheDao implements GenericDao<Repliche> {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	ApplicationContext applicationContext;

	@Override
	public List<Repliche> findAll() {
		List<Repliche> repliche = new ArrayList<Repliche>();
		jdbcTemplate.queryForList("SELECT * FROM repliche")
				.forEach(replicheRow -> repliche.add(new Repliche((int) replicheRow.get("id_replica"),
						(int) replicheRow.get("nome"), (Date) replicheRow.get("data_replica"))));
		return repliche;
	}

	/*
	 * @Override public int save(Repliche t) { return
	 * jdbcTemplate.update("INSERT INTO repliche (data_replica) VALUES(?)",
	 * t.getData_replica()); }
	 * 
	 * @Override public Repliche update(int id, Repliche repliche) { jdbcTemplate
	 * .update("Update repliche SET nome='" + repliche.getData_replica() +
	 * "' WHERE id_cliente = " + id + " "); return repliche; }
	 */

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("DELETE FROM repliche WHERE id_repliche=" + id);
	}

	@Override
	public Repliche findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Repliche t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Repliche update(int id, Repliche t) {
		// TODO Auto-generated method stub
		return null;
	}

}
