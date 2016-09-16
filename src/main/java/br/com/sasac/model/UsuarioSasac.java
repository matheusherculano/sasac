package br.com.sasac.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    
    @Column(name = "perfil")
    private String perfil;
    
    @OneToMany(mappedBy = "usuarioCriador")
    @JsonBackReference
    private List<Avaliacao> avaliacaos;
    
//    @ManyToMany
//	@JoinTable(name="avaliacao_usuario", joinColumns={@JoinColumn(name="id_avaliacao")}, inverseJoinColumns={@JoinColumn(name="id_usuario")})
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinTable(name="usuario_avaliacao", joinColumns={@JoinColumn(name="usuario_id")}, inverseJoinColumns={@JoinColumn(name="avaliacao_id")})
    private List<Avaliacao> usuario_avaliacao;
    

    public UsuarioSasac() {
    }

    public UsuarioSasac(Long id, String nome, String perfil, List<Avaliacao> avaliacaos, List<Avaliacao> usuario_avaliacao) {
        this.id = id;
        this.nome = nome;
        this.perfil = perfil;
        this.avaliacaos = avaliacaos;
        this.usuario_avaliacao = usuario_avaliacao;
    }

    public List<Avaliacao> getUsuario_avaliacao() {
        return usuario_avaliacao;
    }

    public void setUsuario_avaliacao(List<Avaliacao> usuario_avaliacao) {
        this.usuario_avaliacao = usuario_avaliacao;
    }
    

    
    

    public String getNome() {
        return nome;
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

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public List<Avaliacao> getAvaliacaos() {
        return avaliacaos;
    }

    public void setAvaliacaos(List<Avaliacao> avaliacaos) {
        this.avaliacaos = avaliacaos;
    }


    
    
}
