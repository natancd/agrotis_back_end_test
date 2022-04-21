package backEndTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backEndTest.modelo.Laboratorio;

public interface LaboratorioRepository extends JpaRepository<Laboratorio, Long>{
	Laboratorio findByNome(String nome);

}
