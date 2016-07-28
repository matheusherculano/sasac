package br.com.sasac.controller;

import br.com.sasac.model.Teste;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Matheus
 */
@RestController
@RequestMapping("/teste")
public class TesteController extends CustomController<Teste, CrudRepository<Teste, Long>>{
    
}
