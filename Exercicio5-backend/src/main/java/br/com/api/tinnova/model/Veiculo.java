package br.com.api.tinnova.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

// Declaração que é uma entidade no banco de dados
@Entity
@Table(name = "base_veiculo")
public class Veiculo {

	// Váriaveis que serão convertidas em atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	private String veiculo;

	@NotNull
	private String marca;

	@NotNull
	private int ano;

	private String descricao;

	private boolean vendido;

	@CreatedDate
	private Date created;

	@LastModifiedDate
	private Date updated;
	
	// Construtor vazio
	public Veiculo() {
		super();
	}

	// Construtor
	public Veiculo(long id, @NotNull String veiculo, @NotNull String marca, @NotNull int ano, String descricao,
			boolean vendido) {
		super();
		this.id = id;
		this.veiculo = veiculo;
		this.marca = marca;
		this.ano = ano;
		this.descricao = descricao;
		this.vendido = vendido;
	}

	// Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isVendido() {
		return vendido;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

}
