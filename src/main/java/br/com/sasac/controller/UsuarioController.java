package br.com.sasac.controller;

import br.com.sasac.model.Avaliacao;
import br.com.sasac.model.UsuarioSasac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.sasac.repository.UsuarioRepository;
import br.com.sasac.service.UsuarioService;
import java.util.List;

/**
 * @author Matheus Herculano
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController extends CustomController<UsuarioSasac, CrudRepository<UsuarioSasac, Long>> {

}
