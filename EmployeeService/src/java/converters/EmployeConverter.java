/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

/**
 *
 * @author Tecra
 */

 
import Services.EmployeeService;
import entities.Employee;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;


@FacesConverter("employeConverter")
public class EmployeConverter implements Converter {

    @Inject
    private EmployeeService employeService; // Or however you obtain your service

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            return employeService.getById((int) Long.parseLong(value));
        } catch (NumberFormatException e) {
            throw new ConverterException("The value is not a valid ID: " + value, e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Employee) {
            Long id = ((Employee) value).getId();
            return (id != null) ? String.valueOf(id) : null;
        } else {
            return null;
        }
    }
}
    

