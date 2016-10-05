/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sasac.service;

import br.com.sasac.DTO.DadosGraficoDTO;
import br.com.sasac.DTO.RespostaDTO;
import br.com.sasac.model.Periodo;
import java.util.List;

/**
 *
 * @author RA21501871
 */
public interface PeriodoService {

    void addUsuario(RespostaDTO dto);

    boolean getPermissionToAnswer(RespostaDTO dto);

    DadosGraficoDTO getDadosPeriodos(Long idAvaliLong);

    void newPeriodo(Long idAvaliacao);
    
    List<Periodo> getPeriodoPorAvaliacao(Long idAvaliacao);
    
    Periodo getLastPeriodo(Long idAvaliacao);
}
