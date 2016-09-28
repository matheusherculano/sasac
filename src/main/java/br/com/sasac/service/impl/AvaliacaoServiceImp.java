/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sasac.service.impl;

import br.com.sasac.DTO.AvaliacaoDTO;
import br.com.sasac.model.Avaliacao;
import br.com.sasac.repository.AvaliacaoRepository;
import br.com.sasac.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RA21501871
 */
@Service
public class AvaliacaoServiceImp implements AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Override
    public AvaliacaoDTO getAvaliacao(Long id) {
        AvaliacaoDTO dto = new AvaliacaoDTO();
        Avaliacao a = avaliacaoRepository.findOne(id);

        //montagem do DTO
        dto.setDescricao(a.getDescricao());
        dto.setDt_disponibilidade(a.getDt_disponibilidade());
        dto.setId(a.getId());
        dto.setPublicado(a.isPublicado());
        dto.setTitulo(a.getTitulo());
        dto.setUsuarioCriador(a.getUsuarioCriador());
        
        return dto;
    }

}
