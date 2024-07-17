package it.gianluca.MySpring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("biglietto")
public class BigliettoController {

	@Autowired
	BigliettoDao bigliettoDao;

	@Autowired
	private ApplicationContext myContext;

	@PostMapping("save")
	public int save(@RequestBody Biglietto biglietto) {
		return bigliettoDao.save(biglietto);
	}

	@GetMapping("/findall")
	public List<Biglietto> findall() {
		return bigliettoDao.findAll();
	}

	@DeleteMapping("/delete")
	public int delete(@RequestParam int id) {
		return bigliettoDao.delete(id);
	}
}
