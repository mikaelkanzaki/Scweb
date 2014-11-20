/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sacweb.model;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JM
 */
@Entity
@Table(name = "frequencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Frequencia.findAll", query = "SELECT f FROM Frequencia f"),
    @NamedQuery(name = "Frequencia.findByFrequenciaId", query = "SELECT f FROM Frequencia f WHERE f.frequenciaId = :frequenciaId"),
    @NamedQuery(name = "Frequencia.findByFrequenciaHe50", query = "SELECT f FROM Frequencia f WHERE f.frequenciaHe50 = :frequenciaHe50"),
    @NamedQuery(name = "Frequencia.findByFrequenciaHe100", query = "SELECT f FROM Frequencia f WHERE f.frequenciaHe100 = :frequenciaHe100"),
    @NamedQuery(name = "Frequencia.findByFrequenciaFalta", query = "SELECT f FROM Frequencia f WHERE f.frequenciaFalta = :frequenciaFalta"),
    @NamedQuery(name = "Frequencia.findByFrequenciaMotivo", query = "SELECT f FROM Frequencia f WHERE f.frequenciaMotivo = :frequenciaMotivo"),
    @NamedQuery(name = "Frequencia.findByFrequenciaStatus", query = "SELECT f FROM Frequencia f WHERE f.frequenciaStatus = :frequenciaStatus")})
public class Frequencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "frequencia_id")
    private Integer frequenciaId;
    @Column(name = "frequencia_he50")
    private Integer frequenciaHe50;
    @Column(name = "frequencia_he100")
    private Integer frequenciaHe100;
    @Column(name = "frequencia_falta")
    private Integer frequenciaFalta;
    @Column(name = "frequencia_motivo")
    private Integer frequenciaMotivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "frequencia_status")
    private String frequenciaStatus;
    @JoinColumn(name = "frequencia_lotacao_hComplementar", referencedColumnName = "lotacao_id")
    @ManyToOne
    private Lotacao frequencialotacaohComplementar;
    @JoinColumn(name = "frequencia_lotacao_cargaHoraria", referencedColumnName = "lotacao_id")
    @ManyToOne
    private Lotacao frequencialotacaocargaHoraria;
    @JoinColumn(name = "frequencia_lotacao_dias", referencedColumnName = "lotacao_id")
    @ManyToOne
    private Lotacao frequenciaLotacaoDias;
    @JoinColumn(name = "frequencia_gratificacao", referencedColumnName = "gratificacao_id")
    @ManyToOne
    private Gratificacao frequenciaGratificacao;
    @JoinColumn(name = "frequencia_funcionario", referencedColumnName = "funcionario_id")
    @ManyToOne(optional = false)
    private Funcionario frequenciaFuncionario;

    public Frequencia() {
    }

    public Frequencia(Integer frequenciaId) {
        this.frequenciaId = frequenciaId;
    }

    public Frequencia(Integer frequenciaId, String frequenciaStatus) {
        this.frequenciaId = frequenciaId;
        this.frequenciaStatus = frequenciaStatus;
    }

    public Integer getFrequenciaId() {
        return frequenciaId;
    }

    public void setFrequenciaId(Integer frequenciaId) {
        this.frequenciaId = frequenciaId;
    }

    public Integer getFrequenciaHe50() {
        return frequenciaHe50;
    }

    public void setFrequenciaHe50(Integer frequenciaHe50) {
        this.frequenciaHe50 = frequenciaHe50;
    }

    public Integer getFrequenciaHe100() {
        return frequenciaHe100;
    }

    public void setFrequenciaHe100(Integer frequenciaHe100) {
        this.frequenciaHe100 = frequenciaHe100;
    }

    public Integer getFrequenciaFalta() {
        return frequenciaFalta;
    }

    public void setFrequenciaFalta(Integer frequenciaFalta) {
        this.frequenciaFalta = frequenciaFalta;
    }

    public Integer getFrequenciaMotivo() {
        return frequenciaMotivo;
    }

    public void setFrequenciaMotivo(Integer frequenciaMotivo) {
        this.frequenciaMotivo = frequenciaMotivo;
    }

    public String getFrequenciaStatus() {
        return frequenciaStatus;
    }

    public void setFrequenciaStatus(String frequenciaStatus) {
        this.frequenciaStatus = frequenciaStatus;
    }

    public Lotacao getFrequencialotacaohComplementar() {
        return frequencialotacaohComplementar;
    }

    public void setFrequencialotacaohComplementar(Lotacao frequencialotacaohComplementar) {
        this.frequencialotacaohComplementar = frequencialotacaohComplementar;
    }

    public Lotacao getFrequencialotacaocargaHoraria() {
        return frequencialotacaocargaHoraria;
    }

    public void setFrequencialotacaocargaHoraria(Lotacao frequencialotacaocargaHoraria) {
        this.frequencialotacaocargaHoraria = frequencialotacaocargaHoraria;
    }

    public Lotacao getFrequenciaLotacaoDias() {
        return frequenciaLotacaoDias;
    }

    public void setFrequenciaLotacaoDias(Lotacao frequenciaLotacaoDias) {
        this.frequenciaLotacaoDias = frequenciaLotacaoDias;
    }

    public Gratificacao getFrequenciaGratificacao() {
        return frequenciaGratificacao;
    }

    public void setFrequenciaGratificacao(Gratificacao frequenciaGratificacao) {
        this.frequenciaGratificacao = frequenciaGratificacao;
    }

    public Funcionario getFrequenciaFuncionario() {
        return frequenciaFuncionario;
    }

    public void setFrequenciaFuncionario(Funcionario frequenciaFuncionario) {
        this.frequenciaFuncionario = frequenciaFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (frequenciaId != null ? frequenciaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Frequencia)) {
            return false;
        }
        Frequencia other = (Frequencia) object;
        if ((this.frequenciaId == null && other.frequenciaId != null) || (this.frequenciaId != null && !this.frequenciaId.equals(other.frequenciaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sacweb.model.Frequencia[ frequenciaId=" + frequenciaId + " ]";
    }
    
}
