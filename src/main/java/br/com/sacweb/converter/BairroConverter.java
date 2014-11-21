/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sacweb.converter;

import br.com.sacweb.model.Bairro;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author JM
 */
@FacesConverter(value = "bairroConverter")
public class BairroConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            //return new Bairro(1, "Belém");
            return (Bairro) uiComponent.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Bairro) {
            Bairro entity = (Bairro) value;
            if (entity != null && entity instanceof Bairro && entity.getBairroId() != null) {
                uiComponent.getAttributes().put(entity.getBairroId().toString(), entity);
                return entity.getBairroId().toString();
            }
        }
        return "";
    }
}
