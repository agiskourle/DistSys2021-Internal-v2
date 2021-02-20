package gr.hua.dit.ds.housingsys.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import gr.hua.dit.ds.housingsys.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public Student getStudent(int studentId, String department) {
		Student student = new Student();
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Student> query = currentSession.createQuery(
				"select s from Student s " + "where s.id=:studentId" + " AND s.department=:department", Student.class);
		query.setParameter("studentId", studentId);
		query.setParameter("department", department);
		student = query.getSingleResult();
		return student;
	}

	@Override
	@Transactional
	public List<Student> getStudents(String department) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Student> query = currentSession.createQuery("from Student s where s.department=:department",
				Student.class);
		query.setParameter("department", department);
		List<Student> students = query.getResultList();
		return students;
	}

	@Override
	@Transactional
	public int activateStudent(int studentId, String department) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<Student> query = currentSession.createQuery(
					"select s from Student s " + "where s.id=:studentId" + " AND s.department=:department",
					Student.class);
			query.setParameter("studentId", studentId);
			query.setParameter("department", department);
			Student student = query.getSingleResult();
			if (student.isLocality() == false && student.getSemester() <= 12 && student.getHousing_years() < 4) {
				student.setActivation_status(true);
				currentSession.update(student);
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	@Transactional
	public int ApproveStudent(int studentId, String department) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<Student> query = currentSession.createQuery(
					"select s from Student s " + "where s.id=:studentId" + " AND s.department=:department",
					Student.class);
			query.setParameter("studentId", studentId);
			query.setParameter("department", department);
			Student student = query.getSingleResult();
			if (student.isActivation_status() == true && student.isApplication_sent() == true) {
				student.setApplication_approved(true);
				currentSession.update(student);
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	@Transactional
	public int updateStudentPoints(int studentId, int points, String department) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<Student> query = currentSession.createQuery(
					"select s from Student s " + "where s.id=:studentId" + " AND s.department=:department",
					Student.class);
			query.setParameter("studentId", studentId);
			query.setParameter("department", department);
			Student student = query.getSingleResult();
			student.setPoints(points);
			currentSession.update(student);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	@Transactional
	public int updateStudentRanking(int studentId, int rank, String department) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<Student> query = currentSession.createQuery(
					"select s from Student s " + "where s.id=:studentId" + " AND s.department=:department",
					Student.class);
			query.setParameter("studentId", studentId);
			query.setParameter("department", department);
			Student student = query.getSingleResult();
			student.setRanking(rank + 1);
			currentSession.update(student);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	@Transactional
	public void clearStudents(int studentId, String department) {
		try {
			Student student = new Student();
			Session currentSession = sessionFactory.getCurrentSession();
			Query<Student> query = currentSession.createQuery(
					"select s from Student s " + "where s.id=:studentId" + " AND s.department=:department",
					Student.class);
			query.setParameter("studentId", studentId);
			query.setParameter("department", department);
			student = query.getSingleResult();
			student.setPoints(0);
			student.setRanking(0);
			student.setActivation_status(false);
			student.setApplication_approved(false);
			student.setApplication_sent(false);
			currentSession.update(student);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	@Transactional
	public List<Student> getStudents2() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Student> query = currentSession.createQuery("from Student s", Student.class);
		List<Student> students = query.getResultList();
		return students;
	}

	// NOT USED - Extra Feature!
	@Override
	@Transactional
	public int updateStudent(int studentId, String department, boolean local, int housing_years) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<Student> query = currentSession.createQuery(
					"select s from Student s " + "where s.id=:studentId" + " AND s.department=:department",
					Student.class);
			query.setParameter("studentId", studentId);
			query.setParameter("department", department);
			Student student = query.getSingleResult();

			if (local == true)
				student.setLocality(true);
			else
				student.setLocality(false);

			student.setSemester(student.getSemester() + 1);

			if (housing_years < 4)
				student.setHousing_years(student.getHousing_years() + 1);
			else
				student.setHousing_years(-1);

			currentSession.update(student);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	@Transactional
	public Student getStudentForREST(int studentId) {
		Student student = new Student();
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Student> query = currentSession.createQuery("select s from Student s " + "where s.id=:studentId",
				Student.class);
		query.setParameter("studentId", studentId);
		student = query.getSingleResult();
		return student;
	}

	@Override
	@Transactional
	public int updateStudentForREST(int studentId, int phone, String mail) {
		try {
			Student student = new Student();
			Session currentSession = sessionFactory.getCurrentSession();
			Query<Student> query = currentSession.createQuery("select s from Student s " + "where s.id=:studentId",
					Student.class);
			query.setParameter("studentId", studentId);
			student = query.getSingleResult();
			student.setPhone(phone);
			student.setEmail(mail);
			currentSession.update(student);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	@Transactional
	public int updateStudentForREST2(int studentId) {
		try {
			Student student = new Student();
			Session currentSession = sessionFactory.getCurrentSession();
			Query<Student> query = currentSession.createQuery("select s from Student s " + "where s.id=:studentId",
					Student.class);
			query.setParameter("studentId", studentId);
			student = query.getSingleResult();
			if(student.isActivation_status()==true) {
				student.setApplication_sent(true);
				currentSession.update(student);
				return 1;
			} else {
				return 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

}
