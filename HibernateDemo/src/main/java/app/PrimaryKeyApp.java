package app;

import app.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyApp {
    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();

        Employee employee = new Employee();
        employee.setFirstName("James");
        employee.setLastName("Smith");
        employee.setSalary(10000);

        Employee employee2 = new Employee();
        employee2.setFirstName("John");
        employee2.setLastName("Johnson");
        employee2.setSalary(10000);

        Employee employee3 = new Employee();
        employee3.setFirstName("Robert");
        employee3.setLastName("Williams");
        employee3.setSalary(10000);

        session.beginTransaction();
        session.save(employee);
        session.save(employee2);
        session.save(employee3);
        session.getTransaction().commit();

        factory.close();
    }
}
