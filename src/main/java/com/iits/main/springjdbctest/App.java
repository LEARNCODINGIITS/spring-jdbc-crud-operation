package com.iits.main.springjdbctest;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.iits.main.springjdbctest.config.JdbcConfig;
import com.iits.main.springjdbctest.dao.Employee;
import com.iits.main.springjdbctest.dao.EmployeeDAO;

public class App {
	public static void main(String[] args) {
	 ApplicationContext context
	 =new AnnotationConfigApplicationContext(JdbcConfig.class);
	 EmployeeDAO edao=context.getBean(EmployeeDAO.class);
	/* Employee emp=new Employee();
	 emp.setEid(1002);
	 emp.setEname("RAJU1");
	 emp.setEsalary(34000.00);
	 boolean flag=edao.addEmployee(emp);
	 if(flag) {
		 System.out.println("Stored In db");
	 }else {
		 System.out.println("Some issue");
	 }*/
	 System.out.println("--Get all the Employee Details---");
	 List<Employee> list=edao.getAllEmployees();
	 list.forEach(System.out::println);
	 
	 System.out.println("Get the specify employee details");
	 Employee e=edao.getEmployeeById(1001);
	 if(e!=null) {
		 System.out.println(e);
	 }else {
		 System.out.println("Not Found");
	 }
	 
	 //Update
	 System.out.println("Perform Update Operation");
	 e.setEsalary(e.getEsalary()+1000);
	 int status=edao.updateEmployee(e);
	 
	 
	   
	}
}
