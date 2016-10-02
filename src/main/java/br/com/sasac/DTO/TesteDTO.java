/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sasac.DTO;

import br.com.sasac.model.Repeticao;
import br.com.sasac.model.Usuario;
import java.util.Date;

/**
 *
 * @author Matheus Herculano
 */
public class TesteDTO {
//    private Usuario usuarioCriador;

    private String titulo;

    private String descricao;

    private Date dt_disponibilidade;

    private boolean publicado;

    private String respostaPostivia;

    private String respostaNeutra;

    private String respostaNegativa;

     private Repeticao repeticao;
     
     private Usuario usuarioCriador;

    public TesteDTO() {
    }

    public Usuario getUsuarioCriador() {
        return usuarioCriador;
    }

    public void setUsuarioCriador(Usuario usuarioCriador) {
        this.usuarioCriador = usuarioCriador;
    }

    
    public Repeticao getRepeticao() {
        return repeticao;
    }

    public void setRepeticao(Repeticao repeticao) {
        this.repeticao = repeticao;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDt_disponibilidade() {
        return dt_disponibilidade;
    }

    public void setDt_disponibilidade(Date dt_disponibilidade) {
        this.dt_disponibilidade = dt_disponibilidade;
    }

    public boolean isPublicado() {
        return publicado;
    }

    public void setPublicado(boolean publicado) {
        this.publicado = publicado;
    }

    public String getRespostaPostivia() {
        return respostaPostivia;
    }

    public void setRespostaPostivia(String respostaPostivia) {
        this.respostaPostivia = respostaPostivia;
    }

    public String getRespostaNeutra() {
        return respostaNeutra;
    }

    public void setRespostaNeutra(String respostaNeutra) {
        this.respostaNeutra = respostaNeutra;
    }

    public String getRespostaNegativa() {
        return respostaNegativa;
    }

    public void setRespostaNegativa(String respostaNegativa) {
        this.respostaNegativa = respostaNegativa;
    }
    
    
}
