package app;

import entity.Company;
import entity.CompanyDetail;
import entity.Property;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchTypeApp {

    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);
        conf.addAnnotatedClass(Property.class);

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();

        int id = 22;

        session.beginTransaction();

        Company company = session.get(Company.class, id);
        System.out.println(company);
        for (Property property : company.getProperties()) {
            System.out.println(property);
        }

        session.getTransaction().commit();

        factory.close();

    }

}