/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sasac.service.impl;

import br.com.sasac.DTO.DadosGraficoDTO;
import br.com.sasac.DTO.DadosPeriodosDTO;
import br.com.sasac.DTO.RespostaDTO;
import br.com.sasac.model.Avaliacao;
import br.com.sasac.model.Periodo;
import br.com.sasac.model.Usuario;
import br.com.sasac.repository.AvaliacaoRepository;
import br.com.sasac.repository.PeriodoRepository;
import br.com.sasac.repository.UsuarioRepository;
import br.com.sasac.service.PeriodoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RA21501871
 */
@Service
public class PeriodoServiceImpl implements PeriodoService {

    @Autowired
    private PeriodoRepository periodoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Override
    public boolean getPermissionToAnswer(Long idUsuario) {
        boolean boo = true;

        Periodo p = periodoRepository.findOne(idUsuario);
        
        for(Usuario item : p.getUsuarios()){
            if(item.getId().equals(idUsuario)){
                boo = false;
            }
        }
        
        return boo;
    }

    @Override
    public void addUsuario(RespostaDTO dto) {
        //carregar dadosperiodo
        Periodo p = periodoRepository.findOne(dto.getIdPeriodo());

        //cadastro da resposta
        if (dto.getResposta().equals("pos")) {
            int count = p.getRespostasPositivas();
            count++;

            p.setRespostasPositivas(count);
        }
        if (dto.getResposta().equals("neg")) {
            int count = p.getRespostasNegativas();
            count++;

            p.setRespostasNegativas(count);
        }
        if (dto.getResposta().equals("neu")) {
            int count = p.getRespostasNeutras();
            count++;

            p.setRespostasNeutras(count);
        }

        Usuario u = usuarioRepository.findOne(dto.getIdUsuario());

        u.getPeriodo().add(p);

        usuarioRepository.save(u);

    }

    @Override
    public DadosGraficoDTO getDadosPeriodos(Long idAvaliLong) {

        Avaliacao a = avaliacaoRepository.findOne(idAvaliLong);
        List<DadosPeriodosDTO> lista = new ArrayList<DadosPeriodosDTO>();
        
        //montagem dados para renderizar grafico no front-end
        for (Periodo item : a.getPeriodo()) {
            DadosPeriodosDTO dto = new DadosPeriodosDTO();
            
            dto.setId(item.getId());
            dto.setRespostasNegativas(item.getRespostasNegativas());
            dto.setRespostasNeutras(item.getRespostasNeutras());
            dto.setRespostasPositivas(item.getRespostasPositivas());
            
            lista.add(dto);
        }
        
        DadosGraficoDTO dto = new DadosGraficoDTO();
        dto.setTitulo(a.getTitulo());
        dto.setDescricao(a.getDescricao());
        dto.setPeriodos(lista);
        
        return dto;
    }

}
