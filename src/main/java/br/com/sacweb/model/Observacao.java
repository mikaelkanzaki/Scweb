/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sacweb.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JM
 */
@Entity
@Table(name = "observacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Observacao.findAll", query = "SELECT o FROM Observacao o"),
    @NamedQuery(name = "Observacao.findByObservacaoId", query = "SELECT o FROM Observacao o WHERE o.observacaoId = :observacaoId"),
    @NamedQuery(name = "Observacao.findByObservacaoColuna", query = "SELECT o FROM Observacao o WHERE o.observacaoColuna = :observacaoColuna"),
    @NamedQuery(name = "Observacao.findByObservacaoTexto", query = "SELECT o FROM Observacao o WHERE o.observacaoTexto = :observacaoTexto"),
    @NamedQuery(name = "Observacao.findByObservacaoData", query = "SELECT o FROM Observacao o WHERE o.observacaoData = :observacaoData"),
    @NamedQuery(name = "Observacao.findByObservacaoStatus", query = "SELECT o FROM Observacao o WHERE o.observacaoStatus = :observacaoStatus")})
public class Observacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "observacao_id")
    private Integer observacaoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "observacao_coluna")
    private int observacaoColuna;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3000)
    @Column(name = "observacao_texto")
    private String observacaoTexto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "observacao_data")
    @Temporal(TemporalType.DATE)
    private Date observacaoData;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "observacao_status")
    private String observacaoStatus;
    @JoinColumn(name = "observacao_tabelas", referencedColumnName = "tabelas_id")
    @ManyToOne(optional = false)
    private Tabelas observacaoTabelas;
    @JoinColumn(name = "observacao_funcionario", referencedColumnName = "funcionario_id")
    @ManyToOne(optional = false)
    private Funcionario observacaoFuncionario;

    public Observacao() {
    }

    public Observacao(Integer observacaoId) {
        this.observacaoId = observacaoId;
    }

    public Observacao(Integer observacaoId, int observacaoColuna, String observacaoTexto, Date observacaoData, String observacaoStatus) {
        this.observacaoId = observacaoId;
        this.observacaoColuna = observacaoColuna;
        this.observacaoTexto = observacaoTexto;
        this.observacaoData = observacaoData;
        this.observacaoStatus = observacaoStatus;
    }

    public Integer getObservacaoId() {
        return observacaoId;
    }

    public void setObservacaoId(Integer observacaoId) {
        this.observacaoId = observacaoId;
    }

    public int getObservacaoColuna() {
        return observacaoColuna;
    }

    public void setObservacaoColuna(int observacaoColuna) {
        this.observacaoColuna = observacaoColuna;
    }

    public String getObservacaoTexto() {
        return observacaoTexto;
    }

    public void setObservacaoTexto(String observacaoTexto) {
        this.observacaoTexto = observacaoTexto;
    }

    public Date getObservacaoData() {
        return observacaoData;
    }

    public void setObservacaoData(Date observacaoData) {
        this.observacaoData = observacaoData;
    }

    public String getObservacaoStatus() {
        return observacaoStatus;
    }

    public void setObservacaoStatus(String observacaoStatus) {
        this.observacaoStatus = observacaoStatus;
    }

    public Tabelas getObservacaoTabelas() {
        return observacaoTabelas;
    }

    public void setObservacaoTabelas(Tabelas observacaoTabelas) {
        this.observacaoTabelas = observacaoTabelas;
    }

    public Funcionario getObservacaoFuncionario() {
        return observacaoFuncionario;
    }

    public void setObservacaoFuncionario(Funcionario observacaoFuncionario) {
        this.observacaoFuncionario = observacaoFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (observacaoId != null ? observacaoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Observacao)) {
            return false;
        }
        Observacao other = (Observacao) object;
        if ((this.observacaoId == null && other.observacaoId != null) || (this.observacaoId != null && !this.observacaoId.equals(other.observacaoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sacweb.model.Observacao[ observacaoId=" + observacaoId + " ]";
    }
    
}
