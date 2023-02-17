package one_to_many_bi1.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one_to_many_bi1.dto.Company;
import one_to_many_bi1.dto.Employee;

public class CompanyDAO {
	public static void main(String[] args) {
		Company company=new Company();
		company.setId(2);
		company.setName("WER");
		company.setGst("XYW345");
		
		Employee e1 = new Employee();
		e1.setId(4);
		e1.setName("Rishi");
		e1.setPhone(98523641);
		e1.setCompany(company);
		
		Employee e2 = new Employee();
		e2.setId(5);
		e2.setName("Aksi");
		e2.setPhone(9512364);
		e2.setCompany(company);
		
		Employee e3 = new Employee();
		e3.setId(6);
		e3.setName("Deksi");
		e3.setPhone(965236);
		e3.setCompany(company);
		
		List<Employee> list = new ArrayList<Employee>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		company.setList(list);
		
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("akash");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction= entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(company);
		entityManager.persist(e1);
		entityManager.persist(e2);
		entityManager.persist(e3);
		entityTransaction.commit();
	}
}
