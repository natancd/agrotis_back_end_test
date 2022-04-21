package backEndTest.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.ManyToOne;

import backEndTest.modelo.Laboratorio;
import backEndTest.modelo.Propriedades;
import backEndTest.modelo.Registro;

public class RegistroDto {
	private Long id;
	private String nome;
	private String observacoes;
	private LocalDateTime dataInicial;
	private LocalDateTime dataFinal;
	private Propriedades propriedade;
	private Laboratorio laboratorio;
	
	public RegistroDto(Registro registro) {
		super();
		this.id = registro.getId();
		this.nome = registro.getNome();
		this.observacoes = registro.getObservacoes();
		this.dataInicial = registro.getDataInicial();
		this.dataFinal = registro.getDataFinal();
		this.propriedade = registro.getPropriedade();
		this.laboratorio = registro.getLaboratorio();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public LocalDateTime getDataInicial() {
		return dataInicial;
	}

	public LocalDateTime getDataFinal() {
		return dataFinal;
	}

	public Propriedades getPropriedade() {
		return propriedade;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public static List<RegistroDto> converter(List<Registro> registros) {
		return registros.stream().map(RegistroDto::new).collect(Collectors.toList());
	}
	
}
