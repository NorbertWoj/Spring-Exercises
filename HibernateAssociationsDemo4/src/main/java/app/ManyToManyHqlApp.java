package app;

import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ManyToManyHqlApp {

    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);
        conf.addAnnotatedClass(Property.class);
        conf.addAnnotatedClass(Department.class);
        conf.addAnnotatedClass(Employee.class);
        conf.addAnnotatedClass(Training.class);

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();

        int minEmployeeNumber = 6;
        String getTraining = "sELECT t FROM Training AS t WHERE SIZE(t.employees) >= :minEmployeeNumber";

        String course = "javascript";
        String getEmployee = "SELECT e FROM Employee AS e JOIN e.trainings AS t WHERE t.name=:course";

        int trainingNumber = 1;
        int maxSalary = 12000;

        String getEmployee2 = "SELECT e FROM Employee AS e WHERE SIZE(e.trainings) = :trainingNumber AND e.salary < :maxSalary";

        session.beginTransaction();

        Query query = session.createQuery(getTraining);
        query.setParameter("minEmployeeNumber", minEmployeeNumber);
        List<Training> resultList = query.getResultList();
        for (Training training : resultList) {
            System.out.println(training);
        }

        System.out.println("=============");

        Query query2 = session.createQuery(getEmployee);
        query2.setParameter("course", course);
        List<Employee> resultList2 = query2.getResultList();
        for (Employee employee : resultList2) {
            System.out.println(employee);
        }

        System.out.println("=============");

        Query query3 = session.createQuery(getEmployee2);

        query3.setParameter("trainingNumber", trainingNumber);
        query3.setParameter("maxSalary", maxSalary);
        List<Employee> resultList3 = query3.getResultList();
        for (Employee employee : resultList2) {
            System.out.println(employee);
        }

        session.getTransaction().commit();

        factory.close();

    }

}
