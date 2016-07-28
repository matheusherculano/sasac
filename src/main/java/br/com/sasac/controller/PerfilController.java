package br.com.sasac.controller;

import br.com.sasac.model.Perfil;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perfil")
public class PerfilController extends CustomController<Perfil, CrudRepository<Perfil, Long>>{
    
}
