package application;

import java.util.Date;

public class Employee {
		
		private int id;
	    private String name;
	    private String position;
	    private String phone;
	    private String email;
	    private String hireDate;

	    public Employee(int Id, String name, String position, String phone, String email,String hireDate){
	        this.id = Id;
	    	this.name = name;
	    	this.position= position;
	    	this.phone= phone;
	    	this.email=email;
	    	this.hireDate=hireDate;
	    }

		public Employee() {
			// TODO Auto-generated constructor stub
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPosition() {
			return position;
		}

		public void setPosition(String position) {
			this.position = position;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getHireDate() {
			return hireDate;
		}

		public void setHireDate(String hireDate) {
			this.hireDate = hireDate;
		}

	   
	


}
