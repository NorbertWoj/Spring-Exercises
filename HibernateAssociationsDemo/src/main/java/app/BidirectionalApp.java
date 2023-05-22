package app;

import app.entity.Company;
import app.entity.CompanyDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BidirectionalApp {

    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();

//        Company company = new Company("ZBC", 20000);
//        CompanyDetail detail = new CompanyDetail("Poland", 160);
//        detail.setCompany(company);
//        company.setCompanyDetail(detail);

        session.beginTransaction();
//        session.persist(detail);
        CompanyDetail detail = session.get(CompanyDetail.class, 5);
        session.remove(detail);
        session.getTransaction().commit();

//        System.out.println(detail.getCompany());

        factory.close();

    }

}