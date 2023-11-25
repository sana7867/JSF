/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Tecra
 */
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String prenom; // Correction du nom de la variable Prenom à prenom
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNaissance;
    private String photo;
    
    @ManyToOne
    private Service service;
    
   
     @ManyToOne
    private Employee chef; // Add this line to represent the chef of the service

    public List<Employee> getEmployees() {
        return employees;
    }

   

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @OneToMany(mappedBy = "service", fetch = FetchType.EAGER)
    private List<Employee> employees;

    public Employee getChef() {
        return chef;
    }

    public void setChef(Employee chef) {
        this.chef = chef;
    }

    

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Employee() {
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Employee(String nom, String prenom, Date dateNaissance, String photo, Service service, Employee chef) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.photo = photo;
        this.service = service;
        this.chef = chef;
    }

    public Employee(String nom, String prenom, Date dateNaissance, String photo) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.photo = photo;
    }
    
    
}
