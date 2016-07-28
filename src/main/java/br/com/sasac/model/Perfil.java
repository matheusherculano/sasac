package br.com.sasac.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "perfil")
public class Perfil {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "nome_perfil")
    private String nomePerfil;

    public Perfil() {
    }

    public Perfil(Long id, String nomePerfil) {
        this.id = id;
        this.nomePerfil = nomePerfil;
    }

    public Long getIdperfil() {
        return id;
    }

    public void setIdperfil(Long id) {
        this.id = id;
    }

   

    public String getNomePerfil() {
        return nomePerfil;
    }

    public void setNomePerfil(String nomePerfil) {
        this.nomePerfil = nomePerfil;
    }
    
    
            
}
