package app;

import app.entity.Company;
import app.entity.CompanyDetail;
import app.entity.Property;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class OneToManyDeleteApp {

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

        for (Property property : company.getProperties()) {
            if ("Cracow".equals(property.getCity())) {
                session.delete(property);
            }
        }

        System.out.println("=========");

        int idToDelete = 2;
        Property property = session.get(Property.class, idToDelete);
        session.delete(property);

        session.getTransaction().commit();

        factory.close();

    }

}