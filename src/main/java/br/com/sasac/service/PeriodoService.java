/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sasac.service;

import br.com.sasac.model.Periodo;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ra21501871
 */
public interface PeriodoService extends CrudRepository<Periodo, Long> {
    
}
