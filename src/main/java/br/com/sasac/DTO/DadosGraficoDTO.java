package br.com.sasac.DTO;

import java.util.List;

/**
 *
 * @author Matheus Herculano
 */
public class DadosGraficoDTO {
    
    private String titulo;
    private String descricao;
    private List<DadosPeriodosDTO> periodos;

    public DadosGraficoDTO() {
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

    public List<DadosPeriodosDTO> getPeriodos() {
        return periodos;
    }

    public void setPeriodos(List<DadosPeriodosDTO> periodos) {
        this.periodos = periodos;
    }
}
