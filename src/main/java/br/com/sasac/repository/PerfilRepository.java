package br.com.sasac.repository;

import br.com.sasac.model.Perfil;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends CrudRepository<Perfil, Long>{
    
}
