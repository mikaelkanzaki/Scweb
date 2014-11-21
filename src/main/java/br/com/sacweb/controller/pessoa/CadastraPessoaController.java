/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sacweb.controller.pessoa;

import br.com.sacweb.basic.BasicDao;
import br.com.sacweb.model.Bairro;
import br.com.sacweb.model.Cidade;
import br.com.sacweb.model.Estado;
import br.com.sacweb.model.Funcionario;
import br.com.sacweb.model.Pessoa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author JM
 */
@ManagedBean
@ViewScoped
public class CadastraPessoaController implements Serializable {
    
    //<editor-fold defaultstate="collapsed" desc="Objetos">
    public Pessoa pessoa = new Pessoa();
    public Estado estado = new Estado();
    public Cidade cidade = new Cidade();
    public Bairro bairro = new Bairro();
    public Funcionario funcionario = new Funcionario();
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Listas">
    public List<Estado> listaEstado = new ArrayList<Estado>();
    public List<Cidade> listaCidade = new ArrayList<Cidade>();
    public List<Bairro> listaBairro = new ArrayList<Bairro>();
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="BasicDao">
    private BasicDao<Pessoa> basicDaoPessoa = new BasicDao<Pessoa>();
    private BasicDao<Funcionario> basicDaoFuncionario = new BasicDao<Funcionario>();
    private BasicDao<Estado> basicDaoEstado = new BasicDao<Estado>();
    private BasicDao<Cidade> basicDaoCidade = new BasicDao<Cidade>();
    private BasicDao<Bairro> basicDaoBairro = new BasicDao<Bairro>();
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public List<Estado> getListaEstado() {
        return listaEstado;
    }

    public List<Cidade> getListaCidade() {
        return listaCidade;
    }

    public List<Bairro> getListaBairro() {
        return listaBairro;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    //</editor-fold>
    
    public CadastraPessoaController() {
        constroiEstado();
    }
    
    public void mudaEstado(ValueChangeEvent event) {
        Estado value = (Estado) event.getNewValue();

        if (value != null) {
            constroiCidade(value);
        }

    }

    public void mudaCidade(ValueChangeEvent event) {
        Cidade value = (Cidade) event.getNewValue();

        if (value != null) {
            constroiBairro(value);
        }

    }
    
    public void constroiEstado() {
        listaEstado = basicDaoEstado.list(Estado.class);
    }
    public void constroiCidade(Estado estado) {
        listaCidade = basicDaoCidade.listById("Cidade.findByIdEstado", "estadoId",estado.getEstadoId(), Cidade.class);
    }

    public void constroiBairro(Cidade cidade) {
        listaBairro = basicDaoBairro.listById("Bairro.findByIdCidade", "cidadeId", cidade.getCidadeId(), Bairro.class);
    }
    
    @PreDestroy
    public void destroy() {

    }
}
