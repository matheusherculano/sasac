package br.com.sasac.service;

import br.com.sasac.model.Avaliacao;
import br.com.sasac.model.UsuarioSasac;
import br.com.sasac.repository.AvaliacaoRepository;
import br.com.sasac.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private AvaliacaoRepository avaliacaoRepository;
    
    
    public Iterable<Avaliacao> getAvaliacoes (Long id){
        UsuarioSasac usuario = new UsuarioSasac();
        usuario.setId(id);
        Iterable<Avaliacao> a = avaliacaoRepository.findByUsuarioCriador(usuario);
        return a;
    }
}
