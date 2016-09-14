package br.com.sasac.service;

import br.com.sasac.model.UsuarioSasac;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Matheus Herculano
 */
public interface UsuarioService extends CrudRepository<UsuarioSasac, Long>{
    
}
