package com.aviskar.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Component;

import com.aviskar.example.model.Student;
import com.aviskar.example.util.HibernateUtil;

@Component
public class StudentDao {

	public List<Student> findAll() {
		EntityManager em = HibernateUtil.createEntityManager();
		CriteriaQuery<Student> cq = em.getCriteriaBuilder().createQuery(Student.class);
		cq.select(cq.from(Student.class));
		List<Student> students = em.createQuery(cq).getResultList();
		em.close();
		return students;
	}

	public Student findOne(Long id) {
		EntityManager em = HibernateUtil.createEntityManager();
		return em.find(Student.class, id);
	}

	public Student save(Student student) {
		EntityManager em = HibernateUtil.createEntityManager();
		em.getTransaction().begin();
		em.persist(student);
		em.getTransaction().commit();
		em.close();
		return student;
	}

	public void update(Student student) {
		EntityManager em = HibernateUtil.createEntityManager();
		em.getTransaction().begin();
		em.merge(student);
		em.getTransaction().commit();
		em.close();

	}

	public void delete(Long id) {
		EntityManager em = HibernateUtil.createEntityManager();
		em.getTransaction().begin();
		Student student = em.find(Student.class, id);
		if (student != null)
			em.remove(student);
		em.getTransaction().commit();
		em.close();
	}
}
