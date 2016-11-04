/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sasac.repository;

import br.com.sasac.model.Avaliacao;
import br.com.sasac.model.Periodo;
import br.com.sasac.model.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ra21501871
 */
@Repository
public interface PeriodoRepository extends CrudRepository<Periodo, Long> {

    List<Periodo> findPeriodoByAvaliacao(Avaliacao avaliacao);

    List<Periodo> findPeriodoByUsuarios(Usuario usuario);


}
