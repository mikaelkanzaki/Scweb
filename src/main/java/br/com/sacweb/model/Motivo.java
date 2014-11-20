/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sacweb.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JM
 */
@Entity
@Table(name = "motivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Motivo.findAll", query = "SELECT m FROM Motivo m"),
    @NamedQuery(name = "Motivo.findByMotivoId", query = "SELECT m FROM Motivo m WHERE m.motivoId = :motivoId"),
    @NamedQuery(name = "Motivo.findByMotivoNome", query = "SELECT m FROM Motivo m WHERE m.motivoNome = :motivoNome"),
    @NamedQuery(name = "Motivo.findByMotivoStatus", query = "SELECT m FROM Motivo m WHERE m.motivoStatus = :motivoStatus")})
public class Motivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "motivo_id")
    private Integer motivoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "motivo_nome")
    private String motivoNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "motivo_status")
    private String motivoStatus;

    public Motivo() {
    }

    public Motivo(Integer motivoId) {
        this.motivoId = motivoId;
    }

    public Motivo(Integer motivoId, String motivoNome, String motivoStatus) {
        this.motivoId = motivoId;
        this.motivoNome = motivoNome;
        this.motivoStatus = motivoStatus;
    }

    public Integer getMotivoId() {
        return motivoId;
    }

    public void setMotivoId(Integer motivoId) {
        this.motivoId = motivoId;
    }

    public String getMotivoNome() {
        return motivoNome;
    }

    public void setMotivoNome(String motivoNome) {
        this.motivoNome = motivoNome;
    }

    public String getMotivoStatus() {
        return motivoStatus;
    }

    public void setMotivoStatus(String motivoStatus) {
        this.motivoStatus = motivoStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (motivoId != null ? motivoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Motivo)) {
            return false;
        }
        Motivo other = (Motivo) object;
        if ((this.motivoId == null && other.motivoId != null) || (this.motivoId != null && !this.motivoId.equals(other.motivoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sacweb.model.Motivo[ motivoId=" + motivoId + " ]";
    }
    
}
