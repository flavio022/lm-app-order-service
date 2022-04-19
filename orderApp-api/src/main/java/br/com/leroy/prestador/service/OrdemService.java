package br.com.leroy.prestador.service;


import br.com.leroy.prestador.model.OrdemDeServico;
import br.com.leroy.prestador.repository.OrdemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrdemService {

	private OrdemRepository ordemRepository;

	public OrdemService(OrdemRepository ordemRepository){
		this.ordemRepository = ordemRepository;
	}
	private static Logger LOG = LoggerFactory.getLogger(OrdemService.class);

	public OrdemDeServico criaOrdem(OrdemDeServico ordemDeServico) {
		return ordemRepository.save(ordemDeServico);
	}


	public List<OrdemDeServico> listAll() {
		return ordemRepository.findAll();
	}
}
