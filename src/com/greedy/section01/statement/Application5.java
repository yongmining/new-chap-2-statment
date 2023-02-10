package com.greedy.section01.statement;
import static com.greedy.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static com.greedy.common.JDBCTemplate.close;

import com.greedy.model.dto.EmployeeDTO;

public class Application5 {

	public static void main(String[] args) {
		
		Connection con = getConnection();
		
		Statement stmt= null;
		ResultSet rset = null;
		
		List<EmployeeDTO> empList = null;
		
		String query = "SELECT * FROM EMPLOYEE";
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			empList = new ArrayList<>();
			
			while(rset.next()) {
				
				EmployeeDTO row = new EmployeeDTO();
				
				row.setEmpId(rset.getString("EMP_ID"));
				row.setEmpName(rset.getString("EMP_NAME"));
				row.setEmpNo(rset.getString("EMP_NO"));
				row.setEmail(rset.getString("EMAIL"));
				row.setPhone(rset.getString("PHONE"));
				row.setDeptCode(rset.getString("DEPT_CODE"));
				row.setJobCode(rset.getString("JOB_CODE"));
				row.setSalLevel(rset.getString("SAL_LEVEL"));
				row.setSalary(rset.getInt("SALARY"));
				row.setBonus(rset.getDouble("BONUS"));
				row.setManagerId(rset.getString("MANAGER_ID"));
				row.setHireDate(rset.getDate("HIRE_DATE"));
				row.setEntDate(rset.getDate("ENT_DATE"));
				row.setEntYn(rset.getString("ENT_YN"));
				
				empList.add(row);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			close(stmt);
			close(rset);
			close(con);
		
		for(EmployeeDTO emp : empList) {
			System.out.println(emp);
		} 
		}

	}

}
