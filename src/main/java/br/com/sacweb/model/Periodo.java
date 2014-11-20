/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sacweb.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "periodo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Periodo.findAll", query = "SELECT p FROM Periodo p"),
    @NamedQuery(name = "Periodo.findByPeriodoId", query = "SELECT p FROM Periodo p WHERE p.periodoId = :periodoId"),
    @NamedQuery(name = "Periodo.findByPeriodoNome", query = "SELECT p FROM Periodo p WHERE p.periodoNome = :periodoNome"),
    @NamedQuery(name = "Periodo.findByPeriodoStatus", query = "SELECT p FROM Periodo p WHERE p.periodoStatus = :periodoStatus")})
public class Periodo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "periodo_id")
    private Integer periodoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "periodo_nome")
    private String periodoNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "periodo_status")
    private String periodoStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lotacaoPeriodo")
    private List<Lotacao> lotacaoList;

    public Periodo() {
    }

    public Periodo(Integer periodoId) {
        this.periodoId = periodoId;
    }

    public Periodo(Integer periodoId, String periodoNome, String periodoStatus) {
        this.periodoId = periodoId;
        this.periodoNome = periodoNome;
        this.periodoStatus = periodoStatus;
    }

    public Integer getPeriodoId() {
        return periodoId;
    }

    public void setPeriodoId(Integer periodoId) {
        this.periodoId = periodoId;
    }

    public String getPeriodoNome() {
        return periodoNome;
    }

    public void setPeriodoNome(String periodoNome) {
        this.periodoNome = periodoNome;
    }

    public String getPeriodoStatus() {
        return periodoStatus;
    }

    public void setPeriodoStatus(String periodoStatus) {
        this.periodoStatus = periodoStatus;
    }

    @XmlTransient
    public List<Lotacao> getLotacaoList() {
        return lotacaoList;
    }

    public void setLotacaoList(List<Lotacao> lotacaoList) {
        this.lotacaoList = lotacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (periodoId != null ? periodoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Periodo)) {
            return false;
        }
        Periodo other = (Periodo) object;
        if ((this.periodoId == null && other.periodoId != null) || (this.periodoId != null && !this.periodoId.equals(other.periodoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sacweb.model.Periodo[ periodoId=" + periodoId + " ]";
    }
    
}
