package app;

import app.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class OrderByApp {
    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        String orderBy = "SELECT e.firstName, e.lastName FROM Employee AS e ORDER BY e.firstName";
        String orderBy2 = "SELECT e.firstName, e.lastName FROM Employee AS e ORDER BY e.firstName DESC";
        String orderBy3 = "SELECT e.firstName, e.lastName, e.salary FROM Employee AS e ORDER BY e.salary ASC";

        Query query = session.createQuery(orderBy);

        List<Object[]> resultList = query.getResultList();

        for (Object[] values : resultList) {
            System.out.println("FirstName: " + values[0] + ", lastName: " + values[1]);
        }

        System.out.println("==================");

        Query query2 = session.createQuery(orderBy2);

        List<Object[]> resultList2 = query2.getResultList();

        for (Object[] values : resultList2) {
            System.out.println("FirstName: " + values[0] + ", lastName: " + values[1]);
        }

        System.out.println("==================");

        Query query3 = session.createQuery(orderBy3);

        List<Object[]> resultList3 = query3.getResultList();

        for (Object[] values : resultList3) {
            System.out.println("FirstName: " + values[0] + ", lastName: " + values[1] + ", salary: " + values[2]);
        }


        session.getTransaction().commit();

        factory.close();

    }
}