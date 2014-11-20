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
@Table(name = "pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findByPessoaId", query = "SELECT p FROM Pessoa p WHERE p.pessoaId = :pessoaId"),
    @NamedQuery(name = "Pessoa.findByPessoaNome", query = "SELECT p FROM Pessoa p WHERE p.pessoaNome = :pessoaNome"),
    @NamedQuery(name = "Pessoa.findByPessoaRg", query = "SELECT p FROM Pessoa p WHERE p.pessoaRg = :pessoaRg"),
    @NamedQuery(name = "Pessoa.findByPessoargEmissor", query = "SELECT p FROM Pessoa p WHERE p.pessoargEmissor = :pessoargEmissor"),
    @NamedQuery(name = "Pessoa.findByPessoaCpf", query = "SELECT p FROM Pessoa p WHERE p.pessoaCpf = :pessoaCpf"),
    @NamedQuery(name = "Pessoa.findByPessoaTitulo", query = "SELECT p FROM Pessoa p WHERE p.pessoaTitulo = :pessoaTitulo"),
    @NamedQuery(name = "Pessoa.findByPessoatituloZona", query = "SELECT p FROM Pessoa p WHERE p.pessoatituloZona = :pessoatituloZona"),
    @NamedQuery(name = "Pessoa.findByPessoatituloSecao", query = "SELECT p FROM Pessoa p WHERE p.pessoatituloSecao = :pessoatituloSecao"),
    @NamedQuery(name = "Pessoa.findByPessoaLogradouro", query = "SELECT p FROM Pessoa p WHERE p.pessoaLogradouro = :pessoaLogradouro"),
    @NamedQuery(name = "Pessoa.findByPessoaNumero", query = "SELECT p FROM Pessoa p WHERE p.pessoaNumero = :pessoaNumero"),
    @NamedQuery(name = "Pessoa.findByPessoaCep", query = "SELECT p FROM Pessoa p WHERE p.pessoaCep = :pessoaCep"),
    @NamedQuery(name = "Pessoa.findByPessoaTelefone1", query = "SELECT p FROM Pessoa p WHERE p.pessoaTelefone1 = :pessoaTelefone1"),
    @NamedQuery(name = "Pessoa.findByPessoaTelefone2", query = "SELECT p FROM Pessoa p WHERE p.pessoaTelefone2 = :pessoaTelefone2"),
    @NamedQuery(name = "Pessoa.findByPessoaStatus", query = "SELECT p FROM Pessoa p WHERE p.pessoaStatus = :pessoaStatus")})
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pessoa_id")
    private Integer pessoaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "pessoa_nome")
    private String pessoaNome;
    @Size(max = 20)
    @Column(name = "pessoa_rg")
    private String pessoaRg;
    @Size(max = 20)
    @Column(name = "pessoa_rgEmissor")
    private String pessoargEmissor;
    @Size(max = 11)
    @Column(name = "pessoa_cpf")
    private String pessoaCpf;
    @Size(max = 12)
    @Column(name = "pessoa_titulo")
    private String pessoaTitulo;
    @Size(max = 5)
    @Column(name = "pessoa_tituloZona")
    private String pessoatituloZona;
    @Size(max = 5)
    @Column(name = "pessoa_tituloSecao")
    private String pessoatituloSecao;
    @Size(max = 50)
    @Column(name = "pessoa_logradouro")
    private String pessoaLogradouro;
    @Size(max = 20)
    @Column(name = "pessoa_numero")
    private String pessoaNumero;
    @Size(max = 8)
    @Column(name = "pessoa_cep")
    private String pessoaCep;
    @Size(max = 11)
    @Column(name = "pessoa_telefone1")
    private String pessoaTelefone1;
    @Size(max = 11)
    @Column(name = "pessoa_telefone2")
    private String pessoaTelefone2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "pessoa_status")
    private String pessoaStatus;
    @JoinColumn(name = "pessoa_estado", referencedColumnName = "estado_id")
    @ManyToOne
    private Estado pessoaEstado;
    @JoinColumn(name = "pessoa_cidade", referencedColumnName = "cidade_id")
    @ManyToOne
    private Cidade pessoaCidade;
    @JoinColumn(name = "pessoa_bairro", referencedColumnName = "bairro_id")
    @ManyToOne
    private Bairro pessoaBairro;
    @OneToMany(mappedBy = "funcionarioPessoa")
    private List<Funcionario> funcionarioList;

    public Pessoa() {
    }

    public Pessoa(Integer pessoaId) {
        this.pessoaId = pessoaId;
    }

    public Pessoa(Integer pessoaId, String pessoaNome, String pessoaStatus) {
        this.pessoaId = pessoaId;
        this.pessoaNome = pessoaNome;
        this.pessoaStatus = pessoaStatus;
    }

    public Integer getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Integer pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getPessoaNome() {
        return pessoaNome;
    }

    public void setPessoaNome(String pessoaNome) {
        this.pessoaNome = pessoaNome;
    }

    public String getPessoaRg() {
        return pessoaRg;
    }

    public void setPessoaRg(String pessoaRg) {
        this.pessoaRg = pessoaRg;
    }

    public String getPessoargEmissor() {
        return pessoargEmissor;
    }

    public void setPessoargEmissor(String pessoargEmissor) {
        this.pessoargEmissor = pessoargEmissor;
    }

    public String getPessoaCpf() {
        return pessoaCpf;
    }

    public void setPessoaCpf(String pessoaCpf) {
        this.pessoaCpf = pessoaCpf;
    }

    public String getPessoaTitulo() {
        return pessoaTitulo;
    }

    public void setPessoaTitulo(String pessoaTitulo) {
        this.pessoaTitulo = pessoaTitulo;
    }

    public String getPessoatituloZona() {
        return pessoatituloZona;
    }

    public void setPessoatituloZona(String pessoatituloZona) {
        this.pessoatituloZona = pessoatituloZona;
    }

    public String getPessoatituloSecao() {
        return pessoatituloSecao;
    }

    public void setPessoatituloSecao(String pessoatituloSecao) {
        this.pessoatituloSecao = pessoatituloSecao;
    }

    public String getPessoaLogradouro() {
        return pessoaLogradouro;
    }

    public void setPessoaLogradouro(String pessoaLogradouro) {
        this.pessoaLogradouro = pessoaLogradouro;
    }

    public String getPessoaNumero() {
        return pessoaNumero;
    }

    public void setPessoaNumero(String pessoaNumero) {
        this.pessoaNumero = pessoaNumero;
    }

    public String getPessoaCep() {
        return pessoaCep;
    }

    public void setPessoaCep(String pessoaCep) {
        this.pessoaCep = pessoaCep;
    }

    public String getPessoaTelefone1() {
        return pessoaTelefone1;
    }

    public void setPessoaTelefone1(String pessoaTelefone1) {
        this.pessoaTelefone1 = pessoaTelefone1;
    }

    public String getPessoaTelefone2() {
        return pessoaTelefone2;
    }

    public void setPessoaTelefone2(String pessoaTelefone2) {
        this.pessoaTelefone2 = pessoaTelefone2;
    }

    public String getPessoaStatus() {
        return pessoaStatus;
    }

    public void setPessoaStatus(String pessoaStatus) {
        this.pessoaStatus = pessoaStatus;
    }

    public Estado getPessoaEstado() {
        return pessoaEstado;
    }

    public void setPessoaEstado(Estado pessoaEstado) {
        this.pessoaEstado = pessoaEstado;
    }

    public Cidade getPessoaCidade() {
        return pessoaCidade;
    }

    public void setPessoaCidade(Cidade pessoaCidade) {
        this.pessoaCidade = pessoaCidade;
    }

    public Bairro getPessoaBairro() {
        return pessoaBairro;
    }

    public void setPessoaBairro(Bairro pessoaBairro) {
        this.pessoaBairro = pessoaBairro;
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
        hash += (pessoaId != null ? pessoaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.pessoaId == null && other.pessoaId != null) || (this.pessoaId != null && !this.pessoaId.equals(other.pessoaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sacweb.model.Pessoa[ pessoaId=" + pessoaId + " ]";
    }
    
}
