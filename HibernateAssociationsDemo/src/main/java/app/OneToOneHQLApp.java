package app;

import app.entity.Company;
import app.entity.CompanyDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class OneToOneHQLApp {

    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        
        String select = "SELECT c FROM Company AS c";
        String where = "SELECT c FROM Company AS c JOIN c.companyDetail AS cd WHERE cd.residence = 'Italy'";
        String sum = "SELECT SUM(c.value) FROM Company AS c JOIN c.companyDetail AS cd WHERE cd.residence = 'Poland'";
        String orderBy = "SELECT c.name FROM CompanyDetail AS cd JOIN cd.company AS c WHERE cd.employeeNumber < 35000";

        session.beginTransaction();

        Query query = session.createQuery(select);
        List<Company> resultList = query.getResultList();
        for (Company c : resultList) {
            System.out.println(c + ", " + c.getCompanyDetail());
        }

        System.out.println("=================");

        Query query2 = session.createQuery(where);
        List<Company> resultList2 = query2.getResultList();
        for (Company c : resultList2) {
            System.out.println(c + ", " + c.getCompanyDetail());
        }

        System.out.println("=================");

        Query query3 = session.createQuery(sum);
        Long resultList3 = (Long) query3.getSingleResult();
        System.out.println("sum = " + resultList3);

        System.out.println("=================");

        Query query4 = session.createQuery(orderBy);
        List<String> resultList4 = query4.getResultList();
        for (String c : resultList4) {
            System.out.println(c);
        }

        session.getTransaction().commit();

        factory.close();

    }

}