package gr.hua.dit.ds.housingsys.other;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import gr.hua.dit.ds.housingsys.dao.StudentDAO;
import gr.hua.dit.ds.housingsys.entity.Student;

public class DatabaseService {
	
	@Autowired
	private StudentDAO studentDAO;
	
	public int checkLimit(String currentUser) {
		List<Student> students = studentDAO.getStudents(currentUser);
		Student[] myArray = new Student[students.size()];
		students.toArray(myArray);
		int j=0;
		for (int i = 0; i < myArray.length; i++) {
			if(myArray[i].isApplication_approved()==true && myArray[i].isActivation_status()==true && myArray[i].getPoints()>0 && myArray[i].getRanking()<100 && myArray[i].getRanking()>0)
			{
				j++;
			}
		}
		return 100-j ;
		
	}

}
