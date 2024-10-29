package com.iits.main.springjdbctest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("edao")
public class EmployeeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean addEmployee(@Autowired Employee employee) {
		String query = "INSERT INTO EMPLOYEE VALUES(?,?,?)";
		this.jdbcTemplate.update(query, employee.getEid(), employee.getEname(), employee.getEsalary());
		return true;
	}
 
	public List<Employee> getAllEmployees() {
		String query = "SELECT * FROM EMPLOYEE";
		List<Employee> list = this.jdbcTemplate.query(query, new BeanPropertyRowMapper<Employee>(Employee.class));

		return list;
	}

	@SuppressWarnings("deprecation")
	public Employee getEmployeeById(int eid) {
		String query = "SELECT * FROM EMPLOYEE WHERE EID=?";
		/*return this.jdbcTemplate.query(query,new Object[]{eid}, new ResultSetExtractor<Employee>() {
			@Override
			public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				if (rs.next()) {
					Employee emp = new Employee();
					emp.setEid(rs.getInt(1));
					emp.setEname(rs.getString(2));
					emp.setEsalary(rs.getDouble(3));
					return emp;
				} else {
					return null;
				}
			}
		});*/
		return this.jdbcTemplate.queryForObject(query, new Object[] {eid}, new BeanPropertyRowMapper<>(Employee.class));
	}

	public int updateEmployee(Employee emp) {
		String query = "UPDATE EMPLOYEE SET ENAME=?,ESALARY=? WHERE EID=?";
		int i = this.jdbcTemplate.update(query, emp.getEname(), emp.getEsalary(), emp.getEid());
		return i;
	}
}
