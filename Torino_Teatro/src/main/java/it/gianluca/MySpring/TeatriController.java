package it.gianluca.MySpring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("teatri")
public class TeatriController {

	@Autowired
	TeatriDao teatriDao;

	@Autowired
	private ApplicationContext myContext;

	@PostMapping("save")
	public int save(@RequestBody Teatri teatri) {
		return teatriDao.save(teatri);
	}

	@PutMapping("/update/{id}")
	public Teatri update(@PathVariable int id, @RequestBody Teatri teatri) {
		Teatri teatriUpdate = new Teatri(id, teatri.getNome(), teatri.getIndirizzo(), teatri.getCitta(),
				teatri.getProvincia(), teatri.getTelefono(), teatri.getPosti());
		return teatriDao.update(id, new Teatri(id, teatri.getNome(), teatri.getIndirizzo(), teatri.getCitta(),
				teatri.getProvincia(), teatri.getTelefono(), teatri.getPosti()));
	}

	@DeleteMapping("/delete")
	public int delete(@RequestParam int id) {
		return teatriDao.delete(id);
	}

	@GetMapping("/findall")
	public List<Teatri> findall() {
		return teatriDao.findAll();
	}
}
