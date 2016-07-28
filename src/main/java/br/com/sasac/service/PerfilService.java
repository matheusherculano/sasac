package br.com.sasac.service;

import br.com.sasac.model.Perfil;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;

public interface PerfilService extends CrudRepository<Perfil, Long>{
    
}
