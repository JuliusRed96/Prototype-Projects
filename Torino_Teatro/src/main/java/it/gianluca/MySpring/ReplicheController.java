package it.gianluca.MySpring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("repliche")
public class ReplicheController {

	@Autowired
	ReplicheDao replicheDao;

	@Autowired
	private ApplicationContext myContext;

	/*
	 * @PostMapping("save") public int save(@RequestBody Repliche repliche) { return
	 * replicheDao.save(repliche); }
	 */

	@GetMapping("/findall")
	public List<Repliche> findall() {
		return replicheDao.findAll();
	}

	@DeleteMapping("/delete")
	public int delete(@RequestParam int id) {
		return replicheDao.delete(id);
	}

	/*
	 * @PutMapping("/update/{id}") public Repliche update(@PathVariable int
	 * id, @RequestBody Repliche repliche) { Repliche replicheUpdate = new
	 * Repliche(id, id, repliche.getData_replica()); return replicheDao.update(id,
	 * new Repliche(id, id, repliche.getData_replica())); }
	 */
}
