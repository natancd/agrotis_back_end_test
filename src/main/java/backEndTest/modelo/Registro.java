package backEndTest.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Registro {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull @NotEmpty @Length(min = 3)
	private String nome;
	@Length(max = 1000)
	private String observacoes;
	@NotNull 
	private LocalDateTime dataInicial;
	@NotNull 
	private LocalDateTime dataFinal;
	@ManyToOne
	@NotNull 
	private Propriedades propriedade;
	@ManyToOne
	@NotNull 
	private Laboratorio laboratorio;
	
	public Registro() {
	}

	public Registro(Long id, String nome, String observacoes, LocalDateTime dataInicial, LocalDateTime dataFinal,
			Propriedades propriedade, Laboratorio laboratorio) {
		super();
		this.id = id;
		this.nome = nome;
		this.observacoes = observacoes;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.propriedade = propriedade;
		this.laboratorio = laboratorio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public LocalDateTime getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDateTime dataInicial) {
		this.dataInicial = dataInicial;
	}

	public LocalDateTime getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDateTime dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Propriedades getPropriedade() {
		return propriedade;
	}

	public void setPropriedade(Propriedades propriedade) {
		this.propriedade = propriedade;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Registro other = (Registro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
