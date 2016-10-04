package br.com.sasac.controller;

import br.com.sasac.DTO.AvaliacaoDTO;
import br.com.sasac.DTO.UsuarioDTO;
import br.com.sasac.model.Usuario;
import br.com.sasac.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Matheus Herculano
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController extends CustomController<Usuario, CrudRepository<Usuario, Long>> {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "{idUsuario}/periodo", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable Long idUsuario) {
        UsuarioDTO dto = usuarioService.getUsuarioPeriodo(idUsuario);
        
        return new ResponseEntity(dto, HttpStatus.OK);
    }
}
