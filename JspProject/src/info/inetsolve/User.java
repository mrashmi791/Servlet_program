package info.inetsolve;


/*
 *  It contain getter and setter methods
 * 
 * 
 */

public class User {

	private int id;
	private String name, address, email, sex, designation;
	private double salary;

	public int getId() {
		return id;
	}

	public void setId(int newId) {
		this.id = newId;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public String getAddress() {
		return address;
	}

	public void setPassword(String newAddress) {
		this.address = newAddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String newEmail) {
		this.email = newEmail;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String newSex) {
		this.sex = newSex;
	}

	public String getDesignation() {
		
		return designation;
	}

	public void setDoctor(String newDesignation) {
		this.designation = newDesignation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(int newSalary) {
		this.salary = newSalary;
	}
}
