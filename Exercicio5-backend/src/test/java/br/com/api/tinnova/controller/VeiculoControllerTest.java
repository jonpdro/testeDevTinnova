package br.com.api.tinnova.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.api.tinnova.model.Veiculo;
import br.com.api.tinnova.repository.VeiculoRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VeiculoControllerTest {

	// Injeção de dependencia
	@Autowired
	private TestRestTemplate testRestTemplate;

	// Instanciamento de objetos
	public Veiculo veiculo;
	public Veiculo veiculoUpdate;

	// Injeção de dependencia
	@Autowired
	private VeiculoRepository repository;

	// Primeiro processo que o test irá fazer
	@BeforeEach
	public void start() throws ParseException {

		// Atribuir dados ao objetos instanciados
		veiculo = new Veiculo(1, "Carro", "BMW", 2021, "", false);
		if (!repository.findById(veiculo.getId()).isPresent()) {
			HttpEntity<Veiculo> request = new HttpEntity<Veiculo>(veiculo);
			testRestTemplate.exchange("/veiculos", HttpMethod.POST, request, Veiculo.class);
		}

		veiculoUpdate = new Veiculo(1, "Moto", "BMW", 2021, "", false);

	}

	
	// TESTES PARA CADASTRAR VEICULO
	@Test
	@Order(1)
	@DisplayName("Cadastrar Veiculo")
	void createVeiculo() {
		HttpEntity<Veiculo> request = new HttpEntity<Veiculo>(veiculo);

		ResponseEntity<Veiculo> resposta = testRestTemplate.exchange("/veiculos", HttpMethod.POST, request,
				Veiculo.class);

		assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
	}

	// TESTES PARA LISTAR VEICULO
	@Test
	@Order(2)
	@DisplayName("Listar Veiculos")
	public void getAll() {
		ResponseEntity<String> resposta = testRestTemplate.exchange("/veiculos", HttpMethod.GET, null, String.class);

		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}

	// TESTES PARA ALTERAR VEICULO
	@Test
	@Order(3)
	@DisplayName("Alterar Veiculos")
	public void putVeiculo() {
		HttpEntity<Veiculo> request = new HttpEntity<Veiculo>(veiculoUpdate);

		ResponseEntity<Veiculo> resposta = testRestTemplate.exchange("/veiculos/1", HttpMethod.PUT, request,
				Veiculo.class);

		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}

	// TESTES PARA DELETAR VEICULO
	@Test
	@Order(4)
	@DisplayName("Deletar Veiculo")
	public void deleteVeiculo() {
		HttpEntity<Veiculo> request = new HttpEntity<Veiculo>(veiculo);

		ResponseEntity<Veiculo> resposta = testRestTemplate.exchange("/veiculos/2", HttpMethod.DELETE, request,
				Veiculo.class);

		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
}
