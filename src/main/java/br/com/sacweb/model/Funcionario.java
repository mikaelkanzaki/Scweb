/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sacweb.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JM
 */
@Entity
@Table(name = "funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByFuncionarioId", query = "SELECT f FROM Funcionario f WHERE f.funcionarioId = :funcionarioId"),
    @NamedQuery(name = "Funcionario.findByFuncionarioMat", query = "SELECT f FROM Funcionario f WHERE f.funcionarioMat = :funcionarioMat"),
    @NamedQuery(name = "Funcionario.findByFuncionarioctpsNum", query = "SELECT f FROM Funcionario f WHERE f.funcionarioctpsNum = :funcionarioctpsNum"),
    @NamedQuery(name = "Funcionario.findByFuncionarioctpsSerie", query = "SELECT f FROM Funcionario f WHERE f.funcionarioctpsSerie = :funcionarioctpsSerie"),
    @NamedQuery(name = "Funcionario.findByFuncionarioctpsUF", query = "SELECT f FROM Funcionario f WHERE f.funcionarioctpsUF = :funcionarioctpsUF"),
    @NamedQuery(name = "Funcionario.findByFuncionarioCdi", query = "SELECT f FROM Funcionario f WHERE f.funcionarioCdi = :funcionarioCdi"),
    @NamedQuery(name = "Funcionario.findByFuncionarioPis", query = "SELECT f FROM Funcionario f WHERE f.funcionarioPis = :funcionarioPis"),
    @NamedQuery(name = "Funcionario.findByFuncionarioConselho", query = "SELECT f FROM Funcionario f WHERE f.funcionarioConselho = :funcionarioConselho"),
    @NamedQuery(name = "Funcionario.findByFuncionarioconselhoNum", query = "SELECT f FROM Funcionario f WHERE f.funcionarioconselhoNum = :funcionarioconselhoNum"),
    @NamedQuery(name = "Funcionario.findByFuncionariodataEntrada", query = "SELECT f FROM Funcionario f WHERE f.funcionariodataEntrada = :funcionariodataEntrada"),
    @NamedQuery(name = "Funcionario.findByFuncionariodataSaida", query = "SELECT f FROM Funcionario f WHERE f.funcionariodataSaida = :funcionariodataSaida"),
    @NamedQuery(name = "Funcionario.findByFuncionarioStatus", query = "SELECT f FROM Funcionario f WHERE f.funcionarioStatus = :funcionarioStatus")})
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "funcionario_id")
    private Integer funcionarioId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "funcionario_mat")
    private String funcionarioMat;
    @Size(max = 7)
    @Column(name = "funcionario_ctpsNum")
    private String funcionarioctpsNum;
    @Size(max = 5)
    @Column(name = "funcionario_ctpsSerie")
    private String funcionarioctpsSerie;
    @Size(max = 2)
    @Column(name = "funcionario_ctpsUF")
    private String funcionarioctpsUF;
    @Size(max = 10)
    @Column(name = "funcionario_cdi")
    private String funcionarioCdi;
    @Size(max = 11)
    @Column(name = "funcionario_pis")
    private String funcionarioPis;
    @Size(max = 20)
    @Column(name = "funcionario_conselho")
    private String funcionarioConselho;
    @Size(max = 9)
    @Column(name = "funcionario_conselhoNum")
    private String funcionarioconselhoNum;
    @Column(name = "funcionario_dataEntrada")
    @Temporal(TemporalType.DATE)
    private Date funcionariodataEntrada;
    @Column(name = "funcionario_dataSaida")
    @Temporal(TemporalType.DATE)
    private Date funcionariodataSaida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "funcionario_status")
    private String funcionarioStatus;
    @JoinColumn(name = "funcionario_pessoa", referencedColumnName = "pessoa_id")
    @ManyToOne
    private Pessoa funcionarioPessoa;
    @JoinColumn(name = "funcionario_local", referencedColumnName = "local_id")
    @ManyToOne
    private Local funcionarioLocal;
    @JoinColumn(name = "funcionario_investidura", referencedColumnName = "investidura_id")
    @ManyToOne
    private Investidura funcionarioInvestidura;
    @JoinColumn(name = "funcionario_cargo", referencedColumnName = "cargo_id")
    @ManyToOne
    private Cargo funcionarioCargo;
    @JoinColumn(name = "funcionario_formacao", referencedColumnName = "formacao_id")
    @ManyToOne
    private Formacao funcionarioFormacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "observacaoFuncionario")
    private List<Observacao> observacaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "frequenciaFuncionario")
    private List<Frequencia> frequenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lotacaoFuncionario")
    private List<Lotacao> lotacaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "historicoFuncionario")
    private List<Historico> historicoList;
    @OneToMany(mappedBy = "localDiretor")
    private List<Local> localList;

    public Funcionario() {
    }

    public Funcionario(Integer funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public Funcionario(Integer funcionarioId, String funcionarioMat, String funcionarioStatus) {
        this.funcionarioId = funcionarioId;
        this.funcionarioMat = funcionarioMat;
        this.funcionarioStatus = funcionarioStatus;
    }

    public Integer getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Integer funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public String getFuncionarioMat() {
        return funcionarioMat;
    }

    public void setFuncionarioMat(String funcionarioMat) {
        this.funcionarioMat = funcionarioMat;
    }

    public String getFuncionarioctpsNum() {
        return funcionarioctpsNum;
    }

    public void setFuncionarioctpsNum(String funcionarioctpsNum) {
        this.funcionarioctpsNum = funcionarioctpsNum;
    }

    public String getFuncionarioctpsSerie() {
        return funcionarioctpsSerie;
    }

    public void setFuncionarioctpsSerie(String funcionarioctpsSerie) {
        this.funcionarioctpsSerie = funcionarioctpsSerie;
    }

    public String getFuncionarioctpsUF() {
        return funcionarioctpsUF;
    }

    public void setFuncionarioctpsUF(String funcionarioctpsUF) {
        this.funcionarioctpsUF = funcionarioctpsUF;
    }

    public String getFuncionarioCdi() {
        return funcionarioCdi;
    }

    public void setFuncionarioCdi(String funcionarioCdi) {
        this.funcionarioCdi = funcionarioCdi;
    }

    public String getFuncionarioPis() {
        return funcionarioPis;
    }

    public void setFuncionarioPis(String funcionarioPis) {
        this.funcionarioPis = funcionarioPis;
    }

    public String getFuncionarioConselho() {
        return funcionarioConselho;
    }

    public void setFuncionarioConselho(String funcionarioConselho) {
        this.funcionarioConselho = funcionarioConselho;
    }

    public String getFuncionarioconselhoNum() {
        return funcionarioconselhoNum;
    }

    public void setFuncionarioconselhoNum(String funcionarioconselhoNum) {
        this.funcionarioconselhoNum = funcionarioconselhoNum;
    }

    public Date getFuncionariodataEntrada() {
        return funcionariodataEntrada;
    }

    public void setFuncionariodataEntrada(Date funcionariodataEntrada) {
        this.funcionariodataEntrada = funcionariodataEntrada;
    }

    public Date getFuncionariodataSaida() {
        return funcionariodataSaida;
    }

    public void setFuncionariodataSaida(Date funcionariodataSaida) {
        this.funcionariodataSaida = funcionariodataSaida;
    }

    public String getFuncionarioStatus() {
        return funcionarioStatus;
    }

    public void setFuncionarioStatus(String funcionarioStatus) {
        this.funcionarioStatus = funcionarioStatus;
    }

    public Pessoa getFuncionarioPessoa() {
        return funcionarioPessoa;
    }

    public void setFuncionarioPessoa(Pessoa funcionarioPessoa) {
        this.funcionarioPessoa = funcionarioPessoa;
    }

    public Local getFuncionarioLocal() {
        return funcionarioLocal;
    }

    public void setFuncionarioLocal(Local funcionarioLocal) {
        this.funcionarioLocal = funcionarioLocal;
    }

    public Investidura getFuncionarioInvestidura() {
        return funcionarioInvestidura;
    }

    public void setFuncionarioInvestidura(Investidura funcionarioInvestidura) {
        this.funcionarioInvestidura = funcionarioInvestidura;
    }

    public Cargo getFuncionarioCargo() {
        return funcionarioCargo;
    }

    public void setFuncionarioCargo(Cargo funcionarioCargo) {
        this.funcionarioCargo = funcionarioCargo;
    }

    public Formacao getFuncionarioFormacao() {
        return funcionarioFormacao;
    }

    public void setFuncionarioFormacao(Formacao funcionarioFormacao) {
        this.funcionarioFormacao = funcionarioFormacao;
    }

    @XmlTransient
    public List<Observacao> getObservacaoList() {
        return observacaoList;
    }

    public void setObservacaoList(List<Observacao> observacaoList) {
        this.observacaoList = observacaoList;
    }

    @XmlTransient
    public List<Frequencia> getFrequenciaList() {
        return frequenciaList;
    }

    public void setFrequenciaList(List<Frequencia> frequenciaList) {
        this.frequenciaList = frequenciaList;
    }

    @XmlTransient
    public List<Lotacao> getLotacaoList() {
        return lotacaoList;
    }

    public void setLotacaoList(List<Lotacao> lotacaoList) {
        this.lotacaoList = lotacaoList;
    }

    @XmlTransient
    public List<Historico> getHistoricoList() {
        return historicoList;
    }

    public void setHistoricoList(List<Historico> historicoList) {
        this.historicoList = historicoList;
    }

    @XmlTransient
    public List<Local> getLocalList() {
        return localList;
    }

    public void setLocalList(List<Local> localList) {
        this.localList = localList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (funcionarioId != null ? funcionarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.funcionarioId == null && other.funcionarioId != null) || (this.funcionarioId != null && !this.funcionarioId.equals(other.funcionarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sacweb.model.Funcionario[ funcionarioId=" + funcionarioId + " ]";
    }
    
}
