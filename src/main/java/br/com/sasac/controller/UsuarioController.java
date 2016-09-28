package br.com.sasac.controller;

import br.com.sasac.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Matheus Herculano
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController extends CustomController<Usuario, CrudRepository<Usuario, Long>> {

}
