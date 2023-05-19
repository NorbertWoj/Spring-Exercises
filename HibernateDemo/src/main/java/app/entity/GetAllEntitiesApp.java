package app.entity;

import app.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GetAllEntitiesApp {
    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        List<Employee> resultList = session.createQuery("from Employee").getResultList();

        for (Employee employee : resultList) {
            System.out.println(employee);
        }

        session.getTransaction().commit();

        factory.close();

    }

}
