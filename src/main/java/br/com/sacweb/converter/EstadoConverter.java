/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sacweb.converter;

import br.com.sacweb.model.Estado;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author JM
 */
@FacesConverter(value="estadoConverter")
public class EstadoConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            //return new Estado(1, "Belém");
            return (Estado) uiComponent.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Estado) {
            Estado entity= (Estado) value;
            if (entity != null && entity instanceof Estado && entity.getEstadoId() != null) {
                uiComponent.getAttributes().put( entity.getEstadoId().toString(), entity);
                return entity.getEstadoId().toString();
            }
        }
        return "";
    }
}
