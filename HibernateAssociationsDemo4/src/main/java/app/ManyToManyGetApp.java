package app;

import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ManyToManyGetApp {

    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);
        conf.addAnnotatedClass(Property.class);
        conf.addAnnotatedClass(Department.class);
        conf.addAnnotatedClass(Employee.class);
        conf.addAnnotatedClass(Training.class);

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();

        int id = 1;
        int idEmployee = 124;
        int idEmployee2 = 125;


        session.beginTransaction();

        Training training = new Training("java training");

        Employee employee1 = session.get(Employee.class, idEmployee);
        Employee employee2 = session.get(Employee.class, idEmployee2);

        training.addEmployee(employee1);
        training.addEmployee(employee2);

        session.persist(training);

        System.out.println("==============");

        String getTraining = "FROM Training";

        Query query = session.createQuery(getTraining);

        List<Training> resultList = query.getResultList();

        for (Training training2 : resultList) {
            System.out.println("\n" + training2);
            for (Employee employee : training2.getEmployees()) {
                System.out.println("- " + employee);
            }
        }

        System.out.println("==========");

        Training training3 = session.get(Training.class, id);


        System.out.println(training3);

        for (Employee employee : training3.getEmployees()) {
            System.out.println("- " + employee);
        }


        session.getTransaction().commit();

        factory.close();

    }

}