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
@Table(name = "tabelas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabelas.findAll", query = "SELECT t FROM Tabelas t"),
    @NamedQuery(name = "Tabelas.findByTabelasId", query = "SELECT t FROM Tabelas t WHERE t.tabelasId = :tabelasId"),
    @NamedQuery(name = "Tabelas.findByTabelasnomeTabela", query = "SELECT t FROM Tabelas t WHERE t.tabelasnomeTabela = :tabelasnomeTabela"),
    @NamedQuery(name = "Tabelas.findByTabelasStatus", query = "SELECT t FROM Tabelas t WHERE t.tabelasStatus = :tabelasStatus")})
public class Tabelas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tabelas_id")
    private Integer tabelasId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tabelas_nomeTabela")
    private String tabelasnomeTabela;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "tabelas_status")
    private String tabelasStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "observacaoTabelas")
    private List<Observacao> observacaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "historicoTabelas")
    private List<Historico> historicoList;

    public Tabelas() {
    }

    public Tabelas(Integer tabelasId) {
        this.tabelasId = tabelasId;
    }

    public Tabelas(Integer tabelasId, String tabelasnomeTabela, String tabelasStatus) {
        this.tabelasId = tabelasId;
        this.tabelasnomeTabela = tabelasnomeTabela;
        this.tabelasStatus = tabelasStatus;
    }

    public Integer getTabelasId() {
        return tabelasId;
    }

    public void setTabelasId(Integer tabelasId) {
        this.tabelasId = tabelasId;
    }

    public String getTabelasnomeTabela() {
        return tabelasnomeTabela;
    }

    public void setTabelasnomeTabela(String tabelasnomeTabela) {
        this.tabelasnomeTabela = tabelasnomeTabela;
    }

    public String getTabelasStatus() {
        return tabelasStatus;
    }

    public void setTabelasStatus(String tabelasStatus) {
        this.tabelasStatus = tabelasStatus;
    }

    @XmlTransient
    public List<Observacao> getObservacaoList() {
        return observacaoList;
    }

    public void setObservacaoList(List<Observacao> observacaoList) {
        this.observacaoList = observacaoList;
    }

    @XmlTransient
    public List<Historico> getHistoricoList() {
        return historicoList;
    }

    public void setHistoricoList(List<Historico> historicoList) {
        this.historicoList = historicoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tabelasId != null ? tabelasId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabelas)) {
            return false;
        }
        Tabelas other = (Tabelas) object;
        if ((this.tabelasId == null && other.tabelasId != null) || (this.tabelasId != null && !this.tabelasId.equals(other.tabelasId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sacweb.model.Tabelas[ tabelasId=" + tabelasId + " ]";
    }
    
}
