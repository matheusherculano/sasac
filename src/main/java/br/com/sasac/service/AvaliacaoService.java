/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sasac.service;

import br.com.sasac.DTO.AvaliacaoDTO;
import br.com.sasac.repository.AvaliacaoRepository;

/**
 *
 * @author RA21501871
 */
public interface AvaliacaoService {
    
    public abstract AvaliacaoDTO getAvaliacao(Long id);
}
