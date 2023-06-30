package emswebapp;

public class Employee {

	
		private int empid;
		private String name;
		private double salary;
		private String location;
		private String designation;
		private int age;
		
		
		public Employee(int empid, String name, double salary, String location, String designation, int age) {
			super();
			this.empid = empid;
			this.name = name;
			this.salary = salary;
			this.location = location;
			this.designation = designation;
			this.age = age;
		}
		
		
		public int getEmpid() {
			return empid;
		}
		public void setEmpid(int empid) {
			this.empid = empid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getDesignation() {
			return designation;
		}
		public void setDesignation(String designation) {
			this.designation = designation;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}


	
		
		

	

}
