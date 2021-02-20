package gr.hua.dit.ds.housingsys.other;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;

import gr.hua.dit.ds.housingsys.dao.StudentDAO;
import gr.hua.dit.ds.housingsys.entity.Student;

public class RankingService {
	
	@Autowired
	private StudentDAO studentDAO;
	
	AuthService myservice = new AuthService();
	
	public int automaticUpdateRanking() {
		try {
			// Update Ranking Code - Same in the Service
			List<Student> students = studentDAO.getStudents(myservice.getcurrentUserDepartment());
			ArrayList<Student> list = new ArrayList();
			students.sort((Student s1, Student s2) -> s2.getPoints() - s1.getPoints());
			IntStream.range(0, students.size()).forEach(index -> list.add(students.get(index)));
			Student[] myArray = new Student[list.size()];
			list.toArray(myArray);
			for (int i = 0; i < myArray.length; i++) {
				if (studentDAO.updateStudentRanking(myArray[i].getId(), i, myservice.getcurrentUserDepartment()) == 1) {
					;
					// continue;
				} else {
					break;
				}
			}
			return 1;

		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
	}
}
