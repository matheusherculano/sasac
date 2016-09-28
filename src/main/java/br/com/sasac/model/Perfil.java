package br.com.sasac.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "perfil")
    private String perfil;
    
    @OneToMany(mappedBy = "perfil",fetch = FetchType.LAZY)
//    @JoinTable(name="Perfil_Usuario", joinColumns={@JoinColumn(name="Perfil_id", referencedColumnName="id")}, inverseJoinColumns={@JoinColumn(name="Usuario", referencedColumnName="id")})
//    @JsonManagedReference(value = "perfil-usuario")
    private List<Usuario> usuarios; 

    
    public Perfil() {
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


    
}
