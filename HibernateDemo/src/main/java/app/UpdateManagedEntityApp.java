package app;

import app.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateManagedEntityApp {
    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Employee employee = session.get(Employee.class, 16);
        employee.setFirstName("Joe");
        session.getTransaction().commit();
        System.out.println("Zaktualizowano pracownika: " + employee);

        factory.close();

    }

}
