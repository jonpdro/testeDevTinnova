package br.com.api.tinnova.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class VeiculoTest {

	// Instanciamento de objetos
	public Veiculo veiculo;
	public Veiculo veiculoNulo = new Veiculo();
	
	// Injeção de dependencia e instanciamento
	@Autowired
	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

	// Instanciamento
	Validator validator = factory.getValidator();

	// Primeiro processo que o test irá fazer
	@BeforeEach
	public void start() {
		
		// Atribuir dados ao objeto instanciados
		veiculo = new Veiculo(0L, "Carro", "Honda", 2021, "", false);
	}
	
	// TESTE AVALIANDO SE O OBJETO NÃO É NULO
	@Test
	@DisplayName("✔ Valida Atributos Não Nulos")
	void testValidaAtributos() {
		Set<ConstraintViolation<Veiculo>> violacao = validator.validate(veiculo);

		System.out.println(violacao.toString());

		assertTrue(violacao.isEmpty());
	}
	
	// TESTE AVALIANDO SE O OBJETO É NULO
	@Test
	@DisplayName("✖ Não Valida Atributos Nulos")
	void testNaoValidaAtributos() {
		Set<ConstraintViolation<Veiculo>> violacao = validator.validate(veiculoNulo);

		System.out.println(violacao.toString());

		assertTrue(violacao.isEmpty());
	}
}
