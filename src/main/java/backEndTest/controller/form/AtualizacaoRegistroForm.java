package backEndTest.controller.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import backEndTest.modelo.Laboratorio;
import backEndTest.modelo.Propriedades;
import backEndTest.modelo.Registro;
import backEndTest.repository.RegistroRepository;

public class AtualizacaoRegistroForm {
	
	@NotNull @NotEmpty @Length(min = 3)
	private String nome;
	@Length(max = 1000)
	private String observacoes;
	@NotNull 
	private LocalDateTime dataInicial;
	@NotNull
	private LocalDateTime dataFinal;
	@NotNull
	private Propriedades propriedade;
	@NotNull 
	private Laboratorio laboratorio;
	
	
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

	public Registro atualizar(Long id, RegistroRepository registroRepository) {
		
		Registro registro = registroRepository.getOne(id);
		
		registro.setNome(this.nome);
		registro.setObservacoes(this.observacoes);
		registro.setDataInicial(this.dataInicial);
		registro.setDataFinal(this.dataFinal);
		registro.setPropriedade(this.propriedade);
		registro.setLaboratorio(this.laboratorio);
		
		return registro;
	}
	
	
}
