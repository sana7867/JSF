/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Util.HibernateUtil;
import dao.IDao;
import entities.Employee;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Tecra
 */
public class EmployeeService extends AbstractFacad<Employee>{

   

    @Override
    protected Class<Employee> getEntityClass() {
    return Employee.class;
    }
    public List<Object[]> nbemployee(){
        List<Object[]> employees = null;
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        employees  = session.createQuery("select count(e.nom), e.nom from Employee e group by e.nom").list();
        session.getTransaction().commit();
        return employees;
    }
    
    
    
}
