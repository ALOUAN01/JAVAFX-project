package application;

import java.util.Date;

public class Guests {
		
		private int id;
	    private String firstname;
	    private String lastname;
	    private String phone;
	    private String Email;
	    private String password;

	    public Guests(int Id, String fname, String lname, String email, String password,String phone){
	        this.id = Id;
	    	this.firstname=fname;
	    	this.lastname=lname;
	    	this.Email=email;
	    	this.password=password;
	    	this.phone=phone;
	    	
	    	
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getEmail() {
			return Email;
		}

		public void setEmail(String email) {
			Email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		

		
	   
	


}
