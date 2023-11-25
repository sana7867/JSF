/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import Services.EmployeeService;
import Services.ServiceService;
import entities.Employee;
import entities.Service;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import static jdk.nashorn.internal.runtime.Debug.id;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author Tecra
 */
@ManagedBean(name = "employeeBean")
@SessionScoped
public class EmployeeBean implements Serializable{
//traite les champs web
    private Employee employee;

    private Service service;
    private List<Employee> employees;
    private List<Employee> employeesBetweenDates;
    private EmployeeService employeeService;
    private ServiceService serviceService;
    private static ChartModel barModel;
    private Date date1;
    private Date date2;

    public EmployeeBean() {
        employee = new Employee();
        employeeService = new EmployeeService();
        serviceService = new ServiceService();

    }

    public List<Employee> getEmployees() {
        if (employees == null) {
            employees = employeeService.getAll();
        }
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public String onCreateAction() {
        employeeService.create(employee);
        employee = new Employee();
        return null;
    }

    public String onDeleteAction() {

        employeeService.delete(employeeService.getById((int) employee.getId().longValue()));
        return null;
    }

    public List<Employee> serviceLoad() {
        for (Employee m : employeeService.getAll()) {
            if (m.getService().equals(service)) {
                employees.add(m);
            }
        }
        return employees;

    }

    public void load() {
        System.out.println(service.getNom());
        service = serviceService.getById((int) service.getId().longValue());
        getEmployees();
    }

    public void onEdit(RowEditEvent event) {
        employee = (Employee) event.getObject();
        Service service = serviceService.getById((int) this.employee.getService().getId().longValue());
        employee.setService(service);
        employee.getService().setNom(service.getNom());
        employeeService.update(employee);
    }

    public void onCancel(RowEditEvent event) {
    }

    public ChartModel getBarModel() {
        return barModel;
    }

    public ChartModel initBarModel() {
        CartesianChartModel model = new CartesianChartModel();
        ChartSeries employees = new ChartSeries();
        employees.setLabel("employees");
        model.setAnimate(true);
        for (Object[] m : employeeService.nbemployee()) {
            employees.set(m[1], Integer.parseInt(m[0].toString()));
        }
        model.addSeries(employees);

        return model;
    }

   

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<Employee> getEmployeesBetweenDates() {
        return employeesBetweenDates;
    }

    public void setEmployeesBetweenDates(List<Employee> employeesBetweenDates) {
        this.employeesBetweenDates = employeesBetweenDates;
    }

}

