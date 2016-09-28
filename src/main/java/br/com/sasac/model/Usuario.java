package br.com.sasac.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Matheus Herculano
 */
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome_usuario", nullable = false, length = 150)
    private String nome;

//    @ManyToOne(fetch = FetchType.LAZY) perguntar esse lazy para o professor
    @ManyToOne
    @JoinColumn(name = "perfil_id", nullable = false)
//    @JsonBackReference(value = "perfil-usuario")
    private Perfil perfil;

    @OneToMany(mappedBy = "usuarioCriador",fetch = FetchType.LAZY) //perguntar para o professor
    @JsonBackReference
    private List<Avaliacao> avaliacoes;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinTable(name = "usuario_periodo", joinColumns = {
        @JoinColumn(name = "usuario_id")}, inverseJoinColumns = {
        @JoinColumn(name = "periodo_id")})
    private List<Periodo> periodo;

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public List<Periodo> getPeriodo() {
        return periodo;
    }

    public void setPeriodo(List<Periodo> periodo) {
        this.periodo = periodo;
    }

    
    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
