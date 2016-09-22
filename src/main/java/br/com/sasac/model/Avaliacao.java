package br.com.sasac.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


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

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioSasac usuarioCriador;
//    
//     @OneToMany
//    private List<Periodo> periodo;
     
//       @ManyToMany(fetch = FetchType.LAZY)
//    @JsonBackReference
//    @JoinTable(name="avaliacao_repeticao", joinColumns={@JoinColumn(name="avaliacao_id")}, inverseJoinColumns={@JoinColumn(name="repeticao_id")})
//    private List<Repeticao> avaliacao_repeticao;
     
     
    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descricao", nullable = true)
    private String descricao;


    @Column(name = "dt_disponibilidade")
    @Temporal(TemporalType.DATE)
    private Date  dt_disponibilidade;

    @Column(name = "publicado")
    private boolean publicado;
    
    public Avaliacao() {
    }

    public UsuarioSasac getUsuarioCriador() {
        return usuarioCriador;
    }

    public void setUsuarioCriador(UsuarioSasac usuarioCriador) {
        this.usuarioCriador = usuarioCriador;
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


    public boolean isPublicado() {
        return publicado;
    }

    public void setPublicado(boolean publicado) {
        this.publicado = publicado;
    }



    public Date getDt_disponibilidade() {
        return dt_disponibilidade;
    }

    public void setDt_disponibilidade(Date dt_disponibilidade) {
        this.dt_disponibilidade = dt_disponibilidade;
    }


}
