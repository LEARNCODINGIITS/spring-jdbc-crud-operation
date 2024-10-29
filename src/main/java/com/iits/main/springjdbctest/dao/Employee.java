package com.iits.main.springjdbctest.dao;

public class Employee {

	private int eid;
	private String ename;
	private double esalary;

	public Employee() {
		super();
	}
	 
	public void setEid(int eid) {
		this.eid = eid;
	}
	 
	public void setEname(String ename) {
		this.ename = ename;
	}
	 
	public void setEsalary(double esalary) {
		this.esalary = esalary;
	}

	public int getEid() {
		return eid;
	}
	public String getEname() {
		return ename;
	}
	public double getEsalary() {
		return esalary;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esalary=" + esalary + "]";
	}

}
