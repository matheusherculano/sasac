package br.com.sasac.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Matheus Herculano
 */
@Entity
@Table(name = "usuario")
public class UsuarioSasac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome_usuario")
    private String nome;

//    @ManyToOne(fetch = FetchType.LAZY) perguntar esse lazy para o professor
    @ManyToOne
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;

    @OneToMany(fetch = FetchType.EAGER) //perguntar para o professor
    @JoinTable(name = "usuario_avaliacao", joinColumns = {
        @JoinColumn(name = "usuario", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "avaliacao", referencedColumnName = "id")})
    private List<Avaliacao> avaliacoes;

    @ManyToMany
    @JoinTable(name = "usuario_periodo", joinColumns = {
        @JoinColumn(name = "usuario_id")}, inverseJoinColumns = {
        @JoinColumn(name = "periodo_id")})
    private List<Periodo> periodo;

    public UsuarioSasac() {
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
