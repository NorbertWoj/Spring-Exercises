package app;

import app.entity.Company;
import app.entity.CompanyDetail;
import app.entity.Property;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class OneToManySaveApp {

    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);
        conf.addAnnotatedClass(Property.class);

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();

        String getCompany = "SELECT c FROM Company AS c WHERE c.name='KGHM'";

        session.beginTransaction();

        Query query = session.createQuery(getCompany);
        Company company = (Company) query.getSingleResult();
        System.out.println(company);

        Property property = new Property("Warsaw", 40);
        Property property2 = new Property("Cracow", 30);

        company.addProperty(property);
        company.addProperty(property2);

        session.persist(property);
        session.persist(property2);

        session.getTransaction().commit();

        factory.close();

    }

}