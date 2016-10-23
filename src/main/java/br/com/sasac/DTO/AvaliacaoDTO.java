package br.com.sasac.DTO;

import br.com.sasac.model.Avaliacao;
import br.com.sasac.model.Periodo;
import br.com.sasac.model.Repeticao;
import br.com.sasac.model.Usuario;
import java.util.Date;
import java.util.List;

/**
 *
 * @author RA21501871
 */
public class AvaliacaoDTO {

    private Long id;

    private Usuario usuarioCriador;

    private String titulo;

    private String descricao;

    private Date dt_disponibilidade;

    private boolean publicado;

    private String respostaPositivia;

    private String respostaNeutra;

    private String respostaNegativa;

    private Repeticao repeticao;
    
    private UltimoPeriodoDTO ultimoPeriodo;
    
    private List<DadosPeriodosDTO> periodos;

    public List<DadosPeriodosDTO> getPeriodos() {
        return periodos;
    }

    public void setPeriodos(List<DadosPeriodosDTO> periodos) {
        this.periodos = periodos;
    }

    public AvaliacaoDTO() {
    }

    public AvaliacaoDTO(Avaliacao avaliacao) {
        this.id = avaliacao.getId();
        this.usuarioCriador = avaliacao.getUsuarioCriador();
        this.titulo = avaliacao.getTitulo();
        this.descricao = avaliacao.getDescricao();
        this.dt_disponibilidade = avaliacao.getDt_disponibilidade();
        this.publicado = avaliacao.isPublicado();
        this.respostaPositivia = avaliacao.getRespostaPostivia();
        this.respostaNeutra = avaliacao.getRespostaNeutra();
        this.respostaNegativa = avaliacao.getRespostaNegativa();
        this.repeticao = avaliacao.getRepeticao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRespostaPositivia() {
        return respostaPositivia;
    }

    public void setRespostaPositivia(String respostaPositivia) {
        this.respostaPositivia = respostaPositivia;
    }

    public UltimoPeriodoDTO getUltimoPeriodo() {
        return ultimoPeriodo;
    }

    public void setUltimoPeriodo(UltimoPeriodoDTO ultimoPeriodo) {
        this.ultimoPeriodo = ultimoPeriodo;
    }


    
    
    public String getRespostaPostivia() {
        return respostaPositivia;
    }

    public void setRespostaPostivia(String respostaPositivia) {
        this.respostaPositivia = respostaPositivia;
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

    public Usuario getUsuarioCriador() {
        return usuarioCriador;
    }

    public void setUsuarioCriador(Usuario usuarioCriador) {
        this.usuarioCriador = usuarioCriador;
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

    public Repeticao getRepeticao() {
        return repeticao;
    }

    public void setRepeticao(Repeticao repeticao) {
        this.repeticao = repeticao;
    }

}
