package br.com.api.tinnova.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.api.tinnova.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	
	// Query para ver achar os atributos disponiveis
	@Query(value = "select * from base_veiculo where vendido = 0", nativeQuery = true)
	public List<String> apenasDisponiveis();
	
	// Query para ver achar a quantidade pela marca
	@Query(value = "select marca, count(*) as quantidade from base_veiculo group by marca", nativeQuery = true)
	public List<String> apenasMarca();
	
	// Query para ver achar os atributos disponiveis
	@Query(value = "select * from base_veiculo where vendido = 0", nativeQuery = true)
	public List<Veiculo> getStatus();
}
