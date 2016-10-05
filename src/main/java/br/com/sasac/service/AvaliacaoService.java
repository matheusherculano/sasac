/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sasac.service;

import br.com.sasac.DTO.AvaliacaoDTO;
import br.com.sasac.model.Avaliacao;
import java.util.List;

/**
 *
 * @author RA21501871
 */
public interface AvaliacaoService {

    void criarAvaliacao(Avaliacao avaliacao);
    
    AvaliacaoDTO getAvaliacao(Long id);

    List<AvaliacaoDTO> getAvaliacao();

    List<AvaliacaoDTO> getMinhasAvaliacoes(Long id);

    List<AvaliacaoDTO> getAvaliacoesPublicas(boolean boo);

    void setPublicacao(Long idAvaliacao);

}
