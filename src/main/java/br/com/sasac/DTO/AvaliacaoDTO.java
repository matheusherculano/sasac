package br.com.sasac.DTO;

import br.com.sasac.model.Periodo;
import br.com.sasac.model.Repeticao;
import br.com.sasac.model.Usuario;
import java.util.Date;
import java.util.List;

/**
 *
 * @author RA21501871
 */
public class AvaliacaoDTO {
    
    private Long id;
    
    private Usuario usuarioCriador;
    
    private String titulo;

    private String descricao;

    private Date  dt_disponibilidade;

    private boolean publicado;

    public AvaliacaoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuarioCriador() {
        return usuarioCriador;
    }

    public void setUsuarioCriador(Usuario usuarioCriador) {
        this.usuarioCriador = usuarioCriador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDt_disponibilidade() {
        return dt_disponibilidade;
    }

    public void setDt_disponibilidade(Date dt_disponibilidade) {
        this.dt_disponibilidade = dt_disponibilidade;
    }

    public boolean isPublicado() {
        return publicado;
    }

    public void setPublicado(boolean publicado) {
        this.publicado = publicado;
    }
    
    
    
    
}
