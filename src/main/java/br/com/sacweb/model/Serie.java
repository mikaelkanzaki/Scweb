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
@Table(name = "serie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Serie.findAll", query = "SELECT s FROM Serie s"),
    @NamedQuery(name = "Serie.findBySerieId", query = "SELECT s FROM Serie s WHERE s.serieId = :serieId"),
    @NamedQuery(name = "Serie.findBySerieNome", query = "SELECT s FROM Serie s WHERE s.serieNome = :serieNome"),
    @NamedQuery(name = "Serie.findBySerieStatus", query = "SELECT s FROM Serie s WHERE s.serieStatus = :serieStatus")})
public class Serie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "serie_id")
    private Integer serieId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "serie_nome")
    private String serieNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "serie_status")
    private String serieStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lotacaoSerie")
    private List<Lotacao> lotacaoList;

    public Serie() {
    }

    public Serie(Integer serieId) {
        this.serieId = serieId;
    }

    public Serie(Integer serieId, String serieNome, String serieStatus) {
        this.serieId = serieId;
        this.serieNome = serieNome;
        this.serieStatus = serieStatus;
    }

    public Integer getSerieId() {
        return serieId;
    }

    public void setSerieId(Integer serieId) {
        this.serieId = serieId;
    }

    public String getSerieNome() {
        return serieNome;
    }

    public void setSerieNome(String serieNome) {
        this.serieNome = serieNome;
    }

    public String getSerieStatus() {
        return serieStatus;
    }

    public void setSerieStatus(String serieStatus) {
        this.serieStatus = serieStatus;
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
        hash += (serieId != null ? serieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Serie)) {
            return false;
        }
        Serie other = (Serie) object;
        if ((this.serieId == null && other.serieId != null) || (this.serieId != null && !this.serieId.equals(other.serieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sacweb.model.Serie[ serieId=" + serieId + " ]";
    }
    
}
