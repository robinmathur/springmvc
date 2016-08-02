package com.rob.model;

public class Employee {

	private int empID;
	private String empName;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int in, String name){
		this.empID=in;
		this.empName=name;
	}
	
	public int getEmpID() {
		return empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", empName=" + empName + "]";
	}
	
	
}
