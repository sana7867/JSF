/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Tecra
 */
@Entity
public class Service {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;

    @OneToMany(mappedBy = "service") // Correction du nom de la variable "employees" à "employee" dans mappedBy
    private List<Employee> employees;
   

    
    public Service() {
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Service(String nom) {
        this.nom = nom;
    }

    public Service(String nom, List<Employee> employees) {
        this.nom = nom;
        this.employees = employees;
    }
    
    
    
}
