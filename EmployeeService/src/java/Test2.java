import Services.EmployeeService;
import Services.ServiceService;
import entities.Employee;
import entities.Service;
import java.util.Date;
import java.util.List; // Ajout de l'import manquant pour List

public class Test2 {

    public static void main(String[] args) {
        // Initialiser les services
        EmployeeService employeeService = new EmployeeService(); // Correction du nom de la variable employeService à employeeService
        ServiceService serviceService = new ServiceService();

        // Créer de nouveaux services
        Service itService = new Service("IT");
        serviceService.create(itService);

        Service rhService = new Service("Rh");
        serviceService.create(rhService);

        Service adService = new Service("administration");
        serviceService.create(adService);
        
        Service chefService = null;
        Service autreService = new Service("Autre", (List<Employee>) chefService);
        serviceService.create(autreService);

        // Créer de nouveaux employés
        Employee nouvelEmploye = new Employee("akherraz", "sana", new Date(), "john_doe.jpg", itService, null); // Correction du nom de la variable nouveauService à itService
        employeeService.create(nouvelEmploye);

        Employee deuxEmploye = new Employee("salma", "Fati", new Date(), "john_doe.jpg", rhService, null); // Correction du nom de la variable deuxService à rhService
        employeeService.create(deuxEmploye);

        // Récupérer et afficher les informations
        System.out.println("Employés:");
        List<Employee> employes = employeeService.getAll(); // Correction du nom de la variable employeService à employeeService
        for (Employee e : employes) {
            System.out.println(e.getNom() + " " + e.getPrenom());
        }

        System.out.println("\nServices:");
        List<Service> services = serviceService.getAll();
        for (Service s : services) {
            System.out.println(s.getNom());
            for (Employee e : s.getEmployees()) { // Correction du nom de la méthode getEmployes à getEmployees
                System.out.println("\t" + e.getNom());
            }
        }

        // Mettre à jour et supprimer des données...
        // Par exemple, employeService.update(employeModifie), serviceService.delete(serviceASupprimer), etc.
    }
}
