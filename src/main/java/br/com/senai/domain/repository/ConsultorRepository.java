package br.com.senai.domain.repository;

import br.com.senai.domain.model.Consultor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultorRepository extends JpaRepository<Consultor, Long> {

}
