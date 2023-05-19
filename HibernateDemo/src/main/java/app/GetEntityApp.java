package app;

import app.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetEntityApp {
    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();

        Employee employee = new Employee();
        employee.setFirstName("William");
        employee.setLastName("Jones");
        employee.setSalary(10000);

        session.beginTransaction();

        Integer id = (Integer) session.save(employee);

        session.getTransaction().commit();
        session = factory.getCurrentSession();
        session.beginTransaction();

        Employee retrivedEmployee = session.get(Employee.class, id);

        session.getTransaction().commit();
        System.out.println("Dane pracownika: " + retrivedEmployee);

        factory.close();

    }
}
