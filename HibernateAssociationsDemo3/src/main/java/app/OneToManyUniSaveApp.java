package app;

import app.entity.Company;
import app.entity.CompanyDetail;
import app.entity.Department;
import app.entity.Property;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyUniSaveApp {

    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);
        conf.addAnnotatedClass(Property.class);
        conf.addAnnotatedClass(Department.class);

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();

        int id = 27;

        session.beginTransaction();
        Company company = session.get(Company.class, id);
        System.out.println(company);

        Department department1 = new Department("sales");
        Department department2 = new Department("production");
        Department department3 = new Department("HR");

        company.addDepartment(department1);
        company.addDepartment(department2);
        company.addDepartment(department3);

        session.persist(company);

        session.getTransaction().commit();

        factory.close();

    }

}

