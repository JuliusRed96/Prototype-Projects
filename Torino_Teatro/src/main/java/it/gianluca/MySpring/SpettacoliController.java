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
@RequestMapping("spettacoli")
public class SpettacoliController {

	@Autowired
	SpettacoliDao spettacoliDao;

	@Autowired
	private ApplicationContext myContext;

	@PostMapping("save")
	public int save(@RequestBody Spettacoli spettacoli) {
		return spettacoliDao.save(spettacoli);
	}

	@PutMapping("/update/{id}")
	public Spettacoli update(@PathVariable int id, @RequestBody Spettacoli spettacoli) {
		Spettacoli spettacoliUpdate = new Spettacoli(id, spettacoli.getTitolo(), spettacoli.getAutore(),
				spettacoli.getRegista(), spettacoli.getPrezzo(), id);
		return spettacoliDao.update(id, new Spettacoli(id, spettacoli.getTitolo(), spettacoli.getAutore(),
				spettacoli.getRegista(), spettacoli.getPrezzo(), id));
	}

	@DeleteMapping("/delete")
	public int delete(@RequestParam int id) {
		return spettacoliDao.delete(id);
	}

	@GetMapping("/findall")
	public List<Spettacoli> findall() {
		return spettacoliDao.findAll();
	}

}
