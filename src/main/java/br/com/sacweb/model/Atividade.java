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
@Table(name = "atividade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Atividade.findAll", query = "SELECT a FROM Atividade a"),
    @NamedQuery(name = "Atividade.findByAtividadeId", query = "SELECT a FROM Atividade a WHERE a.atividadeId = :atividadeId"),
    @NamedQuery(name = "Atividade.findByAtividadeNome", query = "SELECT a FROM Atividade a WHERE a.atividadeNome = :atividadeNome"),
    @NamedQuery(name = "Atividade.findByAtividadeStatus", query = "SELECT a FROM Atividade a WHERE a.atividadeStatus = :atividadeStatus")})
public class Atividade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "atividade_id")
    private Integer atividadeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "atividade_nome")
    private String atividadeNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "atividade_status")
    private String atividadeStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lotacaoAtividade")
    private List<Lotacao> lotacaoList;

    public Atividade() {
    }

    public Atividade(Integer atividadeId) {
        this.atividadeId = atividadeId;
    }

    public Atividade(Integer atividadeId, String atividadeNome, String atividadeStatus) {
        this.atividadeId = atividadeId;
        this.atividadeNome = atividadeNome;
        this.atividadeStatus = atividadeStatus;
    }

    public Integer getAtividadeId() {
        return atividadeId;
    }

    public void setAtividadeId(Integer atividadeId) {
        this.atividadeId = atividadeId;
    }

    public String getAtividadeNome() {
        return atividadeNome;
    }

    public void setAtividadeNome(String atividadeNome) {
        this.atividadeNome = atividadeNome;
    }

    public String getAtividadeStatus() {
        return atividadeStatus;
    }

    public void setAtividadeStatus(String atividadeStatus) {
        this.atividadeStatus = atividadeStatus;
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
        hash += (atividadeId != null ? atividadeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atividade)) {
            return false;
        }
        Atividade other = (Atividade) object;
        if ((this.atividadeId == null && other.atividadeId != null) || (this.atividadeId != null && !this.atividadeId.equals(other.atividadeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sacweb.model.Atividade[ atividadeId=" + atividadeId + " ]";
    }
    
}
