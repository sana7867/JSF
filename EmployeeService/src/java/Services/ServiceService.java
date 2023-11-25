/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Util.HibernateUtil;
import dao.IDao;
import entities.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Tecra
 */
public class ServiceService extends AbstractFacad<Service>{

   

    @Override
    protected Class<Service> getEntityClass() {
        return Service.class;
    }
}
    
    

