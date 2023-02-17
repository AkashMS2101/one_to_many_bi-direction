package one_to_many_bi2.dao;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one_to_many_bi2.dto.Student;

public class StudentDAO {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		return entityManagerFactory.createEntityManager();
	}

	public void saveStudent(Student student) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
	}

	public void updateStudent(int id, String name) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Student student = entityManager.find(Student.class, id);
		student.setName(name);
		entityTransaction.begin();
		if (student != null) {
			entityManager.merge(student);
		} else {
			System.out.println("student id doesnt exist");
		}
		entityTransaction.commit();
	}

	public void deleteStudent(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Student student = entityManager.find(Student.class, id);
		entityTransaction.begin();
		if (student != null) {
			entityManager.remove(student);
		} else {
			System.out.println("student id doesnt exist");
		}
		entityTransaction.commit();
	}

	public void displayById(int id) {
		EntityManager entityManager = getEntityManager();
		Student student = entityManager.find(Student.class, id);
		System.out.println(student);
	}
}
