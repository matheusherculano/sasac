package br.com.sasac.controller;

import br.com.sasac.model.Avaliacao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Matheus Herculano
 */
@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController extends CustomController<Avaliacao, CrudRepository<Avaliacao, Long>>{
    
}
