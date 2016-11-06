/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sasac.repository;

import br.com.sasac.model.Avaliacao;
import br.com.sasac.model.Perfil;
import br.com.sasac.model.Usuario;
import java.util.List;
import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RA21501871
 */
@Repository
public interface AvaliacaoRepository extends CrudRepository<Avaliacao, Long> {

    public Avaliacao findByTitulo(String titulo);

    public List<Avaliacao> findByUsuarioCriador(Usuario u);

    public List<Avaliacao> findByPublicado(boolean boo);

    @Query(value = "DELETE FROM PERFIL WHERE id = ?1", nativeQuery = true)
    Perfil findPr(Long id);
}
