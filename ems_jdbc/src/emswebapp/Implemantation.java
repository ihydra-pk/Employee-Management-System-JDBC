package emswebapp;
import java.util.*;
import java.sql.*;

public class Implemantation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int empid;
		String name;
		double salary;
		String location;
		String designation;
		int age;
		Connection con ;
		
		
		while(true){
			System.out.println("----------Welcome to Employee Management System----------\n"
					+ "1) Add an Employee\n"
					+ "2) Show All Employees\n"
					+ "3) Update Employee Data\n"
					+ "4) Delete an Employee\n"
					+ "5) Exit");
			System.out.print("Enter Choice: ");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
			{
				System.out.print("Enter EmployeeID: ");
				empid = sc.nextInt();
				sc.nextLine();
				
				System.out.print("Enter Name: ");
				name = sc.nextLine();
				
				System.out.print("Enter Salary: ");
				salary = sc.nextDouble();
				sc.nextLine();
				
				System.out.print("Enter Location: ");
				location = sc.nextLine();
				
				System.out.print("Enter Designation: ");
				designation = sc.nextLine();
				
				System.out.print("Enter age: ");
				age = sc.nextInt();
				
				Employee emp = new Employee(empid, name, salary, location, designation, age);
					con = DBconnection.createConnection();	
					try {
						String QUERY = "insert into emp values(?, ?, ?, ?, ?, ?)";
						PreparedStatement pstmt = con.prepareStatement(QUERY);
						pstmt.setInt(1, emp.getEmpid());
						pstmt.setString(2, emp.getName());
						pstmt.setDouble(3, emp.getSalary());
						pstmt.setString(4, emp.getLocation());
						pstmt.setString(5, emp.getDesignation());
						pstmt.setInt(6, emp.getAge());
						int rowsAffected = pstmt.executeUpdate();
						System.out.print(rowsAffected+ "row(s) affected !!\n\n");
						
					}catch(Exception e){
						e.printStackTrace();
					}
				break;	
			}
			
			case 2:
			{
			System.out.printf("-------------------------------------------------------------------------------------------------%n"
					+ 		 "empid            name            salary            location            designation            age%n"
					+        "-------------------------------------------------------------------------------------------------%n");	
			con = DBconnection.createConnection();
			try {
				Statement stmt = con.createStatement();
				String QUERY = "Select * from emp";
				ResultSet rs = stmt.executeQuery(QUERY);
				while(rs.next()) {
					System.out.printf("%-16d", rs.getInt(1));
					System.out.printf("%-16s", rs.getString("name"));
					System.out.printf("%-20.2f", rs.getDouble("salary"));
					System.out.printf("%-20s", rs.getString("location"));
					System.out.printf("%-22s", rs.getString("designation"));
					System.out.printf("%-5d%n", rs.getInt("age"));
				}
				System.out.println("-------------------------------------------------------------------------------------------------\n");
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
			}
			case 3:
			{	
				int id; 
				String new_name;
				double new_salary;
				String new_location;
				String new_designation;
				int new_age;
				con = DBconnection.createConnection();
				try {
					String QUERY = "update emp set name = ?, salary = ?, location = ?, designation = ?, age = ? where empid = ?";
					System.out.print("Enter empid you want to update: ");
					id = sc.nextInt();
					sc.nextLine();
					
					System.out.print("Enter new name: ");
					new_name = sc.nextLine();
					
					System.out.print("Enter new Salary: ");
					new_salary = sc.nextDouble();
					sc.nextLine();
					
					System.out.print("Enter new Location: ");
					new_location = sc.nextLine();
					
					System.out.print("Enter new Designation: ");
					new_designation = sc.nextLine();
					
					System.out.print("Enter new age: ");
					new_age = sc.nextInt();
					
					PreparedStatement pstmt = con.prepareStatement(QUERY);
					pstmt.setString(1, new_name);
					pstmt.setDouble(2, new_salary);
					pstmt.setString(3, new_location);
					pstmt.setString(4, new_designation);
					pstmt.setInt(5, new_age);
					pstmt.setInt(6, id);
					int rowsAffected = pstmt.executeUpdate();
					System.out.print(rowsAffected+ "row(s) affected !!\n\n");
				}catch(Exception e) {
					e.printStackTrace();
				}
				break;
			}
			case 4:
			{
				System.out.print("Enter empid: ");
				int id = sc.nextInt();
				con = DBconnection.createConnection();
				String QUERY = "delete from emp where empid = ?";
				try {
					PreparedStatement pstmt = con.prepareStatement(QUERY);
					pstmt.setInt(1, id);
					int rowsAffected = pstmt.executeUpdate();
					System.out.println(rowsAffected + "row(s) affected!!");

				}catch(Exception e){
					e.printStackTrace();
				}
				break;
				}
			case 5:
			{
				System.exit(0);
			}
			}
			
		}

		
		
	}

}
