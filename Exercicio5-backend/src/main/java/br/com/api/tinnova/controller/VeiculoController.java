package br.com.api.tinnova.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.tinnova.model.Veiculo;
import br.com.api.tinnova.service.VeiculoService;

@RestController
@RequestMapping("/veiculos")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class VeiculoController {
	
	// Injeção de dependencia
	@Autowired
	private VeiculoService service;

	// Requisição HTTP GET
	@GetMapping()
	public ResponseEntity<List<Veiculo>> getAll() {
		return service.findAll();
	}

	// Requisição HTTP GET
	@GetMapping("/find")
	public List<String> getParam(@RequestParam("q") String text) {
		switch (text) {
		case "vendido":
			return service.apenasDisponiveis();
		
		case "marca":
			return service.apenasMarca();

		default:
			break;
		}
		return null;
	}

	// Requisição HTTP GET
	@GetMapping("/{id}")
	public ResponseEntity<Veiculo> getById(@PathVariable long id) {
		return service.findById(id);
	}

	// Requisição HTTP POST
	@PostMapping()
	public ResponseEntity<Veiculo> post(@RequestBody Veiculo Veiculo) {
		return service.createEntity(Veiculo);
	}

	// Requisição HTTP PUT
	@PutMapping("/{id}")
	public ResponseEntity<Veiculo> put(@RequestBody Veiculo Veiculo, @PathVariable long id) {
		return service.updateEntity(Veiculo, id);
	}

	// Requisição HTTP PATCH
	@PatchMapping("/{id}")
	public ResponseEntity<Veiculo> patch(@RequestBody Map<String, Object> fields, @PathVariable Long id) {
		return service.updateOnlyAttribute(fields, id);
	}

	// Requisição HTTP DELETE
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		service.deleteAtrribute(id);
	}
	
	// Requisição HTTP GET
	@GetMapping("/status")
	public ResponseEntity<List<Veiculo>> getStatus() {
		return service.getStatus();
	}
}
