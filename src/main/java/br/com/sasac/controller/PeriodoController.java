/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sasac.controller;

import br.com.sasac.DTO.DadosGraficoDTO;
import br.com.sasac.DTO.RespostaDTO;
import br.com.sasac.model.Periodo;
import br.com.sasac.service.PeriodoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ra21501871
 */
@RestController
@RequestMapping("/periodo")
public class PeriodoController extends CustomController<Periodo, CrudRepository<Periodo, Long>> {

    @Autowired
    private PeriodoService service;
    

    @RequestMapping(value = "/{idAvaliacao}/novo",method = RequestMethod.POST)
    public ResponseEntity save(@PathVariable Long idAvaliacao) {
        service.newPeriodo(idAvaliacao);
        
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @RequestMapping(path = "/resposta", method = RequestMethod.POST)
    public ResponseEntity responder(@RequestBody RespostaDTO dto) {

        //verificar se o usuário já respondeu esse periodo
        if (service.getPermissionToAnswer(dto)) {

//            verificar o tipo da resposta
            if (dto.getResposta().equals("neu") || dto.getResposta().equals("pos") || dto.getResposta().equals("neg")) {
                service.addUsuario(dto);

                return new ResponseEntity(HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);

            }
        }else{
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }
    
    
    @RequestMapping(value = "/grafico/{idAvaliacao}",method = RequestMethod.GET)
    public ResponseEntity getGrafico(@PathVariable Long idAvaliacao) {
        
         DadosGraficoDTO dto = service.getDadosPeriodos(idAvaliacao);
        
            return new ResponseEntity(dto, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/ultimo",method = RequestMethod.GET)
    public ResponseEntity getUltimoPeriodo() {
        Periodo p = service.getLastPeriodo(1L);
        
            return new ResponseEntity(p, HttpStatus.OK);
    }
}
