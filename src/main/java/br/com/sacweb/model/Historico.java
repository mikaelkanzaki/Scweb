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
@Table(name = "historico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historico.findAll", query = "SELECT h FROM Historico h"),
    @NamedQuery(name = "Historico.findByHist\u00f3ricoId", query = "SELECT h FROM Historico h WHERE h.hist\u00f3ricoId = :hist\u00f3ricoId"),
    @NamedQuery(name = "Historico.findByHist\u00f3ricoColuna", query = "SELECT h FROM Historico h WHERE h.hist\u00f3ricoColuna = :hist\u00f3ricoColuna"),
    @NamedQuery(name = "Historico.findByHistoricoTexto", query = "SELECT h FROM Historico h WHERE h.historicoTexto = :historicoTexto"),
    @NamedQuery(name = "Historico.findByHistoricoData", query = "SELECT h FROM Historico h WHERE h.historicoData = :historicoData"),
    @NamedQuery(name = "Historico.findByHistoricoStatus", query = "SELECT h FROM Historico h WHERE h.historicoStatus = :historicoStatus")})
public class Historico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hist\u00f3rico_id")
    private Integer históricoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hist\u00f3rico_coluna")
    private int históricoColuna;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3000)
    @Column(name = "historico_texto")
    private String historicoTexto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "historico_data")
    @Temporal(TemporalType.DATE)
    private Date historicoData;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "historico_status")
    private String historicoStatus;
    @JoinColumn(name = "historico_tabelas", referencedColumnName = "tabelas_id")
    @ManyToOne(optional = false)
    private Tabelas historicoTabelas;
    @JoinColumn(name = "historico_funcionario", referencedColumnName = "funcionario_id")
    @ManyToOne(optional = false)
    private Funcionario historicoFuncionario;

    public Historico() {
    }

    public Historico(Integer históricoId) {
        this.históricoId = históricoId;
    }

    public Historico(Integer históricoId, int históricoColuna, String historicoTexto, Date historicoData, String historicoStatus) {
        this.históricoId = históricoId;
        this.históricoColuna = históricoColuna;
        this.historicoTexto = historicoTexto;
        this.historicoData = historicoData;
        this.historicoStatus = historicoStatus;
    }

    public Integer getHistóricoId() {
        return históricoId;
    }

    public void setHistóricoId(Integer históricoId) {
        this.históricoId = históricoId;
    }

    public int getHistóricoColuna() {
        return históricoColuna;
    }

    public void setHistóricoColuna(int históricoColuna) {
        this.históricoColuna = históricoColuna;
    }

    public String getHistoricoTexto() {
        return historicoTexto;
    }

    public void setHistoricoTexto(String historicoTexto) {
        this.historicoTexto = historicoTexto;
    }

    public Date getHistoricoData() {
        return historicoData;
    }

    public void setHistoricoData(Date historicoData) {
        this.historicoData = historicoData;
    }

    public String getHistoricoStatus() {
        return historicoStatus;
    }

    public void setHistoricoStatus(String historicoStatus) {
        this.historicoStatus = historicoStatus;
    }

    public Tabelas getHistoricoTabelas() {
        return historicoTabelas;
    }

    public void setHistoricoTabelas(Tabelas historicoTabelas) {
        this.historicoTabelas = historicoTabelas;
    }

    public Funcionario getHistoricoFuncionario() {
        return historicoFuncionario;
    }

    public void setHistoricoFuncionario(Funcionario historicoFuncionario) {
        this.historicoFuncionario = historicoFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (históricoId != null ? históricoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historico)) {
            return false;
        }
        Historico other = (Historico) object;
        if ((this.históricoId == null && other.históricoId != null) || (this.históricoId != null && !this.históricoId.equals(other.históricoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sacweb.model.Historico[ hist\u00f3ricoId=" + históricoId + " ]";
    }
    
}
