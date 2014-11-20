/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sacweb.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JM
 */
@Entity
@Table(name = "lotacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lotacao.findAll", query = "SELECT l FROM Lotacao l"),
    @NamedQuery(name = "Lotacao.findByLotacaoId", query = "SELECT l FROM Lotacao l WHERE l.lotacaoId = :lotacaoId"),
    @NamedQuery(name = "Lotacao.findByLotacaoDias", query = "SELECT l FROM Lotacao l WHERE l.lotacaoDias = :lotacaoDias"),
    @NamedQuery(name = "Lotacao.findByLotacaocargaHoraria", query = "SELECT l FROM Lotacao l WHERE l.lotacaocargaHoraria = :lotacaocargaHoraria"),
    @NamedQuery(name = "Lotacao.findByLotacaohComplementar", query = "SELECT l FROM Lotacao l WHERE l.lotacaohComplementar = :lotacaohComplementar"),
    @NamedQuery(name = "Lotacao.findByLotacaoZona", query = "SELECT l FROM Lotacao l WHERE l.lotacaoZona = :lotacaoZona"),
    @NamedQuery(name = "Lotacao.findByLotacaoStatus", query = "SELECT l FROM Lotacao l WHERE l.lotacaoStatus = :lotacaoStatus")})
public class Lotacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lotacao_id")
    private Integer lotacaoId;
    @Column(name = "lotacao_dias")
    private Integer lotacaoDias;
    @Column(name = "lotacao_cargaHoraria")
    private Integer lotacaocargaHoraria;
    @Column(name = "lotacao_hComplementar")
    private Integer lotacaohComplementar;
    @Size(max = 5)
    @Column(name = "lotacao_zona")
    private String lotacaoZona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "lotacao_status")
    private String lotacaoStatus;
    @OneToMany(mappedBy = "frequencialotacaohComplementar")
    private List<Frequencia> frequenciaList;
    @OneToMany(mappedBy = "frequencialotacaocargaHoraria")
    private List<Frequencia> frequenciaList1;
    @OneToMany(mappedBy = "frequenciaLotacaoDias")
    private List<Frequencia> frequenciaList2;
    @JoinColumn(name = "lotacao_serie", referencedColumnName = "serie_id")
    @ManyToOne(optional = false)
    private Serie lotacaoSerie;
    @JoinColumn(name = "lotacao_periodo", referencedColumnName = "periodo_id")
    @ManyToOne(optional = false)
    private Periodo lotacaoPeriodo;
    @JoinColumn(name = "lotacao_local", referencedColumnName = "local_id")
    @ManyToOne(optional = false)
    private Local lotacaoLocal;
    @JoinColumn(name = "lotacao_investidura", referencedColumnName = "investidura_id")
    @ManyToOne(optional = false)
    private Investidura lotacaoInvestidura;
    @JoinColumn(name = "lotacao_gratificacao", referencedColumnName = "gratificacao_id")
    @ManyToOne(optional = false)
    private Gratificacao lotacaoGratificacao;
    @JoinColumn(name = "lotacao_funcionario", referencedColumnName = "funcionario_id")
    @ManyToOne(optional = false)
    private Funcionario lotacaoFuncionario;
    @JoinColumn(name = "lotacao_funcao", referencedColumnName = "funcao_id")
    @ManyToOne(optional = false)
    private Funcao lotacaoFuncao;
    @JoinColumn(name = "lotacao_disciplina", referencedColumnName = "disciplina_id")
    @ManyToOne(optional = false)
    private Disciplina lotacaoDisciplina;
    @JoinColumn(name = "lotacao_cargo", referencedColumnName = "cargo_id")
    @ManyToOne(optional = false)
    private Cargo lotacaoCargo;
    @JoinColumn(name = "lotacao_atividade", referencedColumnName = "atividade_id")
    @ManyToOne(optional = false)
    private Atividade lotacaoAtividade;

    public Lotacao() {
    }

    public Lotacao(Integer lotacaoId) {
        this.lotacaoId = lotacaoId;
    }

    public Lotacao(Integer lotacaoId, String lotacaoStatus) {
        this.lotacaoId = lotacaoId;
        this.lotacaoStatus = lotacaoStatus;
    }

    public Integer getLotacaoId() {
        return lotacaoId;
    }

    public void setLotacaoId(Integer lotacaoId) {
        this.lotacaoId = lotacaoId;
    }

    public Integer getLotacaoDias() {
        return lotacaoDias;
    }

    public void setLotacaoDias(Integer lotacaoDias) {
        this.lotacaoDias = lotacaoDias;
    }

    public Integer getLotacaocargaHoraria() {
        return lotacaocargaHoraria;
    }

    public void setLotacaocargaHoraria(Integer lotacaocargaHoraria) {
        this.lotacaocargaHoraria = lotacaocargaHoraria;
    }

    public Integer getLotacaohComplementar() {
        return lotacaohComplementar;
    }

    public void setLotacaohComplementar(Integer lotacaohComplementar) {
        this.lotacaohComplementar = lotacaohComplementar;
    }

    public String getLotacaoZona() {
        return lotacaoZona;
    }

    public void setLotacaoZona(String lotacaoZona) {
        this.lotacaoZona = lotacaoZona;
    }

    public String getLotacaoStatus() {
        return lotacaoStatus;
    }

    public void setLotacaoStatus(String lotacaoStatus) {
        this.lotacaoStatus = lotacaoStatus;
    }

    @XmlTransient
    public List<Frequencia> getFrequenciaList() {
        return frequenciaList;
    }

    public void setFrequenciaList(List<Frequencia> frequenciaList) {
        this.frequenciaList = frequenciaList;
    }

    @XmlTransient
    public List<Frequencia> getFrequenciaList1() {
        return frequenciaList1;
    }

    public void setFrequenciaList1(List<Frequencia> frequenciaList1) {
        this.frequenciaList1 = frequenciaList1;
    }

    @XmlTransient
    public List<Frequencia> getFrequenciaList2() {
        return frequenciaList2;
    }

    public void setFrequenciaList2(List<Frequencia> frequenciaList2) {
        this.frequenciaList2 = frequenciaList2;
    }

    public Serie getLotacaoSerie() {
        return lotacaoSerie;
    }

    public void setLotacaoSerie(Serie lotacaoSerie) {
        this.lotacaoSerie = lotacaoSerie;
    }

    public Periodo getLotacaoPeriodo() {
        return lotacaoPeriodo;
    }

    public void setLotacaoPeriodo(Periodo lotacaoPeriodo) {
        this.lotacaoPeriodo = lotacaoPeriodo;
    }

    public Local getLotacaoLocal() {
        return lotacaoLocal;
    }

    public void setLotacaoLocal(Local lotacaoLocal) {
        this.lotacaoLocal = lotacaoLocal;
    }

    public Investidura getLotacaoInvestidura() {
        return lotacaoInvestidura;
    }

    public void setLotacaoInvestidura(Investidura lotacaoInvestidura) {
        this.lotacaoInvestidura = lotacaoInvestidura;
    }

    public Gratificacao getLotacaoGratificacao() {
        return lotacaoGratificacao;
    }

    public void setLotacaoGratificacao(Gratificacao lotacaoGratificacao) {
        this.lotacaoGratificacao = lotacaoGratificacao;
    }

    public Funcionario getLotacaoFuncionario() {
        return lotacaoFuncionario;
    }

    public void setLotacaoFuncionario(Funcionario lotacaoFuncionario) {
        this.lotacaoFuncionario = lotacaoFuncionario;
    }

    public Funcao getLotacaoFuncao() {
        return lotacaoFuncao;
    }

    public void setLotacaoFuncao(Funcao lotacaoFuncao) {
        this.lotacaoFuncao = lotacaoFuncao;
    }

    public Disciplina getLotacaoDisciplina() {
        return lotacaoDisciplina;
    }

    public void setLotacaoDisciplina(Disciplina lotacaoDisciplina) {
        this.lotacaoDisciplina = lotacaoDisciplina;
    }

    public Cargo getLotacaoCargo() {
        return lotacaoCargo;
    }

    public void setLotacaoCargo(Cargo lotacaoCargo) {
        this.lotacaoCargo = lotacaoCargo;
    }

    public Atividade getLotacaoAtividade() {
        return lotacaoAtividade;
    }

    public void setLotacaoAtividade(Atividade lotacaoAtividade) {
        this.lotacaoAtividade = lotacaoAtividade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lotacaoId != null ? lotacaoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lotacao)) {
            return false;
        }
        Lotacao other = (Lotacao) object;
        if ((this.lotacaoId == null && other.lotacaoId != null) || (this.lotacaoId != null && !this.lotacaoId.equals(other.lotacaoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sacweb.model.Lotacao[ lotacaoId=" + lotacaoId + " ]";
    }
    
}
