package br.com.sasac.controllers;

import br.com.sasac.models.Teste;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Matheus
 */
@Controller
@RequestMapping("/teste")
@Transactional
public class TesteController extends CustomController<Teste, CrudRepository<Teste, Long>>{
    
}
