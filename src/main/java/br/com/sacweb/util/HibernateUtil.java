/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sacweb.util;

import br.com.sacweb.model.Atividade;
import br.com.sacweb.model.Bairro;
import br.com.sacweb.model.Cargo;
import br.com.sacweb.model.Cidade;
import br.com.sacweb.model.Disciplina;
import br.com.sacweb.model.Estado;
import br.com.sacweb.model.Formacao;
import br.com.sacweb.model.Frequencia;
import br.com.sacweb.model.Funcao;
import br.com.sacweb.model.Funcionario;
import br.com.sacweb.model.Gratificacao;
import br.com.sacweb.model.Historico;
import br.com.sacweb.model.Investidura;
import br.com.sacweb.model.Local;
import br.com.sacweb.model.Log;
import br.com.sacweb.model.Lotacao;
import br.com.sacweb.model.Motivo;
import br.com.sacweb.model.Observacao;
import br.com.sacweb.model.Periodo;
import br.com.sacweb.model.Pessoa;
import br.com.sacweb.model.Serie;
import br.com.sacweb.model.Tabelas;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author JM
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new AnnotationConfiguration()
                    .configure()
                    .addAnnotatedClass(Atividade.class)
                    .addAnnotatedClass(Bairro.class)
                    .addAnnotatedClass(Cargo.class)
                    .addAnnotatedClass(Cidade.class)
                    .addAnnotatedClass(Disciplina.class)
                    .addAnnotatedClass(Estado.class)
                    .addAnnotatedClass(Formacao.class)
                    .addAnnotatedClass(Frequencia.class)
                    .addAnnotatedClass(Funcao.class)
                    .addAnnotatedClass(Funcionario.class)
                    .addAnnotatedClass(Gratificacao.class)
                    .addAnnotatedClass(Historico.class)
                    .addAnnotatedClass(Investidura.class)
                    .addAnnotatedClass(Local.class)
                    .addAnnotatedClass(Log.class)
                    .addAnnotatedClass(Lotacao.class)
                    .addAnnotatedClass(Motivo.class)
                    .addAnnotatedClass(Observacao.class)
                    .addAnnotatedClass(Periodo.class)
                    .addAnnotatedClass(Pessoa.class)
                    .addAnnotatedClass(Serie.class)
                    .addAnnotatedClass(Tabelas.class)
                    .buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
