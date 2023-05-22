package app;

import app.entity.Company;
import app.entity.CompanyDetail;
import app.entity.Department;
import app.entity.Property;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class OneToManyUniDeleteApp {

    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);
        conf.addAnnotatedClass(Property.class);
        conf.addAnnotatedClass(Department.class);

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();

        int id = 2;
        int idCompany = 27;
        String departmentNameToDelete = "HR";
        int idHql = 3;

        String delete = "DELETE Department AS d WHERE d.idDepartment=:idDepartment";

        session.beginTransaction();

        Department department1 = session.get(Department.class, id);
        session.delete(department1);

        System.out.println("===============");

        Company company = session.get(Company.class, idCompany);
        List<Department> departmentsToRemove = new ArrayList<>();

        for (Department department : company.getDepartments()) {
            if (department.getName().equals(departmentNameToDelete)) {
                departmentsToRemove.add(department);
            }
        }

        for (Department department : departmentsToRemove) {
            company.getDepartments().remove(department);
            session.delete(department);
        }

        System.out.println("===============");

        Query query = session.createQuery(delete);
        Query deleteRows = query.setParameter("idDepartment", idHql);
        int deletedRows = query.executeUpdate();
        System.out.println(deletedRows);

        session.getTransaction().commit();

        factory.close();

    }

}