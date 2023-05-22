package app;

import app.entity.Company;
import app.entity.CompanyDetail;
import app.entity.Property;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class OneToManyHQLApp {

    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);
        conf.addAnnotatedClass(Property.class);

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();

        String getCompany = "SELECT c.name FROM Property AS p JOIN p.company As c WHERE p.city='Sevilla'";
        String getCompany2 = "SELECT c.name FROM Property AS p JOIN p.company AS c JOIN c.companyDetail AS cd WHERE p.city='Barcelona' AND cd.residence='Switzerland'";
        String getCompany3 = "SELECT c.name FROM Company AS c WHERE size(c.properties) > 4";

        session.beginTransaction();

        Query query = session.createQuery(getCompany);
        List<String> resultList = query.getResultList();
        for (String result : resultList) {
            System.out.println(result);
        }

        System.out.println("===============");

        Query query2 = session.createQuery(getCompany2);
        List<String> resultList2 = query2.getResultList();
        for (String result : resultList2) {
            System.out.println(result);
        }

        System.out.println("===============");

        Query query3 = session.createQuery(getCompany3);
        List<String> resultList3 = query3.getResultList();
        for (String result : resultList3) {
            System.out.println(result);
        }

        session.getTransaction().commit();

        factory.close();

    }

}