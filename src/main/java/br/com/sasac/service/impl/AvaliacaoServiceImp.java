/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sasac.service.impl;

import br.com.sasac.DTO.AvaliacaoDTO;
import br.com.sasac.DTO.DadosPeriodosDTO;
import br.com.sasac.DTO.UltimoPeriodoDTO;
import br.com.sasac.model.Avaliacao;
import br.com.sasac.model.Periodo;
import br.com.sasac.model.Usuario;
import br.com.sasac.repository.AvaliacaoRepository;
import br.com.sasac.repository.PeriodoRepository;
import br.com.sasac.service.AvaliacaoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RA21501871
 */
@Service
public class AvaliacaoServiceImp implements AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private PeriodoServiceImpl periodoServiceImpl;

    @Autowired
    private PeriodoRepository periodoRespository;

    @Override
    public AvaliacaoDTO getAvaliacao(Long id) {
        Avaliacao a = avaliacaoRepository.findOne(id);
        AvaliacaoDTO dto = new AvaliacaoDTO(a);

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

        Iterable<Avaliacao> avaliacaoList = avaliacaoRepository.findAll();

        List<AvaliacaoDTO> lista = new ArrayList<AvaliacaoDTO>();

        for (Avaliacao item : avaliacaoList) {
            AvaliacaoDTO dto = new AvaliacaoDTO(item);

            List<DadosPeriodosDTO> listaPeriodos = new ArrayList<DadosPeriodosDTO>();

            for (Periodo periodo : item.getPeriodo()) {
                DadosPeriodosDTO dadosPeriodo = new DadosPeriodosDTO();

                dadosPeriodo.setId(periodo.getId());
                dadosPeriodo.setRespostasNegativas(periodo.getRespostasNegativas());
                dadosPeriodo.setRespostasNeutras(periodo.getRespostasNeutras());
                dadosPeriodo.setRespostasPositivas(periodo.getRespostasPositivas());

                listaPeriodos.add(dadosPeriodo);
            }

            dto.setPeriodos(listaPeriodos);
            lista.add(dto);
        }

        return lista;
    }

    @Override
    public List<AvaliacaoDTO> getAvaliacoesPublicas(boolean publicado) {
        List<Avaliacao> avaliacoes = avaliacaoRepository.findByPublicado(publicado);
        List<AvaliacaoDTO> lista = new ArrayList<AvaliacaoDTO>();

        for (Avaliacao item : avaliacoes) {

            AvaliacaoDTO dto = new AvaliacaoDTO(item);

            Periodo periodo = periodoServiceImpl.getLastPeriodo(item.getId());

            if (periodo == null) {
                dto.setUltimoPeriodo(null);
            } else {
                dto.setUltimoPeriodo(new UltimoPeriodoDTO(periodo.getId()));
            }

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

    @Override
    public void criarAvaliacao(Avaliacao avaliacao) {
        avaliacaoRepository.save(avaliacao);
        periodoServiceImpl.newPeriodo(avaliacao.getId());
    }

    @Override
    public void delete(Long idAvaliacao){

        Connection cn = null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver carregado!!!");
            cn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/mysql",
                    "root", "usbw");
            System.out.println("Conexão efetuada com sucesso!!!");
            
            
            PreparedStatement stmt = cn.prepareStatement("delete from sasac.usuario_periodo where periodo_id = ?");
            stmt.setInt(1, 1);
            stmt.execute(); 
            
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado");
        } catch (SQLException ex) {
            Logger.getLogger(AvaliacaoServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
