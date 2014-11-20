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
@Table(name = "gratificacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gratificacao.findAll", query = "SELECT g FROM Gratificacao g"),
    @NamedQuery(name = "Gratificacao.findByGratificacaoId", query = "SELECT g FROM Gratificacao g WHERE g.gratificacaoId = :gratificacaoId"),
    @NamedQuery(name = "Gratificacao.findByGratificacaoNome", query = "SELECT g FROM Gratificacao g WHERE g.gratificacaoNome = :gratificacaoNome"),
    @NamedQuery(name = "Gratificacao.findByGratificacaoStatus", query = "SELECT g FROM Gratificacao g WHERE g.gratificacaoStatus = :gratificacaoStatus")})
public class Gratificacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gratificacao_id")
    private Integer gratificacaoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "gratificacao_nome")
    private String gratificacaoNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "gratificacao_status")
    private String gratificacaoStatus;
    @OneToMany(mappedBy = "frequenciaGratificacao")
    private List<Frequencia> frequenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lotacaoGratificacao")
    private List<Lotacao> lotacaoList;

    public Gratificacao() {
    }

    public Gratificacao(Integer gratificacaoId) {
        this.gratificacaoId = gratificacaoId;
    }

    public Gratificacao(Integer gratificacaoId, String gratificacaoNome, String gratificacaoStatus) {
        this.gratificacaoId = gratificacaoId;
        this.gratificacaoNome = gratificacaoNome;
        this.gratificacaoStatus = gratificacaoStatus;
    }

    public Integer getGratificacaoId() {
        return gratificacaoId;
    }

    public void setGratificacaoId(Integer gratificacaoId) {
        this.gratificacaoId = gratificacaoId;
    }

    public String getGratificacaoNome() {
        return gratificacaoNome;
    }

    public void setGratificacaoNome(String gratificacaoNome) {
        this.gratificacaoNome = gratificacaoNome;
    }

    public String getGratificacaoStatus() {
        return gratificacaoStatus;
    }

    public void setGratificacaoStatus(String gratificacaoStatus) {
        this.gratificacaoStatus = gratificacaoStatus;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gratificacaoId != null ? gratificacaoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gratificacao)) {
            return false;
        }
        Gratificacao other = (Gratificacao) object;
        if ((this.gratificacaoId == null && other.gratificacaoId != null) || (this.gratificacaoId != null && !this.gratificacaoId.equals(other.gratificacaoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sacweb.model.Gratificacao[ gratificacaoId=" + gratificacaoId + " ]";
    }
    
}
