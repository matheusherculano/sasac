package br.com.sasac.service;

import br.com.sasac.model.Aluno;
import org.springframework.data.repository.CrudRepository;

public interface AlunoService extends CrudRepository<Aluno, Long>{
    
}
