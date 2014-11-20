/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sacweb.controller.session;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author mikael.cardoso
 */
@SessionScoped
@ManagedBean
public class NavigationController implements Serializable {

    public NavigationController() {
    }

    public void goTo(String path) throws IOException {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect(context.getRequestContextPath()+"/"+path+"?faces-redirect=true");
        //return "/pages/"+path+"faces-redirect=true";

    }
}
