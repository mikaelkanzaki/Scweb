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
@Table(name = "investidura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Investidura.findAll", query = "SELECT i FROM Investidura i"),
    @NamedQuery(name = "Investidura.findByInvestiduraId", query = "SELECT i FROM Investidura i WHERE i.investiduraId = :investiduraId"),
    @NamedQuery(name = "Investidura.findByInvestiduraNome", query = "SELECT i FROM Investidura i WHERE i.investiduraNome = :investiduraNome"),
    @NamedQuery(name = "Investidura.findByInvestiduraStatus", query = "SELECT i FROM Investidura i WHERE i.investiduraStatus = :investiduraStatus")})
public class Investidura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "investidura_id")
    private Integer investiduraId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "investidura_nome")
    private String investiduraNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "investidura_status")
    private String investiduraStatus;
    @OneToMany(mappedBy = "funcionarioInvestidura")
    private List<Funcionario> funcionarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lotacaoInvestidura")
    private List<Lotacao> lotacaoList;

    public Investidura() {
    }

    public Investidura(Integer investiduraId) {
        this.investiduraId = investiduraId;
    }

    public Investidura(Integer investiduraId, String investiduraNome, String investiduraStatus) {
        this.investiduraId = investiduraId;
        this.investiduraNome = investiduraNome;
        this.investiduraStatus = investiduraStatus;
    }

    public Integer getInvestiduraId() {
        return investiduraId;
    }

    public void setInvestiduraId(Integer investiduraId) {
        this.investiduraId = investiduraId;
    }

    public String getInvestiduraNome() {
        return investiduraNome;
    }

    public void setInvestiduraNome(String investiduraNome) {
        this.investiduraNome = investiduraNome;
    }

    public String getInvestiduraStatus() {
        return investiduraStatus;
    }

    public void setInvestiduraStatus(String investiduraStatus) {
        this.investiduraStatus = investiduraStatus;
    }

    @XmlTransient
    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
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
        hash += (investiduraId != null ? investiduraId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Investidura)) {
            return false;
        }
        Investidura other = (Investidura) object;
        if ((this.investiduraId == null && other.investiduraId != null) || (this.investiduraId != null && !this.investiduraId.equals(other.investiduraId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sacweb.model.Investidura[ investiduraId=" + investiduraId + " ]";
    }
    
}
