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
@Table(name = "local")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Local.findAll", query = "SELECT l FROM Local l"),
    @NamedQuery(name = "Local.findByLocalId", query = "SELECT l FROM Local l WHERE l.localId = :localId"),
    @NamedQuery(name = "Local.findByLocalTipo", query = "SELECT l FROM Local l WHERE l.localTipo = :localTipo"),
    @NamedQuery(name = "Local.findByLocalescolaINEP", query = "SELECT l FROM Local l WHERE l.localescolaINEP = :localescolaINEP"),
    @NamedQuery(name = "Local.findByLocalNome", query = "SELECT l FROM Local l WHERE l.localNome = :localNome"),
    @NamedQuery(name = "Local.findByLocalLogradouro", query = "SELECT l FROM Local l WHERE l.localLogradouro = :localLogradouro"),
    @NamedQuery(name = "Local.findByLocalNum", query = "SELECT l FROM Local l WHERE l.localNum = :localNum"),
    @NamedQuery(name = "Local.findByLocalCep", query = "SELECT l FROM Local l WHERE l.localCep = :localCep"),
    @NamedQuery(name = "Local.findByLocalTelefone", query = "SELECT l FROM Local l WHERE l.localTelefone = :localTelefone"),
    @NamedQuery(name = "Local.findByLocalZona", query = "SELECT l FROM Local l WHERE l.localZona = :localZona"),
    @NamedQuery(name = "Local.findByLocalStatus", query = "SELECT l FROM Local l WHERE l.localStatus = :localStatus")})
public class Local implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "local_id")
    private Integer localId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "local_tipo")
    private String localTipo;
    @Size(max = 50)
    @Column(name = "local_escolaINEP")
    private String localescolaINEP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "local_nome")
    private String localNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "local_logradouro")
    private String localLogradouro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "local_num")
    private String localNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "local_cep")
    private String localCep;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "local_telefone")
    private String localTelefone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "local_zona")
    private String localZona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "local_status")
    private String localStatus;
    @OneToMany(mappedBy = "funcionarioLocal")
    private List<Funcionario> funcionarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lotacaoLocal")
    private List<Lotacao> lotacaoList;
    @JoinColumn(name = "local_cidade", referencedColumnName = "cidade_id")
    @ManyToOne(optional = false)
    private Cidade localCidade;
    @JoinColumn(name = "local_bairro", referencedColumnName = "bairro_id")
    @ManyToOne(optional = false)
    private Bairro localBairro;
    @JoinColumn(name = "local_diretor", referencedColumnName = "funcionario_id")
    @ManyToOne
    private Funcionario localDiretor;

    public Local() {
    }

    public Local(Integer localId) {
        this.localId = localId;
    }

    public Local(Integer localId, String localTipo, String localNome, String localLogradouro, String localNum, String localCep, String localTelefone, String localZona, String localStatus) {
        this.localId = localId;
        this.localTipo = localTipo;
        this.localNome = localNome;
        this.localLogradouro = localLogradouro;
        this.localNum = localNum;
        this.localCep = localCep;
        this.localTelefone = localTelefone;
        this.localZona = localZona;
        this.localStatus = localStatus;
    }

    public Integer getLocalId() {
        return localId;
    }

    public void setLocalId(Integer localId) {
        this.localId = localId;
    }

    public String getLocalTipo() {
        return localTipo;
    }

    public void setLocalTipo(String localTipo) {
        this.localTipo = localTipo;
    }

    public String getLocalescolaINEP() {
        return localescolaINEP;
    }

    public void setLocalescolaINEP(String localescolaINEP) {
        this.localescolaINEP = localescolaINEP;
    }

    public String getLocalNome() {
        return localNome;
    }

    public void setLocalNome(String localNome) {
        this.localNome = localNome;
    }

    public String getLocalLogradouro() {
        return localLogradouro;
    }

    public void setLocalLogradouro(String localLogradouro) {
        this.localLogradouro = localLogradouro;
    }

    public String getLocalNum() {
        return localNum;
    }

    public void setLocalNum(String localNum) {
        this.localNum = localNum;
    }

    public String getLocalCep() {
        return localCep;
    }

    public void setLocalCep(String localCep) {
        this.localCep = localCep;
    }

    public String getLocalTelefone() {
        return localTelefone;
    }

    public void setLocalTelefone(String localTelefone) {
        this.localTelefone = localTelefone;
    }

    public String getLocalZona() {
        return localZona;
    }

    public void setLocalZona(String localZona) {
        this.localZona = localZona;
    }

    public String getLocalStatus() {
        return localStatus;
    }

    public void setLocalStatus(String localStatus) {
        this.localStatus = localStatus;
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

    public Cidade getLocalCidade() {
        return localCidade;
    }

    public void setLocalCidade(Cidade localCidade) {
        this.localCidade = localCidade;
    }

    public Bairro getLocalBairro() {
        return localBairro;
    }

    public void setLocalBairro(Bairro localBairro) {
        this.localBairro = localBairro;
    }

    public Funcionario getLocalDiretor() {
        return localDiretor;
    }

    public void setLocalDiretor(Funcionario localDiretor) {
        this.localDiretor = localDiretor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (localId != null ? localId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Local)) {
            return false;
        }
        Local other = (Local) object;
        if ((this.localId == null && other.localId != null) || (this.localId != null && !this.localId.equals(other.localId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sacweb.model.Local[ localId=" + localId + " ]";
    }
    
}
