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
@Table(name = "disciplina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disciplina.findAll", query = "SELECT d FROM Disciplina d"),
    @NamedQuery(name = "Disciplina.findByDisciplinaId", query = "SELECT d FROM Disciplina d WHERE d.disciplinaId = :disciplinaId"),
    @NamedQuery(name = "Disciplina.findByDisciplinaNome", query = "SELECT d FROM Disciplina d WHERE d.disciplinaNome = :disciplinaNome"),
    @NamedQuery(name = "Disciplina.findByDisciplinaStatus", query = "SELECT d FROM Disciplina d WHERE d.disciplinaStatus = :disciplinaStatus")})
public class Disciplina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "disciplina_id")
    private Integer disciplinaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "disciplina_nome")
    private String disciplinaNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "disciplina_status")
    private String disciplinaStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lotacaoDisciplina")
    private List<Lotacao> lotacaoList;

    public Disciplina() {
    }

    public Disciplina(Integer disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

    public Disciplina(Integer disciplinaId, String disciplinaNome, String disciplinaStatus) {
        this.disciplinaId = disciplinaId;
        this.disciplinaNome = disciplinaNome;
        this.disciplinaStatus = disciplinaStatus;
    }

    public Integer getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(Integer disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

    public String getDisciplinaNome() {
        return disciplinaNome;
    }

    public void setDisciplinaNome(String disciplinaNome) {
        this.disciplinaNome = disciplinaNome;
    }

    public String getDisciplinaStatus() {
        return disciplinaStatus;
    }

    public void setDisciplinaStatus(String disciplinaStatus) {
        this.disciplinaStatus = disciplinaStatus;
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
        hash += (disciplinaId != null ? disciplinaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disciplina)) {
            return false;
        }
        Disciplina other = (Disciplina) object;
        if ((this.disciplinaId == null && other.disciplinaId != null) || (this.disciplinaId != null && !this.disciplinaId.equals(other.disciplinaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sacweb.model.Disciplina[ disciplinaId=" + disciplinaId + " ]";
    }
    
}
