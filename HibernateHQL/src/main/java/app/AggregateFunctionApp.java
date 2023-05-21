package app;

import app.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class AggregateFunctionApp {
    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        String avg = "SELECT AVG(e.salary) FROM Employee e";
        String sum = "SELECT SUM(e.salary) FROM Employee e";
        String min = "SELECT MIN(e.salary) FROM Employee e";
        String max = "SELECT MAX(e.salary) FROM Employee e";
        String count = "SELECT COUNT(e.salary) FROM Employee e";

        Query query = session.createQuery(avg);

        Double result = (Double) query.getSingleResult();
        System.out.println("avg = " + result);

        System.out.println("==================");

        Query query2 = session.createQuery(sum);

        Long result2 = (Long) query2.getSingleResult();
        System.out.println("sum = " + result2);

        System.out.println("==================");

        Query query3 = session.createQuery(min);
        Integer result3 = (Integer) query3.getSingleResult();
        System.out.println("min = " + result3);

        System.out.println("==================");

        Query query4 = session.createQuery(max);
        Integer result4 = (Integer) query4.getSingleResult();
        System.out.println("max = " + result4);

        System.out.println("==================");

        Query query5 = session.createQuery(count);
        Long result5 = (Long) query5.getSingleResult();
        System.out.println("count = " + result5);

        session.getTransaction().commit();

        factory.close();

    }
}