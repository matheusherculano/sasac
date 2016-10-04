package br.com.sasac.service.impl;

import br.com.sasac.DTO.UltimoPeriodoDTO;
import br.com.sasac.DTO.UsuarioDTO;
import br.com.sasac.model.Periodo;
import br.com.sasac.model.Usuario;
import br.com.sasac.repository.PeriodoRepository;
import br.com.sasac.repository.UsuarioRepository;
import br.com.sasac.service.UsuarioService;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PeriodoRepository periodoRepository;
    
    @Override
    public UsuarioDTO getUsuarioPeriodo(Long idUsuario) {
        Usuario usuario = usuarioRepository.findOne(idUsuario);
        
       List<Periodo> listaPeriodo = periodoRepository.findPeriodoByUsuarios(usuario);
       
       //lista para montar dto final
       List<UltimoPeriodoDTO> lista = new ArrayList<UltimoPeriodoDTO>();
       
       for(Periodo item : listaPeriodo){
           UltimoPeriodoDTO dto = new UltimoPeriodoDTO();
           
           dto.setId(item.getId());
           
           lista.add(dto);
       }
       
       UsuarioDTO dto = new UsuarioDTO(usuario, lista);
        
       return dto;
    }
    
    
}
