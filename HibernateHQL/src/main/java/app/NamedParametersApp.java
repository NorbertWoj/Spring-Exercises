package app;

import app.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class NamedParametersApp {
    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();

        String employeeFirstName = "Steven";
        String employeeLastName = "King";

        session.beginTransaction();

        String queryString = "SELECT e.firstName, e.lastName, e.salary FROM Employee AS e WHERE e.firstName = '" +
                employeeFirstName + "' AND e.lastName = '" + employeeLastName + "'";

        String namedParametersString = "SELECT e.firstName, e.lastName, e.salary FROM Employee AS e WHERE e.firstName=:firstName " +
                "AND e.lastName=:lastName";

        Query query = session.createQuery(queryString);

        List<Object[]> resultList = query.getResultList();

        for (Object[] values : resultList) {
            System.out.println("FirstName: " + values[0] + ", lastName: " + values[1] + ", salary: " + values[2]);
        }

        System.out.println("==================");

        Query namedParametersQuery = session.createQuery(namedParametersString);

        namedParametersQuery.setParameter("firstName",employeeFirstName);
        namedParametersQuery.setParameter("lastName",employeeLastName);

        List<Object[]> resultList2 = namedParametersQuery.getResultList();

        for (Object[] values : resultList2) {
            System.out.println("FirstName: " + values[0] + ", lastName: " + values[1] + ", salary: " + values[2]);
        }

        session.getTransaction().commit();

        factory.close();

    }
}