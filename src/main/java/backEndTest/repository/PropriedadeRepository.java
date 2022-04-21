package backEndTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backEndTest.modelo.Propriedades;

public interface PropriedadeRepository extends JpaRepository<Propriedades, Long>{
	Propriedades findByNome(String nome);

}
