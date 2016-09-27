package br.com.sasac.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Matheus Herculano
 */
@Entity
@Table(name = "periodo")
public class Periodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "dt_publicacao")
    @Temporal(TemporalType.DATE)
    private Date dt_publicacao;

    @ManyToOne
    @JoinColumn(name = "avaliacao_id")
    @JsonBackReference
    private Avaliacao avaliacao;
    
    @ManyToMany(mappedBy="periodo", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<UsuarioSasac> usuarios;
    
     @Column(name = "respostas_positivas")
    private int respostasPositivas;

    @Column(name = "respostas_neutras")
    private int respostasNeutras;

    @Column(name = "respostas_negativas")
    private int respostasNegativas;

    public List<UsuarioSasac> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioSasac> usuarios) {
        this.usuarios = usuarios;
    }
    

    public int getRespostasPositivas() {
        return respostasPositivas;
    }

    public void setRespostasPositivas(int respostasPositivas) {
        this.respostasPositivas = respostasPositivas;
    }

    public int getRespostasNeutras() {
        return respostasNeutras;
    }

    public void setRespostasNeutras(int respostasNeutras) {
        this.respostasNeutras = respostasNeutras;
    }

    public int getRespostasNegativas() {
        return respostasNegativas;
    }

    public void setRespostasNegativas(int respostasNegativas) {
        this.respostasNegativas = respostasNegativas;
    }
    
    public Periodo() {
    }

    
    public Long getId() {
        return id;
    }
    
     public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDt_publicacao() {
        return dt_publicacao;
    }

    public void setDt_publicacao(Date dt_publicacao) {
        this.dt_publicacao = dt_publicacao;
    }

}
