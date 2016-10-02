package br.com.sasac.model;

import br.com.sasac.DTO.AvaliacaoDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * @author Matheus Herculano
 */
@Entity
@Table(name = "avaliacao")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioCriador;
    
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="avaliacao", fetch = FetchType.LAZY)
    private List<Periodo> periodo;
     
     @ManyToOne(optional = true)
    @JoinColumn(name = "repeticao_id")
     private Repeticao repeticao;
     
    @Column(name = "titulo", length = 40)
    private String titulo;

    @Column(name = "descricao", nullable = true , length = 300)
    private String descricao;
    
    @Column(name = "txt_resposta_Postivia", nullable = false , length = 40)
    private String respostaPositivia;
    
    @Column(name = "txt_resposta_Neutra", nullable = false , length = 40)
    private String respostaNeutra;
    
    @Column(name = "txt_resposta_Negativa", nullable = false, length = 40)
    private String respostaNegativa;


    @Column(name = "dt_disponibilidade", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date  dt_disponibilidade;

    @Column(name = "publicado", nullable = false)
    private boolean publicado;
    
    public Avaliacao() {
    }

    public Avaliacao(AvaliacaoDTO dto) {
        this.id = dto.getId();
        this.usuarioCriador = dto.getUsuarioCriador();
        this.repeticao = dto.getRepeticao();
        this.titulo = dto.getTitulo();
        this.descricao = dto.getDescricao();
        this.respostaPositivia = dto.getRespostaPostivia();
        this.respostaNeutra = dto.getRespostaNeutra();
        this.respostaNegativa = dto.getRespostaNegativa();
        this.dt_disponibilidade = dto.getDt_disponibilidade();
        this.publicado = false;
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

    
    public List<Periodo> getPeriodo() {
        return periodo;
    }

    public void setPeriodo(List<Periodo> periodo) {
        this.periodo = periodo;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public boolean isPublicado() {
        return publicado;
    }

    public void setPublicado(boolean publicado) {
        this.publicado = publicado;
    }



    public Date getDt_disponibilidade() {
        return dt_disponibilidade;
    }

    public void setDt_disponibilidade(Date dt_disponibilidade) {
        this.dt_disponibilidade = dt_disponibilidade;
    }


}
