package gr.hua.dit.ds.housingsys.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
    
    @Column(name = "department")
    private String department;
    
    @Column(name = "semester")
    private int semester;
    
    @Column(name = "phone")
    private int phone;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "locality")
    private boolean locality;
    
    @Column(name = "housing_years")
    private int housing_years;
    
    @Column(name = "application_sent")
    private boolean application_sent;
    
    @Column(name = "activation_status")
    private boolean activation_status;
    
    @Column(name = "points")
    private int points;
    	  
    @Column(name = "ranking")
    private int ranking;
    
    @Column(name = "application_approved")
    private boolean application_approved;

	public Student() {
		super();
	}

	public Student(int id, String name, String department, int semester, int phone, String email, boolean locality,
			int housing_years, boolean application_sent, boolean activation_status, int points, int ranking,
			boolean application_approved) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.semester = semester;
		this.phone = phone;
		this.email = email;
		this.locality = locality;
		this.housing_years = housing_years;
		this.application_sent = application_sent;
		this.activation_status = activation_status;
		this.points = points;
		this.ranking = ranking;
		this.application_approved = application_approved;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isLocality() {
		return locality;
	}

	public void setLocality(boolean locality) {
		this.locality = locality;
	}

	public int getHousing_years() {
		return housing_years;
	}

	public void setHousing_years(int housing_years) {
		this.housing_years = housing_years;
	}

	public boolean isApplication_sent() {
		return application_sent;
	}

	public void setApplication_sent(boolean application_sent) {
		this.application_sent = application_sent;
	}

	public boolean isActivation_status() {
		return activation_status;
	}

	public void setActivation_status(boolean activation_status) {
		this.activation_status = activation_status;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public boolean isApplication_approved() {
		return application_approved;
	}

	public void setApplication_approved(boolean application_approved) {
		this.application_approved = application_approved;
	}

	public String getActivationStatus() {
		return "" + activation_status;
	}
    
	
}