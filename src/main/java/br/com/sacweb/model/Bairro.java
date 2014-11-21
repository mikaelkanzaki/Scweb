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
@Table(name = "bairro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bairro.findAll", query = "SELECT b FROM Bairro b"),
    @NamedQuery(name = "Bairro.findByBairroId", query = "SELECT b FROM Bairro b WHERE b.bairroId = :bairroId"),
    @NamedQuery(name = "Bairro.findByBairroNome", query = "SELECT b FROM Bairro b WHERE b.bairroNome = :bairroNome"),
    @NamedQuery(name = "Bairro.findByBairroStatus", query = "SELECT b FROM Bairro b WHERE b.bairroStatus = :bairroStatus"),
    @NamedQuery(name = "Bairro.findByIdCidade", query = "SELECT b FROM Bairro b WHERE b.bairroCidade.cidadeId = :cidadeId")})
public class Bairro implements Serializable {

    @JoinColumn(name = "bairro_cidade", referencedColumnName = "cidade_id")
    @ManyToOne
    private Cidade bairroCidade;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bairro_id")
    private Integer bairroId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "bairro_nome")
    private String bairroNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "bairro_status")
    private String bairroStatus;
    @OneToMany(mappedBy = "pessoaBairro")
    private List<Pessoa> pessoaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localBairro")
    private List<Local> localList;

    public Bairro() {
    }

    public Bairro(Integer bairroId) {
        this.bairroId = bairroId;
    }

    public Bairro(Integer bairroId, String bairroNome, String bairroStatus) {
        this.bairroId = bairroId;
        this.bairroNome = bairroNome;
        this.bairroStatus = bairroStatus;
    }

    public Integer getBairroId() {
        return bairroId;
    }

    public void setBairroId(Integer bairroId) {
        this.bairroId = bairroId;
    }

    public String getBairroNome() {
        return bairroNome;
    }

    public void setBairroNome(String bairroNome) {
        this.bairroNome = bairroNome;
    }

    public String getBairroStatus() {
        return bairroStatus;
    }

    public void setBairroStatus(String bairroStatus) {
        this.bairroStatus = bairroStatus;
    }

    @XmlTransient
    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
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
        hash += (bairroId != null ? bairroId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bairro)) {
            return false;
        }
        Bairro other = (Bairro) object;
        if ((this.bairroId == null && other.bairroId != null) || (this.bairroId != null && !this.bairroId.equals(other.bairroId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sacweb.model.Bairro[ bairroId=" + bairroId + " ]";
    }

    public Cidade getBairroCidade() {
        return bairroCidade;
    }

    public void setBairroCidade(Cidade bairroCidade) {
        this.bairroCidade = bairroCidade;
    }

}
