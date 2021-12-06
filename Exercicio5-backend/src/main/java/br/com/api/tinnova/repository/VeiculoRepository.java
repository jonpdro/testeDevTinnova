package br.com.api.tinnova.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.api.tinnova.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	
	@Query(value = "select * from base_veiculo where vendido = 0", nativeQuery = true)
	public List<String> apenasDisponiveis();
	
	@Query(value = "select marca, count(*) as quantidade from base_veiculo group by marca", nativeQuery = true)
	public List<String> apenasMarca();
	
	@Query(value = "select * from base_veiculo where vendido = 0", nativeQuery = true)
	public List<Veiculo> getStatus();
}
