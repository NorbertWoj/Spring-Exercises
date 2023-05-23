package app;

import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManyDeleteApp {

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


        int idEmployee = 124;
        int idTraining = 4;

        session.beginTransaction();

        Employee employee = session.get(Employee.class, idEmployee);

        session.delete(employee);

        Training training = session.get(Training.class, idTraining);

        session.delete(training);


        session.getTransaction().commit();

        factory.close();

    }

}