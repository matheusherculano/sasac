package br.com.sasac.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ra21501871
 */
@Entity
@Table(name = "respostas")
public class Respostas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @OneToOne
    private Periodo periodo;
    
    @Column(name = "respostas_positivas")
    private int respostasPositivas;

    @Column(name = "respostas_neutras")
    private int respostasNeutras;

    @Column(name = "respostas_negativas")
    private int respostasNegativas;

    public Respostas() {
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    
    
}
