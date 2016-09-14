package br.com.sasac.controller;

import br.com.sasac.model.Teste;
import br.com.sasac.model.UsuarioSasac;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Matheus Herculano
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController extends CustomController<UsuarioSasac, CrudRepository<UsuarioSasac, Long>>{
    
}
