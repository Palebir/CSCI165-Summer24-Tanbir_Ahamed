package lab;

import java.sql.Date;

/*
 * File:	Employee.java
 * Author:	Ken Whitener
 * Date:	4/15/2024
 * 
 * Description: This class represents an employee with a hire date, id number, and department.
 * 				Employee is a subclass of Person.
 */


 public class Employee extends Person {

	private Date	hireDate;
	private int		id;
	private String	department;

	// no argument
	public Employee() {}

	// overloaded constructor
	/**
	 * 
	 * @param p
	 * @param hired
	 * @param id
	 * @param dept
	 */
	public Employee(Person p, Date hired, int id, String dept) {
		super(p);			// call to super class copy constructor
		setHireDate(hired);	// sets will protect privacy
		setId(id);
		setDepartment(dept);
	}

	private void setHireDate(Date hired) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setHireDate'");
	}

	// overloaded constructor
	/**
	 * 
	 * @param first
	 * @param last
	 */
	public Employee(String first, String last){
		super(first, last);
	}

	// copy constructor
	/**
	 * 
	 * @param toCopy
	 */
	public Employee(Employee toCopy){
		this(toCopy, toCopy.hireDate, toCopy.id, toCopy.department);
	}

	public Employee(Employee toCopy, long hireDate2, int id2, String department2) {
		//TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return the date the Employee was hired
	 */
	public Date getHireDate() {
		return new Date(hireDate);			// privacy protection
	}

	/**
	 * 
	 * @param hireDate
	 */
	public void setHireDate(long hireDate) {
		this.hireDate = new Date(hireDate); // privacy protection
	}

	/**
	 * 
	 * @return The Employee's ID number
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return The Employee's Department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * 
	 * @param department
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return super.toString() + "\nHired: " + hireDate + "\nID: " + id + "\nDept: " + department;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)					return true;	// idenitity check
		if (obj == null)					return false;	// null check
		if (getClass() != obj.getClass())	return false;	// origin check 
		if (!super.equals(obj))				return false;	// super class check (inheritance)

		Employee other = (Employee) obj;					// downcast

		if (hireDate == null){								// date hired
			if (other.hireDate != null)		return false;
		}
		else if (!hireDate.equals(other.hireDate))			// calls Date.equals (composition)
			return false;

		if (id != other.id)					return false;	// id (primitive)

		return true;	// everything is equal
	}
}

