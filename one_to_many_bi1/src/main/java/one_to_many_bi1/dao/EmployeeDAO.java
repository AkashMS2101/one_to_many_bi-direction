package one_to_many_bi1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one_to_many_bi1.dto.Employee;

public class EmployeeDAO {
	public EntityManager getentityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		return entityManagerFactory.createEntityManager();
	}
	public void saveEmployee(Employee employee) {
		EntityManager entityManager = getentityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
	}
	public void updateEmployee(int id,String name) {
		EntityManager entityManager=getentityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Employee employee=entityManager.find(Employee.class, id);
		
		entityTransaction.begin();
		entityManager.merge(employee);
		entityTransaction.commit();
	}
	public void deleteEmployee(int id) {
		EntityManager entityManager = getentityManager();
		EntityTransaction entityTransaction= entityManager.getTransaction();
		
		Employee employee=entityManager.find(Employee.class, id);
		
		entityTransaction.begin();
		entityManager.remove(employee);
		entityTransaction.commit();
	}
	public void displaybyId(int id) {
		EntityManager entityManager = getentityManager();
		Employee employee=entityManager.find(Employee.class, id);
		
		System.out.println(employee);
	}
	
}
