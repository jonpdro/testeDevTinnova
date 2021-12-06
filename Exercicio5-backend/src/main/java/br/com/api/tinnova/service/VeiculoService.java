package br.com.api.tinnova.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import br.com.api.tinnova.model.Veiculo;
import br.com.api.tinnova.repository.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository repository;

	
	public List<String> apenasDisponiveis() {
		return repository.apenasDisponiveis();
	}

	public List<String> apenasMarca() {
		return repository.apenasMarca();
	}
	
	public ResponseEntity<List<Veiculo>> getStatus() {
		return ResponseEntity.ok(repository.getStatus());
	}

	public ResponseEntity<List<Veiculo>> findAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	public ResponseEntity<Veiculo> findById(long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<Veiculo> createEntity(Veiculo Veiculo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(Veiculo));
	}

	public ResponseEntity<Veiculo> updateEntity(Veiculo Veiculo, long id) {
		Optional<Veiculo> pegarId = repository.findById(id);

		if (pegarId.isPresent()) {
			Veiculo updateVeiculo = pegarId.get();

			updateVeiculo.setAno(Veiculo.getAno());
			updateVeiculo.setCreated(Veiculo.getCreated());
			updateVeiculo.setDescricao(Veiculo.getDescricao());
			updateVeiculo.setId(Veiculo.getId());
			updateVeiculo.setMarca(Veiculo.getMarca());
			updateVeiculo.setUpdated(Veiculo.getUpdated());
			updateVeiculo.setVeiculo(Veiculo.getVeiculo());
			updateVeiculo.setVendido(Veiculo.isVendido());

			return ResponseEntity.ok(repository.save(updateVeiculo));
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Veiculo não encontrado.", null);
		}
	}

	public ResponseEntity<Veiculo> updateOnlyAttribute(@RequestBody Map<String, Object> fields, @PathVariable long id) {
		Optional<Veiculo> pegarId = repository.findById(id);

		Veiculo Veiculo = pegarId.get();
		fields.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(Veiculo.class, key);
			field.setAccessible(true);
			ReflectionUtils.setField(field, Veiculo, value);
		});

		return ResponseEntity.ok(repository.save(Veiculo));
	}

	public void deleteAtrribute(long id) {
		repository.deleteById(id);
	}

}
