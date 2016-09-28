package br.com.sasac.repository;

import br.com.sasac.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Matheus Herculano
 */
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
    
}
