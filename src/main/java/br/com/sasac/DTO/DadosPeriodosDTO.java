/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sasac.DTO;

import br.com.sasac.model.Avaliacao;
import java.util.Date;

/**
 *
 * @author RA21501871
 */
public class DadosPeriodosDTO {
    private Long id;

    private int respostasPositivas;

    private int respostasNeutras;

    private int respostasNegativas;

    public DadosPeriodosDTO() {
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
