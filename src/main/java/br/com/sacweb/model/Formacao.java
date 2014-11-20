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
@Table(name = "formacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formacao.findAll", query = "SELECT f FROM Formacao f"),
    @NamedQuery(name = "Formacao.findByFormacaoId", query = "SELECT f FROM Formacao f WHERE f.formacaoId = :formacaoId"),
    @NamedQuery(name = "Formacao.findByFormacaoNome", query = "SELECT f FROM Formacao f WHERE f.formacaoNome = :formacaoNome"),
    @NamedQuery(name = "Formacao.findByFormacaoStatus", query = "SELECT f FROM Formacao f WHERE f.formacaoStatus = :formacaoStatus")})
public class Formacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "formacao_id")
    private Integer formacaoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "formacao_nome")
    private String formacaoNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "formacao_status")
    private String formacaoStatus;
    @OneToMany(mappedBy = "funcionarioFormacao")
    private List<Funcionario> funcionarioList;

    public Formacao() {
    }

    public Formacao(Integer formacaoId) {
        this.formacaoId = formacaoId;
    }

    public Formacao(Integer formacaoId, String formacaoNome, String formacaoStatus) {
        this.formacaoId = formacaoId;
        this.formacaoNome = formacaoNome;
        this.formacaoStatus = formacaoStatus;
    }

    public Integer getFormacaoId() {
        return formacaoId;
    }

    public void setFormacaoId(Integer formacaoId) {
        this.formacaoId = formacaoId;
    }

    public String getFormacaoNome() {
        return formacaoNome;
    }

    public void setFormacaoNome(String formacaoNome) {
        this.formacaoNome = formacaoNome;
    }

    public String getFormacaoStatus() {
        return formacaoStatus;
    }

    public void setFormacaoStatus(String formacaoStatus) {
        this.formacaoStatus = formacaoStatus;
    }

    @XmlTransient
    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (formacaoId != null ? formacaoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formacao)) {
            return false;
        }
        Formacao other = (Formacao) object;
        if ((this.formacaoId == null && other.formacaoId != null) || (this.formacaoId != null && !this.formacaoId.equals(other.formacaoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sacweb.model.Formacao[ formacaoId=" + formacaoId + " ]";
    }
    
}
