package app;

import app.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class FromApp {
    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        String from = "FROM Employee";
        String from2 = "from Employee";
        String from3 = "FROM app.entity.Employee";

        Query query = session.createQuery(from);

        List<Employee> list = query.getResultList();

        for (Employee employee : list) {
            System.out.println(employee);
        }

        System.out.println("---------------");

        Query query2 = session.createQuery(from2);

        List<Employee> list2 = query2.getResultList();

        for (Employee employee : list2) {
            System.out.println(employee);
        }

        System.out.println("---------------");

        Query query3 = session.createQuery(from3);

        List<Employee> list3 = query3.getResultList();

        for (Employee employee : list3) {
            System.out.println(employee);
        }

        session.getTransaction().commit();

        factory.close();

    }
}
