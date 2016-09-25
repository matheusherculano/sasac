package br.com.sasac.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private UsuarioSasac usuarioCriador;
    
    
//     @OneToMany(fetch = FetchType.EAGER)
//     @JoinTable(name="periodo_avaliacao",  
//                     joinColumns={@JoinColumn(name="avaliacao_id", 
//                      referencedColumnName="id")},  
//                     inverseJoinColumns={@JoinColumn(name="periodo_id", 
//                       referencedColumnName="id")})  
    @OneToMany(cascade=CascadeType.ALL, mappedBy="avaliacao")
    @JsonManagedReference
    private List<Periodo> periodo;
     
     @ManyToOne
    @JoinColumn(name = "repeticao_id")
     private Repeticao repeticao;
     
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

    public Repeticao getRepeticao() {
        return repeticao;
    }

    public void setRepeticao(Repeticao repeticao) {
        this.repeticao = repeticao;
    }

    
    
    public List<Periodo> getPeriodo() {
        return periodo;
    }

    public void setPeriodo(List<Periodo> periodo) {
        this.periodo = periodo;
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
