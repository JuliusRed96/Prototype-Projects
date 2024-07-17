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
@RequestMapping("clienti")
public class ClientiController {

	@Autowired
	ClientiDao clientiDao;

	@Autowired
	private ApplicationContext myContext;

	@PostMapping("save")
	public int save(@RequestBody Clienti clienti) {
		return clientiDao.save(clienti);
	}

	@PutMapping("/update/{id}")
	public Clienti update(@PathVariable int id, @RequestBody Clienti clienti) {
		Clienti clientiUpdate = new Clienti(id, clienti.getNome(), clienti.getCognome(), clienti.getTelefono(),
				clienti.getEmail(), clienti.getLogin(), clienti.getPassword());
		return clientiDao.update(id, new Clienti(id, clienti.getNome(), clienti.getCognome(), clienti.getTelefono(),
				clienti.getEmail(), clienti.getLogin(), clienti.getPassword()));
	}

	@DeleteMapping("/delete")
	public int delete(@RequestParam int id) {
		return clientiDao.delete(id);
	}

	@GetMapping("/findall")
	public List<Clienti> findall() {
		return clientiDao.findAll();
	}
}
