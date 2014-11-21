/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sacweb.controller.pessoa;

import br.com.sacweb.basic.BasicDao;
import br.com.sacweb.model.Pessoa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author JM
 */
@ManagedBean
@ViewScoped
public class ListaPessoaController implements Serializable {

    public List<Pessoa> listPessoa = new ArrayList<Pessoa>();
    private BasicDao<Pessoa> basicDaoPessoa = new BasicDao<Pessoa>();

    public List<Pessoa> getListPessoa() {
        listPessoa = basicDaoPessoa.list(Pessoa.class);
        return listPessoa;
    }

    public ListaPessoaController() {

    }

    @PreDestroy
    public void destroy() {

    }
}
