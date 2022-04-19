package br.com.leroy.prestador.repository;

import br.com.leroy.prestador.model.OrdemDeServico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrdemRepository extends JpaRepository<OrdemDeServico,UUID> {

}
