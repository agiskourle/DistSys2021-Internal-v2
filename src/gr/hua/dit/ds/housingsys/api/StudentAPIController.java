package gr.hua.dit.ds.housingsys.api;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gr.hua.dit.ds.housingsys.dao.StudentDAO;
import gr.hua.dit.ds.housingsys.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentAPIController {

	@Autowired
	private StudentDAO studentDAO;

	//--->https://www.w3schools.com/tags/ref_httpmethods.asp
	
	//GET STUDENT RANKING & STATUS
	
	@GetMapping("/students/{id}")
	public int getStudentRanking(@PathVariable("id") int id) {
		try {
			Student student = studentDAO.getStudentForREST(id);
			if(student.getPoints()>0) {
				return student.getRanking();
			} else {
				if(student.getRanking()==0 && student.isActivation_status()==true) {
					return 0;
				} else {
					return -1;
				}
				
			}
			//HERE
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	/*
	 * @PutMapping("/updateStudentInfo:{id}") public int
	 * updateStudentInfo(@PathVariable("id") int id ,@RequestBody int phone, String
	 * mail) { try { if(studentDAO.updateStudentForREST(id, phone, mail)==1) {
	 * return 1; } else return 0; } catch (Exception e) { e.printStackTrace();
	 * return -1; } }
	 */

	

	/*
	 * Update CONTACT INFORMATION FOR STUDENT
	 */
	
	//Update WITH GET - WITHOUT @RequestBody
	/*
	@GetMapping("/updateStudentInfo:{id},{phone},{mail}")
	public int updateStudentInfo(@PathVariable("id") int id, @PathVariable("phone") int phone, @PathVariable("mail") String mail) {
		try {
			if (studentDAO.updateStudentForREST(id, phone, mail) == 1) {
				return 1;
			} else
				return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	*/
	
	//Update CONTACT INFORMATION WITH POST (OR PUT) 
	@PostMapping(path="/students/details",consumes = "application/json")
	public int updateStudentInfo2(@RequestBody  String student ) {
		try {
			//Create a JSONParser object
		    JSONParser jsonParser = new JSONParser();
		     
		    //Parse Contents
		    JSONObject jsonObject = (JSONObject) jsonParser.parse(student);
			
	        // Get ID,PHONE,MAIL
	        int id = Integer.parseInt((String)jsonObject.get("id")); 
	        int phone = Integer.parseInt((String)jsonObject.get("phone")); 
	        String mail =  (String) jsonObject.get("mail"); 
	        
			if (studentDAO.updateStudentForREST(id,phone,mail) == 1) {
			return 1;
		} else
				return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	//Update Application Status - APPLICATION SENT BY STUDENT
	
	/*//Update WITH GET
	@GetMapping("/updateApplicationStatus:{id}")
	public int updateApplicationStatus(@PathVariable("id") int id) {
		try {
			if (studentDAO.updateStudentForREST2(id) == 1) {
				return 1;
			} else
				return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	*/
	
	
	@PostMapping(path="/students/applications",consumes = "application/json")
	public int updateApplicationStatus2(@RequestBody  String id ) {
		try {
			//Create a JSONParser object
		     JSONParser jsonParser = new JSONParser();
		     
		    //Parse Contents
		    JSONObject jsonObject = (JSONObject) jsonParser.parse(id);
			
	        // Get ID
	        int id2 = Integer.parseInt((String)jsonObject.get("id")); 
			if (studentDAO.updateStudentForREST2(id2) == 1) {
				return 1;
			} else
				return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}
