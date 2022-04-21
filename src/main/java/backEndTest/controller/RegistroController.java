package backEndTest.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import backEndTest.controller.dto.RegistroDto;
import backEndTest.controller.form.AtualizacaoRegistroForm;
import backEndTest.modelo.Registro;
import backEndTest.repository.LaboratorioRepository;
import backEndTest.repository.PropriedadeRepository;
import backEndTest.repository.RegistroRepository;

@RestController
@RequestMapping("/registros")
public class RegistroController {
	
	@Autowired
	private RegistroRepository registroRepository;
	
	@Autowired
	private PropriedadeRepository propriedadeRepository;
	
	@Autowired
	private LaboratorioRepository laboratorioRepository;
	
	@GetMapping
	public List<RegistroDto> lista(String nomeRegistro, String nomePropriedade, String nomeLaboratorio) {
		if (nomeRegistro == null) {
			List<Registro> registros = registroRepository.findAll();
			return RegistroDto.converter(registros);
		} else if (nomePropriedade == null){
			List<Registro> registros = registroRepository.findByPropriedadeNome(nomePropriedade);
			return RegistroDto.converter(registros);
		} else {
			List<Registro> registros = registroRepository.findByLaboratorioNome(nomeLaboratorio);
			return RegistroDto.converter(registros);
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<RegistroDto> cadastrar(@RequestBody @Valid Registro registro, UriComponentsBuilder uriBuilder) {
		registroRepository.save(registro);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(registro.getId()).toUri();
		return ResponseEntity.created(uri).body(new RegistroDto(registro));
	}

	@GetMapping("/{id}")
	public ResponseEntity<RegistroDto> detalhar(@PathVariable Long id) {
		Optional<Registro> registro = registroRepository.findById(id);
		if (registro.isPresent()) {
			return ResponseEntity.ok(new RegistroDto(registro.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<RegistroDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoRegistroForm form){
		Optional<Registro> optional = registroRepository.findById(id);
		if (optional.isPresent()) {
			Registro registro = form.atualizar(id, registroRepository);
			return ResponseEntity.ok(new RegistroDto(registro));
		}
		return ResponseEntity.notFound().build();		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Registro> optional = registroRepository.findById(id);
		if (optional.isPresent()) {
			registroRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
