package gr.hua.dit.ds.housingsys.dao;

import java.util.List;

import gr.hua.dit.ds.housingsys.entity.Student;

public interface StudentDAO {
	//Mandatory
    public Student getStudent(int studentId, String department);
    public List <Student> getStudents(String department);
    public int activateStudent(int studentId, String department);
    public int ApproveStudent(int studentId, String department);
    public int updateStudentPoints(int studentId,int points, String department);
    public int updateStudentRanking(int studentId,int rank, String department);
    public void clearStudents(int studentId, String department);
    
    //Optional
    public List <Student> getStudents2();
    public int updateStudent(int studentId, String department, boolean local, int housing_years);
    
    //Rest API
    public Student getStudentForREST(int studentId);
    public int updateStudentForREST(int studentId, int phone, String mail);
    public int updateStudentForREST2(int studentId);
}