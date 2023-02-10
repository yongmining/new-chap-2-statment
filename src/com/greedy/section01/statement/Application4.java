package com.greedy.section01.statement;

import static com.greedy.common.JDBCTemplate.getConnection;
import static com.greedy.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.greedy.model.dto.DepartmentDTO;

public class Application4 {

	public static void main(String[] args) {
		
		Connection con = getConnection();
		
		Statement stmt = null;
		ResultSet rset = null;
		
		DepartmentDTO selectedDept = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("조회하실 부서 번호를 알려주세요 :  ");
		String deptId = sc.nextLine();
		
		String query = "SELECT * FROM DEPARTMENT WHERE DEPT_ID = '" + deptId + "'";
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				selectedDept = new DepartmentDTO();
				
				selectedDept.setDeptId(rset.getString("DEPT_ID"));
				selectedDept.setDeptTitle(rset.getString("DEPT_TITLE"));
				selectedDept.setLocationId(rset.getString("LOCATION_ID"));
		
				
			}
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
			close(con);
		}
		
		
		System.out.println(selectedDept);
		

	}

}
