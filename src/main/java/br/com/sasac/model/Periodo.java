package br.com.sasac.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.time.Instant;
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
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "dt_publicacao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dt_publicacao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "avaliacao_id")
    @JsonBackReference
    private Avaliacao avaliacao;

    @ManyToMany(mappedBy = "periodo", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Usuario> usuarios;

    @Column(name = "respostas_positivas", nullable = true, length = 30)
    private int respostasPositivas;

    @Column(name = "respostas_neutras", nullable = true, length = 30)
    private int respostasNeutras;

    @Column(name = "respostas_negativas", nullable = true, length = 30)
    private int respostasNegativas;

    public Periodo() {
    }

    public Periodo(Long idPeriodo) {
        this.id = idPeriodo;
    }

    public Periodo(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
        this.respostasNegativas = 0;
        this.respostasNeutras = 0;
        this.respostasPositivas = 0;
        this.dt_publicacao = Date.from(Instant.now());
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
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
