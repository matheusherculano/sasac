package br.com.sasac.DTO;

import br.com.sasac.model.Perfil;
import br.com.sasac.model.Periodo;
import br.com.sasac.model.Usuario;
import java.util.List;

public class UsuarioDTO {
    
    private Long id;
    
    private String nome;
    
    private Perfil perfil;
    
    private List<UltimoPeriodoDTO> periodosRespondidos;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario usuario, List<UltimoPeriodoDTO> periodo) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.perfil = usuario.getPerfil();
        this.periodosRespondidos = periodo;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public List<UltimoPeriodoDTO> getPeriodosRespondidos() {
        return periodosRespondidos;
    }

    public void setPeriodosRespondidos(List<UltimoPeriodoDTO> periodosRespondidos) {
        this.periodosRespondidos = periodosRespondidos;
    }

    
    
}
