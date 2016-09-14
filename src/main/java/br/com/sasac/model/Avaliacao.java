package br.com.sasac.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;


/**
 * @author Matheus Herculano
 */
@Entity
@Table(name = "avaliacao")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descricao", nullable = true)
    private String descricao;

    @Column(name = "dt_publicacao")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dt_publicacao;

    @Column(name = "dt_disponibilidade")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dt_disponibilidade;

    @Column(name = "publicado")
    private boolean publicado;
    
    
    @ManyToOne
    private UsuarioSasac usuarioCriador;
    
    @ManyToMany
    @JoinTable(name="usuario_avaliacao", joinColumns={@JoinColumn(name="avaliacao_id")}, inverseJoinColumns={@JoinColumn(name="usuario_id")})
    private List<UsuarioSasac> usuariosResponderam;


    public Avaliacao() {
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDt_publicacao() {
        return dt_publicacao;
    }

    public void setDt_publicacao(Date dt_publicacao) {
        this.dt_publicacao = dt_publicacao;
    }

    public UsuarioSasac getUsuarioCriador() {
        return usuarioCriador;
    }

    public void setUsuarioCriador(UsuarioSasac usuarioCriador) {
        this.usuarioCriador = usuarioCriador;
    }


}
