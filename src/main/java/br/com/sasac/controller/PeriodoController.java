/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sasac.controller;

import br.com.sasac.model.Periodo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ra21501871
 */
@RestController
@RequestMapping("/periodo")
public class PeriodoController extends CustomController<Periodo, CrudRepository<Periodo, Long>>{
    
}
