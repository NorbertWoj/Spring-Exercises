package app;

import app.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class DeleteApp {
    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();

        int idEmployee = 8;
        String delete = "DELETE Employee AS e WHERE e.idEmployee=:idEmployee";

        session.beginTransaction();

        Query query = session.createQuery(delete);
        query.setParameter("idEmployee", idEmployee);
        query.executeUpdate();

        session.getTransaction().commit();

        factory.close();

    }
}