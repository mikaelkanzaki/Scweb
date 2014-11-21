/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sacweb.controller.funcionario;

import br.com.sacweb.basic.BasicDao;
import br.com.sacweb.model.Funcionario;
import java.io.Serializable;
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
public class ListaFuncionarioController implements Serializable {
    
    public List<Funcionario> listFuncionario;
    BasicDao<Funcionario> basicDaoFuncionario = new BasicDao<Funcionario>();

    public List<Funcionario> getListFuncionario() {
        listFuncionario = basicDaoFuncionario.list(Funcionario.class);
        return listFuncionario;
    }
    
    public ListaFuncionarioController(){
    }
    
    
    @PreDestroy
    public void destroy(){
    }
}
