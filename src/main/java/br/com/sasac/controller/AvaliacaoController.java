package br.com.sasac.controller;

import br.com.sasac.DTO.AvaliacaoDTO;
import br.com.sasac.model.Avaliacao;
import br.com.sasac.repository.AvaliacaoRepository;
import br.com.sasac.service.AvaliacaoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Matheus Herculano
 */
@RestController
@CrossOrigin
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody AvaliacaoDTO dto) {
        Avaliacao avaliacao = new Avaliacao(dto);
        avaliacaoService.criarAvaliacao(avaliacao);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody AvaliacaoDTO dto) {
        Avaliacao avaliacao = new Avaliacao(dto);
        avaliacaoRepository.save(avaliacao);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity get() {
        List<AvaliacaoDTO> dto = avaliacaoService.getAvaliacao();
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    @RequestMapping(value = "/{idAvaliacao}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable Long idAvaliacao) {
        AvaliacaoDTO dto = avaliacaoService.getAvaliacao(idAvaliacao);

        return new ResponseEntity(dto, HttpStatus.OK);
    }

    @RequestMapping(value = "/usuario/{idUsuario}", method = RequestMethod.GET)
    public ResponseEntity getMinhasAvaliacoes(@PathVariable Long idUsuario) {
        List<AvaliacaoDTO> dto = avaliacaoService.getMinhasAvaliacoes(idUsuario);

        return new ResponseEntity(dto, HttpStatus.OK);
    }

    @RequestMapping(value = "/publicado", method = RequestMethod.GET)
    public ResponseEntity getAvaliacoesPublicas( @RequestParam(value = "publicado", required = true) boolean publicado)  {
        List<AvaliacaoDTO> dto = avaliacaoService.getAvaliacoesPublicas(publicado);

        return new ResponseEntity(dto, HttpStatus.OK);
    }

    @RequestMapping(value = "/{idAvaliacao}/publicacao", method = RequestMethod.POST)
    public ResponseEntity setPublicacao(@PathVariable Long idAvaliacao) {
        avaliacaoService.setPublicacao(idAvaliacao);

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
    
    @RequestMapping(value = "/{idAvaliacao}", method = RequestMethod.DELETE)
    public ResponseEntity deletar(@PathVariable Long idAvaliacao) {
        avaliacaoService.delete(idAvaliacao);

        return new ResponseEntity(HttpStatus.OK);
    }
}
