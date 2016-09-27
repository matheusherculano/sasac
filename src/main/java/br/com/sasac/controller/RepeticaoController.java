package br.com.sasac.controller;

import br.com.sasac.model.Repeticao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author RA21501871
 */
@RestController
@RequestMapping("/repeticao")
public class RepeticaoController extends CustomController<Repeticao, CrudRepository<Repeticao, Long>>{
    
}
