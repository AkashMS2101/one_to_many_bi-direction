package one_to_many_bi1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one_to_many_bi1.dto.Company;
import one_to_many_bi1.dto.Employee;

public class CompanyDao1 {
	public EntityManager getentityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		return entityManagerFactory.createEntityManager();
	}
	public void saveCompany(Company company) {
		EntityManager entityManager= getentityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(company);
		entityTransaction.commit();
	}
	public void updateCompany(int id,String name) {
		EntityManager entityManager= getentityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Company company = entityManager.find(Company.class, id);
		company.setName(name);
		entityTransaction.begin();
		entityManager.merge(company);
		entityTransaction.commit();
	}
	public void deleteCompany(int id) {
		EntityManager entityManager= getentityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Company company = entityManager.find(Company.class, id);
		entityTransaction.begin();
		entityManager.remove(company);
		entityTransaction.commit();
	}
	public void displaybyId(int id) {
		EntityManager entityManager= getentityManager();
		Company company = entityManager.find(Company.class, id);
		System.out.println(company);
	}
	public void displayAll() {
		EntityManager entityManager = getentityManager();
		entityManager.createQuery("select c from company c");
	}
}
