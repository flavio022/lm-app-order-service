package br.com.leroy.prestador.controller;

import java.util.List;

import br.com.leroy.prestador.model.OrdemDeServico;
import br.com.leroy.prestador.service.OrdemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ordemDeServico")
 public class OrdemController {

	private static Logger LOG = LoggerFactory.getLogger(OrdemController.class);

	@Autowired
	private OrdemService ordemService;
	
	@RequestMapping(method = RequestMethod.POST)
	public OrdemDeServico realizaPedido(@RequestBody OrdemDeServico ordem) {
		LOG.info("criando ordem ordem de servioço");
		return ordemService.criaOrdem(ordem);
	}


	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public List<OrdemDeServico> getPedidoPorId() {

		return ordemService.listAll();
	}
}
