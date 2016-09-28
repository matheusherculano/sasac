/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sasac.service.impl;

import br.com.sasac.DTO.AvaliacaoDTO;
import br.com.sasac.model.Avaliacao;
import br.com.sasac.model.Usuario;
import br.com.sasac.repository.AvaliacaoRepository;
import br.com.sasac.service.AvaliacaoService;
import java.util.ArrayList;
import java.util.List;
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

    @Override
    public List<AvaliacaoDTO> getMinhasAvaliacoes(Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);

        List<Avaliacao> avaliacaoList = avaliacaoRepository.findByUsuarioCriador(usuario);

        List<AvaliacaoDTO> lista = new ArrayList<AvaliacaoDTO>();

        for (Avaliacao item : avaliacaoList) {
            AvaliacaoDTO dto = new AvaliacaoDTO();

            dto.setId(item.getId());
            dto.setTitulo(item.getTitulo());
            dto.setDescricao(item.getDescricao());
            dto.setPublicado(item.isPublicado());
            dto.setDt_disponibilidade(item.getDt_disponibilidade());
            dto.setUsuarioCriador(item.getUsuarioCriador());

            lista.add(dto);
        }

        return lista;
    }

    @Override
    public List<AvaliacaoDTO> getAvaliacao() {
        Usuario usuario = new Usuario();

        Iterable<Avaliacao> avaliacaoList = avaliacaoRepository.findAll();

        List<AvaliacaoDTO> lista = new ArrayList<AvaliacaoDTO>();

        for (Avaliacao item : avaliacaoList) {
            AvaliacaoDTO dto = new AvaliacaoDTO(item);

            lista.add(dto);
        }

        return lista;
    }

    @Override
    public List<AvaliacaoDTO> getAvaliacoesPublicas() {
        List<Avaliacao> avaliacoes = avaliacaoRepository.findByPublicado(true);
        List<AvaliacaoDTO> lista = new ArrayList<AvaliacaoDTO>();

        for (Avaliacao item : avaliacoes) {
            AvaliacaoDTO dto = new AvaliacaoDTO(item);

            lista.add(dto);
        }

        return lista;
    }

    @Override
    public void setPublicacao(Long idAvaliacao) {
        Avaliacao avaliacao = avaliacaoRepository.findOne(idAvaliacao);

        if (avaliacao.isPublicado()) {
            avaliacao.setPublicado(false);
        } else {
            avaliacao.setPublicado(true);
        }

        avaliacaoRepository.save(avaliacao);
    }

}
