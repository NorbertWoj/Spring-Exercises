package app;

import app.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class UpdateApp {
    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();

        int idEmployee = 111;
        int salary = 11111;
        String update = "UPDATE Employee AS e SET e.salary=:salary WHERE e.idEmployee=:idEmployee";

        session.beginTransaction();

        Query query = session.createQuery(update);
        query.setParameter("salary", salary);
        query.setParameter("idEmployee", idEmployee);
        query.executeUpdate();

        session.getTransaction().commit();

        factory.close();

    }
}