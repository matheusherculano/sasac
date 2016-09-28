/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sasac.service;

import br.com.sasac.DTO.DadosPeriodosDTO;
import br.com.sasac.DTO.RespostaDTO;
import java.util.List;

/**
 *
 * @author RA21501871
 */
public interface PeriodoService {

    public abstract void addUsuario(RespostaDTO dto);

    public abstract boolean getPermissionToAnswer(Long idUsuario);
    
    public List<DadosPeriodosDTO> getDadosPeriodos(Long idAvaliLong);
}
