package br.com.sasac.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    private List<Avaliacao> avaliacaos;
    
//    @ManyToMany
//	@JoinTable(name="avaliacao_usuario", joinColumns={@JoinColumn(name="id_avaliacao")}, inverseJoinColumns={@JoinColumn(name="id_usuario")})
    @ManyToMany
    @JoinTable(name="usuario_avaliacao", joinColumns={@JoinColumn(name="usuario_id")}, inverseJoinColumns={@JoinColumn(name="avaliacao_id")})
    private List<Avaliacao> usuariosResponderam;
    

    public UsuarioSasac() {
    }
    

    public UsuarioSasac(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    
}
