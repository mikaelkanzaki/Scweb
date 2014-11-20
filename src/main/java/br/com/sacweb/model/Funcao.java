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
@Table(name = "funcao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcao.findAll", query = "SELECT f FROM Funcao f"),
    @NamedQuery(name = "Funcao.findByFuncaoId", query = "SELECT f FROM Funcao f WHERE f.funcaoId = :funcaoId"),
    @NamedQuery(name = "Funcao.findByFuncaoNome", query = "SELECT f FROM Funcao f WHERE f.funcaoNome = :funcaoNome"),
    @NamedQuery(name = "Funcao.findByFuncaoStatus", query = "SELECT f FROM Funcao f WHERE f.funcaoStatus = :funcaoStatus")})
public class Funcao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "funcao_id")
    private Integer funcaoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "funcao_nome")
    private String funcaoNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "funcao_status")
    private String funcaoStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lotacaoFuncao")
    private List<Lotacao> lotacaoList;

    public Funcao() {
    }

    public Funcao(Integer funcaoId) {
        this.funcaoId = funcaoId;
    }

    public Funcao(Integer funcaoId, String funcaoNome, String funcaoStatus) {
        this.funcaoId = funcaoId;
        this.funcaoNome = funcaoNome;
        this.funcaoStatus = funcaoStatus;
    }

    public Integer getFuncaoId() {
        return funcaoId;
    }

    public void setFuncaoId(Integer funcaoId) {
        this.funcaoId = funcaoId;
    }

    public String getFuncaoNome() {
        return funcaoNome;
    }

    public void setFuncaoNome(String funcaoNome) {
        this.funcaoNome = funcaoNome;
    }

    public String getFuncaoStatus() {
        return funcaoStatus;
    }

    public void setFuncaoStatus(String funcaoStatus) {
        this.funcaoStatus = funcaoStatus;
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
        hash += (funcaoId != null ? funcaoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcao)) {
            return false;
        }
        Funcao other = (Funcao) object;
        if ((this.funcaoId == null && other.funcaoId != null) || (this.funcaoId != null && !this.funcaoId.equals(other.funcaoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sacweb.model.Funcao[ funcaoId=" + funcaoId + " ]";
    }
    
}
