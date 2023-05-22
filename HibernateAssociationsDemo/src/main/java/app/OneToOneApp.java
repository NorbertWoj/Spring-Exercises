package app;

import app.entity.Company;
import app.entity.CompanyDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneApp {

    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();

        Company company = new Company("Xyz", 10000000);
        CompanyDetail detail = new CompanyDetail("Poland", 150);
        company.setCompanyDetail(detail);

        session.beginTransaction();
        session.save(detail);
        session.save(company);
        session.getTransaction().commit();

        factory.close();

    }

}