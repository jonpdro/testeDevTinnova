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

	public Veiculo veiculo;
	public Veiculo veiculoNulo = new Veiculo();
	
	@Autowired
	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

	Validator validator = factory.getValidator();

	@BeforeEach
	public void start() {
		veiculo = new Veiculo(0L, "Carro", "Honda", 2021, "", false);
	}
	
	@Test
	@DisplayName("✔ Valida Atributos Não Nulos")
	void testValidaAtributos() {
		Set<ConstraintViolation<Veiculo>> violacao = validator.validate(veiculo);

		System.out.println(violacao.toString());

		assertTrue(violacao.isEmpty());
	}
	
	@Test
	@DisplayName("✖ Não Valida Atributos Nulos")
	void testNaoValidaAtributos() {
		Set<ConstraintViolation<Veiculo>> violacao = validator.validate(veiculoNulo);

		System.out.println(violacao.toString());

		assertTrue(violacao.isEmpty());
	}
}
