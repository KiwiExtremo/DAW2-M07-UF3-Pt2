package cat.institutmarianao.services.impl;

import java.util.List;

import cat.institutmarianao.model.Student;
import cat.institutmarianao.services.StudentService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class StudentServiceImpl implements StudentService {
	@PersistenceContext
	EntityManager em;

	@Override
	public Student findByPk(String dni) {
		return em.find(Student.class, dni);
	}

	@Override
	public List<Student> findAll() {
		return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
	}

	@Override
	public Student add(Student student) {
		em.persist(student);

		return findByPk(student.getDni());
	}

	@Override
	public void remove(Student student) {
		if (!em.contains(student)) {
			em.merge(student);
		}

		em.createQuery("DELETE FROM Student s WHERE s.dni = :dni").setParameter("dni", student.getDni())
				.executeUpdate();
	}

	@Override
	public void removeByDni(String dni) {
		Student student = findByPk(dni);

		if (student != null) {
			remove(student);
		}
	}
}
