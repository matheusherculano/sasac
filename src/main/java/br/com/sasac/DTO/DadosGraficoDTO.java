package br.com.sasac.DTO;

import br.com.sasac.model.Repeticao;
import java.util.List;

/**
 *
 * @author Matheus Herculano
 */
public class DadosGraficoDTO {
    
    private String titulo;
    private String descricao;
    private Repeticao repeticao;
    private List<DadosPeriodosDTO> periodos;

    public DadosGraficoDTO() {
    }
    
    public String getTitulo() {
        return titulo;
    }

    public Repeticao getRepeticao() {
        return repeticao;
    }

    public void setRepeticao(Repeticao repeticao) {
        this.repeticao = repeticao;
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
