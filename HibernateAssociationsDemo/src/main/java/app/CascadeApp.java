package app;

import app.entity.Company;
import app.entity.CompanyDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CascadeApp {

    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();

        Company company = new Company("Orlen", 2000000000);
        CompanyDetail detail = new CompanyDetail("Poland", 16000);
        company.setCompanyDetail(detail);

        session.beginTransaction();
//        session.save(company);
        session.persist(company);
        session.getTransaction().commit();

        factory.close();

    }

}