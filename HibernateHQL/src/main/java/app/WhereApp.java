package app;

import app.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class WhereApp {
    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        String where = "FROM Employee WHERE firstName='Steven'";
        String where2 = "FROM Employee WHERE salary >= 12000";
        String where3 = "FROM Employee WHERE salary < 3000 OR salary > 13000";
        String where4 = "FROM Employee WHERE salary IS NULL";
        String where5 = "FROM Employee WHERE lastName IN ('Atkinson', 'Seo')";

        Query query = session.createQuery(where);

        List<Employee> list = query.getResultList();

        for (Employee employee : list) {
            System.out.println(employee);
        }

        System.out.println("==================");

        Query query2 = session.createQuery(where2);

        List<Employee> list2 = query2.getResultList();

        for (Employee employee : list2) {
            System.out.println(employee);
        }

        System.out.println("==================");

        Query query3 = session.createQuery(where3);

        List<Employee> list3 = query3.getResultList();

        for (Employee employee : list3) {
            System.out.println(employee);
        }

        System.out.println("==================");

        Query query4 = session.createQuery(where4);

        List<Employee> list4 = query4.getResultList();

        for (Employee employee : list4) {
            System.out.println(employee);
        }

        System.out.println("==================");

        Query query5 = session.createQuery(where5);

        List<Employee> list5 = query5.getResultList();

        for (Employee employee : list5) {
            System.out.println(employee);
        }

        session.getTransaction().commit();

        factory.close();

    }
}
