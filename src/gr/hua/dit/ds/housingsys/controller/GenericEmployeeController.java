package gr.hua.dit.ds.housingsys.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.ds.housingsys.dao.StudentDAO;
import gr.hua.dit.ds.housingsys.entity.Student;
import gr.hua.dit.ds.housingsys.other.Algorithm;
import gr.hua.dit.ds.housingsys.other.AuthService;

@RequestMapping("/home")
@Controller
public class GenericEmployeeController {

	private int id;
	AuthService myservice = new AuthService();
	
	@Autowired
	private StudentDAO studentDAO;

	@GetMapping("/find")
	public String showSearchForm() {
		return "FindStudentByID";
	}

	@GetMapping("/findStudentForm")
	public String findStudentForm(HttpServletRequest request, Model model) {
		try {
			id = Integer.parseInt(request.getParameter("id"));
			Student student = studentDAO.getStudent(id, myservice.getcurrentUserDepartment());
			model.addAttribute("studentObj", student);
			return "ShowStudentByID";
		} catch (Exception e) {
			e.printStackTrace();
			return "GenericError";
		}

	}

	@GetMapping("/activate")
	public String showActivationForm() {
		return "ActivateStudentByID";
	}

	@GetMapping("/activateStudentForm")
	public String activateStudentForm(HttpServletRequest request, Model model) {
		try {
			id = Integer.parseInt(request.getParameter("id"));
			if(studentDAO.activateStudent(id,myservice.getcurrentUserDepartment())==1) {
				return "SuccessfulAction";
			} else {
				return "StudentLocalError";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "GenericError";
		}
	}

	@GetMapping("/approve")
	public String showApprovalForm() {
		return "ApproveApplication";
	}

	@GetMapping("/applicationApproveForm")
	public String applicationApproveForm(HttpServletRequest request, Model model) {
		try {
			id = Integer.parseInt(request.getParameter("id"));
			if (studentDAO.ApproveStudent(id,myservice.getcurrentUserDepartment()) == 1) {
				return "SuccessfulAction";
			} else {
				return "NotActivated-OR-ApprovedError";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "GenericError";
		}
	}

	@GetMapping("/points")
	public String showPointsForm() {
		return "CalcPoints";
	}

	@GetMapping("/calcPointsForm")
	public String calcPointsForm(HttpServletRequest request, Model model) {
		try {
			boolean pjob = false;
			boolean local = false;
			boolean senior = false;
			id = Integer.parseInt(request.getParameter("id"));
			int income = Integer.parseInt(request.getParameter("inc"));
			int siblings = Integer.parseInt(request.getParameter("sib"));
			int hoy = Integer.parseInt(request.getParameter("hoy"));
			
			if (request.getParameter("pjob").equals("true"))
				pjob = true;
			
			if (request.getParameter("local").equals("true"))
				local = true;
			
			if (request.getParameter("super").equals("true"))
				senior = true;
			
			//System.out.printf("HELLO FROM CONTROLLER");
			//System.out.printf("\n", pjob);
			//System.out.printf("\n", local);
			//System.out.printf("\n", senior);
			Student student = studentDAO.getStudent(id, myservice.getcurrentUserDepartment());
			if(student.isApplication_approved()==false || student.isActivation_status()==false || student.isApplication_sent()==false) {
				return "NotActivated-OR-ApprovedError";
			}
			
			Algorithm alg_object = new Algorithm();
			int points = alg_object.calcPoints(income, pjob, siblings, local, hoy, senior);

			if (studentDAO.updateStudentPoints(id, points, myservice.getcurrentUserDepartment()) == 1) {
				model.addAttribute("pointsInt", points);
				model.addAttribute("id", id);
				//Automatically Update Student Database - Optional
				//studentDAO.updateStudent(id, myservice.getcurrentUserDepartment(),local,student.getHousing_years();
				
				//Database Service Code - Calculate Remaining Seats
				List<Student> students = studentDAO.getStudents(myservice.getcurrentUserDepartment());
				Student[] myArray = new Student[students.size()];
				students.toArray(myArray);
				int j=0;
				for (int i = 0; i < myArray.length; i++) { // && myArray[i].getRanking()<100 && myArray[i].getRanking()>0 - Only if automatic Ranking update is enabled
					if(myArray[i].isApplication_approved()==true && myArray[i].isActivation_status()==true && myArray[i].getPoints()>0) {
						j++;
					}
				}
				model.addAttribute("rem", 100-j);
				
				return "ShowPoints";
			} else {
				return "GenericError";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "GenericError";
		}
	}

	@GetMapping("/find-all")
	public String showStudents(Model model) {
		return "FindAllStudents";
	}
	
	@GetMapping("/searchALLButton")
	public String findAll(Model model) {
		/*Automatically Update Ranking When User Searches All Students - Java Code - Optional - Same Code In DAOImpl
		 * 
		 * //Ranking ranking_obj = new Ranking(); //ranking_obj.updateRanking(students);
		 * ArrayList <Student> list = new ArrayList(); students.sort((Student s1,
		 * Student s2)->s2.getPoints()-s1.getPoints()); IntStream.range(0,
		 * students.size()).forEach(index -> list.add(students.get(index))); Student[]
		 * myArray = new Student[list.size()]; list.toArray(myArray); for(int i=0;
		 * i<myArray.length; i++){
		 * studentDAO.updateStudentRanking(myArray[i].getId(),i);
		 * //System.out.println("Element at the index "+i+" is ::"+myArray[i].getId());
		 * } model.addAttribute("studentObj", students);
		 */
		List<Student> students = studentDAO.getStudents(myservice.getcurrentUserDepartment());
		model.addAttribute("studentObj", students);
		return "ShowAllStudents";
	}
	
	@GetMapping("/ranking")
	public String updateRanking(Model model) {
		return "UpdateRanking";
	}

	@GetMapping("/updateRankingButton")
	public String updateRankingButton(HttpServletRequest request, Model model) {
		try {
			//Update Ranking Of All Students - Service Code
			List<Student> students = studentDAO.getStudents(myservice.getcurrentUserDepartment());
			ArrayList<Student> list = new ArrayList();
			students.sort((Student s1, Student s2) -> s2.getPoints() - s1.getPoints());
			IntStream.range(0, students.size()).forEach(index -> list.add(students.get(index)));
			Student[] myArray = new Student[list.size()];
			list.toArray(myArray);
			for (int i = 0; i < myArray.length; i++) {
				if (studentDAO.updateStudentRanking(myArray[i].getId(), i, myservice.getcurrentUserDepartment()) == 1) {
					;
					//continue;
				} else {
					break;
				}
			}
			return "SuccessfulAction";

		} catch (Exception e) {
			e.printStackTrace();
			return "GenericError";
		}
	}

	@GetMapping("/clear")
	public String clear(Model model) {
		return "Clear";
	}

	@GetMapping("/clearButton")
	public String clearButton(HttpServletRequest request, Model model) {
		try {
			List<Student> students = studentDAO.getStudents(myservice.getcurrentUserDepartment());
			ArrayList<Student> list = new ArrayList();
			IntStream.range(0, students.size()).forEach(index -> list.add(students.get(index)));
			Student[] myArray = new Student[list.size()];
			list.toArray(myArray);
			for (int i = 0; i < myArray.length; i++) {
				System.out.print(myArray[i].getId());
				studentDAO.clearStudents(myArray[i].getId(), myservice.getcurrentUserDepartment());
			}
			return "SuccessfulAction";

		} catch (Exception e) {
			e.printStackTrace();
			return "GenericError";
		}
	}

}
