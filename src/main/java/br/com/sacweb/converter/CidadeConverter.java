/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sacweb.converter;



/**
 *
 * @author JM
 */
import br.com.sacweb.model.Cidade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
 
@FacesConverter(value="cidadeConverter")
public class CidadeConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            //return new Cidade(1, "Belém");
            return (Cidade) uiComponent.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Cidade) {
            Cidade entity= (Cidade) value;
            if (entity != null && entity instanceof Cidade && entity.getCidadeId() != null) {
                uiComponent.getAttributes().put( entity.getCidadeId().toString(), entity);
                return entity.getCidadeId().toString();
            }
        }
        return "";
    }
}
