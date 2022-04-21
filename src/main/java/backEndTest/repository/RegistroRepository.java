package backEndTest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import backEndTest.modelo.Registro;

public interface RegistroRepository extends JpaRepository<Registro, Long> {

	List<Registro> findByPropriedadeNome(String nomePropriedade);
	List<Registro> findByLaboratorioNome(String nomeLaboratorio);

}
