package br.com.sasac.controller;

import br.com.sasac.DTO.AvaliacaoDTO;
import br.com.sasac.model.Avaliacao;
import br.com.sasac.service.AvaliacaoService;
import br.com.sasac.service.PeriodoService;
import br.com.sasac.service.impl.AvaliacaoServiceImp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Matheus Herculano
 */
@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController extends CustomController<Avaliacao, CrudRepository<Avaliacao, Long>>{
    
    @Autowired
    private AvaliacaoService avaliacaoService;
    
    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity get(){
         List<AvaliacaoDTO> dto  = avaliacaoService.getAvaliacao();
        
        return new ResponseEntity(dto, HttpStatus.OK);
    }
    
    @Override
    @RequestMapping(value = "/{idAvaliacao}",method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable Long idAvaliacao){
        AvaliacaoDTO dto = avaliacaoService.getAvaliacao(idAvaliacao);
        
        return new ResponseEntity(dto, HttpStatus.OK);
    }
   
    @RequestMapping(value = "/usuario/{idUsuario}",method = RequestMethod.GET)
    public ResponseEntity getMinhasAvaliacoes(@PathVariable Long idUsuario){
         List<AvaliacaoDTO> dto  = avaliacaoService.getMinhasAvaliacoes(idUsuario);
        
        return new ResponseEntity(dto, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/publicado",method = RequestMethod.GET)
    public ResponseEntity getAvaliacoesPublicas(){
         List<AvaliacaoDTO> dto  = avaliacaoService.getAvaliacoesPublicas();
        
        return new ResponseEntity(dto, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{idAvaliacao}/publicacao",method = RequestMethod.POST)
    public ResponseEntity setPublicacao(@PathVariable Long idAvaliacao){
         avaliacaoService.setPublicacao(idAvaliacao);
        
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
