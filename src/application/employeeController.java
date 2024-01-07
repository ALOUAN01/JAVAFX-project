package application;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class employeeController implements Initializable{
	
	@FXML
	 private Button home;
	@FXML
	 private Button employee;
	@FXML
	 private Button guest;
	@FXML
	 private Button room;
	@FXML
	 private Button reservation;
	@FXML
	 private Button payment;
	@FXML
    private TextField namef;
    
    @FXML
    private TextField positionf;

    @FXML
    private TextField emailf;

    @FXML
    private TextField phonef;

    @FXML
    private TextField datef;

    @FXML
    private Button add;

    @FXML
    private Button update;

    @FXML
    private Button delete;

    @FXML
    private TableView<Employee> tableView;
    
    @FXML
    private TableColumn<Employee, Integer> id;
    
    @FXML
    private TableColumn<Employee, String> Name;

    @FXML
    private TableColumn<Employee, String> Position;

    @FXML
    private TableColumn<Employee, String> Email;

    @FXML
    private TableColumn<Employee, String> phone;
    @FXML
    private TableColumn<Employee, String> HireDate;
	
	
	
	
	
	
	
	
	
	@FXML
    private void handleButtonHome(ActionEvent event){openHomepage();}
	@FXML
    private void handleButtonEmployee(ActionEvent event){openEmployee();}
	@FXML
    private void handleButtonGuests(ActionEvent event){openGuest();}
	@FXML
    private void handleButtonRoom(ActionEvent event){openRoom();}
	@FXML
    private void handleButtonReservation(ActionEvent event) { openReservation();}
	@FXML
    private void handleButtonPayment(ActionEvent event) { openPayment(); }
	
	private void openHomepage() {
	    try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("homepage.fxml"));
	        Parent root = loader.load();
	        Stage stage = new Stage();
	        stage.setScene(new Scene(root));
	        stage.setTitle("Homepage");
	        stage.show();
	        Stage currentStage = (Stage) home.getScene().getWindow();
	        currentStage.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	       
	    }
	}
	private void openEmployee() {
	    try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("employee.fxml"));
	        Parent root = loader.load();
	        Stage stage = new Stage();
	        stage.setScene(new Scene(root));
	        stage.setTitle("Employeespage");
	        stage.show();
	        Stage currentStage = (Stage) employee.getScene().getWindow();
	        currentStage.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	       
	    }
	}
	private void openGuest() {
	    try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("guest.fxml"));
	        Parent root = loader.load();
	        Stage stage = new Stage();
	        stage.setScene(new Scene(root));
	        stage.setTitle("Guestspage");
	        stage.show();
	        Stage currentStage = (Stage) guest.getScene().getWindow();
	        currentStage.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	       
	    }
	}
	private void openRoom() {
	    try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("room.fxml"));
	        Parent root = loader.load();
	        Stage stage = new Stage();
	        stage.setScene(new Scene(root));
	        stage.setTitle("Roompage");
	        stage.show();
	        Stage currentStage = (Stage) room.getScene().getWindow();
	        currentStage.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	       
	    }
	}
	
	private void openReservation() {
	    try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("reservation.fxml"));
	        Parent root = loader.load();
	        Stage stage = new Stage();
	        stage.setScene(new Scene(root));
	        stage.setTitle("ReservationPage");
	        stage.show();
	        Stage currentStage = (Stage) reservation.getScene().getWindow();
	        currentStage.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	       
	    }
	}
	private void openPayment() {
	    try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("payment.fxml"));
	        Parent root = loader.load();
	        Stage stage = new Stage();
	        stage.setScene(new Scene(root));
	        stage.setTitle("ReservationPage");
	        stage.show();
	        Stage currentStage = (Stage) payment.getScene().getWindow();
	        currentStage.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	       
	    }
	}
	
	
	  @FXML
	    private void add() {
	    	 String query = "INSERT INTO employee (employee_name, position,contact_number,email,  hire_date) VALUES (?, ?, ?, ?, ?)";
	    	 Connection conn = getConnection();
	    	    try (PreparedStatement prst = conn.prepareStatement(query)) {
	    	        
	    	        prst.setString(1, namef.getText());
	    	        prst.setString(2, positionf.getText());
	    	        prst.setString(3, phonef.getText());
	    	        prst.setString(4, emailf.getText());
	    	        prst.setDate(5, java.sql.Date.valueOf(datef.getText()));

	    	        // Execute the statement
	    	        prst.executeUpdate();

	    	        System.out.println("Record inserted successfully");
	    	    } catch (SQLException | NumberFormatException e) {
	    	        e.printStackTrace();
	    	        
	    	    }
	    	    
	    	    showEmployee();
	    	}
	
	
	 @FXML 
	    private void update() {
	    	 String query = "UPDATE employee SET employee_name=?, position=?, contact_number=?, email=? WHERE empid=?";
	    	    Connection conn = getConnection();
	    	    try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
	    	        preparedStatement.setString(1, Name.getText());
	    	        preparedStatement.setString(2, Position.getText());
	    	        preparedStatement.setString(3, phone.getText());
	    	        preparedStatement.setString(4, Email.getText());
	    	        preparedStatement.setInt(5, Integer.parseInt(id.getText()));

	    	        preparedStatement.executeUpdate();

	    	        System.out.println("Record updated successfully");
	    	    } catch (SQLException | NumberFormatException e) {
	    	        e.printStackTrace();
	    	        // Handle the exception appropriately
	    	    }

	    	    showEmployee();
	    }
	    
	    @FXML
	    private void delete() {
	    	String query = "DELETE FROM employee WHERE ID="+id.getText()+"";
	    	executeQuery(query);
	    	showEmployee();
	    }
	    
	    public void executeQuery(String query) {
	    	Connection conn = getConnection();
	    	Statement st;
	    	try {
				st = conn.createStatement();
				st.executeUpdate(query);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	   
	    
	    public Connection getConnection() {
	    	Connection conn;
	    	try {
	    		Class.forName("com.mysql.cj.jdbc.Driver");
	    		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","1213");
	    		return conn;
	    	}
	    	catch (Exception e){
	    		e.printStackTrace();
	    		return null;
	    	}
	    }
	    
	    public ObservableList<Employee> getEmployeeList(){
	    	ObservableList<Employee> EmployeeList = FXCollections.observableArrayList();
	    	Connection connection = getConnection();
	    	String query = "SELECT * FROM employee ";
	    	Statement st;
	    	ResultSet rs;
	    	
	    	try {
				st = connection.createStatement();
				rs = st.executeQuery(query);
				Employee Employee;
				while(rs.next()) {
					Employee = new Employee(rs.getInt("empid"),rs.getString("employee_name"),rs.getString("position")
							,rs.getString("contact_number"),rs.getString("email"),rs.getString("hire_date"));
					EmployeeList.add(Employee);
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	return EmployeeList;
	    }
	    
	    // I had to change ArrayList to ObservableList I didn't find another option to do this but this works :)
	    public void showEmployee() {
	    	ObservableList<Employee> list = getEmployeeList();
	    	
	    	id.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("id"));
	    	Name.setCellValueFactory(new PropertyValueFactory<Employee,String>("Name"));
	    	Position.setCellValueFactory(new PropertyValueFactory<Employee,String>("Position"));
	    	Email.setCellValueFactory(new PropertyValueFactory<Employee,String>("Email"));
	    	phone.setCellValueFactory(new PropertyValueFactory<Employee,String>("phone"));
	    	HireDate.setCellValueFactory(new PropertyValueFactory<Employee,String>("HireDate"));
	    	
	    	tableView.setItems(list);
	    }


		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			showEmployee();
			Employee selectedEmployee = tableView.getSelectionModel().getSelectedItem();

	        if (selectedEmployee != null) {
	            
	        	namef.setText(selectedEmployee.getName());
	        } 
			
		}
		
		
		
		
		 @FXML
		    private void supprimerEmploye() {
		           Employee selectedEmployee = tableView.getSelectionModel().getSelectedItem();

		        if (selectedEmployee != null) {
		            
		            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		            alert.setTitle("Confirmation de suppression");
		            alert.setHeaderText("Voulez-vous vraiment supprimer cet employé?");
		            alert.setContentText("Nom: " + selectedEmployee.getName() + "\nID: " + selectedEmployee.getId());

		           
		            alert.showAndWait().ifPresent(response -> {
		                if (response == ButtonType.OK) {
		                	String query = "DELETE FROM employee WHERE empid="+selectedEmployee.getId()+"";
		        	    	executeQuery(query);
		                    tableView.getItems().remove(selectedEmployee);
		                    showEmployee();                    
		                }
		            });
		        } else {
		            
		            Alert alert = new Alert(Alert.AlertType.WARNING);
		            alert.setTitle("Aucune sélection");
		            alert.setHeaderText("Aucun employé sélectionné");
		            alert.setContentText("Veuillez sélectionner un employé à supprimer.");
		            alert.showAndWait();
		        }
		    }
		 
		 
		 @FXML
		    private void updateEmploye() {
		           Employee selectedEmployee = tableView.getSelectionModel().getSelectedItem();

		        if (selectedEmployee != null) {
		        	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		            alert.setTitle("Confirmation de suppression");
		            alert.setHeaderText("Voulez-vous vraiment supprimer cet employé?");
		            alert.setContentText("Nom: " + selectedEmployee.getName() + "\nID: " + selectedEmployee.getId());

		           
		            alert.showAndWait().ifPresent(response -> {
		                if (response == ButtonType.OK) {
		                	String query = "UPDATE employee SET employee_name=?, position=?, contact_number=?, email=? , hire_date=? WHERE empid=?";
				    	    Connection conn = getConnection();
				    	    try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
				    	        preparedStatement.setString(1, namef.getText());
				    	        preparedStatement.setString(2, positionf.getText());
				    	        preparedStatement.setString(3, phonef.getText());
				    	        preparedStatement.setString(4, emailf.getText());
				    	        preparedStatement.setDate(5, java.sql.Date.valueOf(datef.getText()));
				    	        preparedStatement.setInt(6, selectedEmployee.getId());

				    	        preparedStatement.executeUpdate();

				    	        System.out.println("Record updated successfully");
				    	    } catch (SQLException | NumberFormatException e) {
				    	        e.printStackTrace();
				    	        // Handle the exception appropriately
				    	    }

				    	    showEmployee();                   
		                }
		            });
		        	
		        	
		        	
		       	 
		        	
		            
		          
		        } else {
		            
		            Alert alert = new Alert(Alert.AlertType.WARNING);
		            alert.setTitle("Aucune sélection");
		            alert.setHeaderText("Aucun employé sélectionné");
		            alert.setContentText("Veuillez sélectionner un employé à supprimer.");
		            alert.showAndWait();
		        }
		    }
		 
		 public void Export(ActionEvent e) {
		    	ObservableList<Employee> EmployeeList1=getEmployeeList();
		    	System.out.print("wag wan0");
		    	exportToCSV(EmployeeList1);

		    	System.out.print("wag wan1");
		    }
		 
		 
		 public static void exportToCSV(ObservableList<Employee> EmployeeList) {
			 
			 
			 List<Employee> people= new ArrayList<>(EmployeeList);
			 try (PrintWriter writer = new PrintWriter(new File("C:\\Users\\ayoub\\Desktop\\file.csv"))) {
				 
				   StringBuilder sb = new StringBuilder();
		            sb.append("Id; Name; Position; Email; PhoneNumber;HireDate\n"); 

		            for (Employee E : people) {
		                sb.append(E.getId()).append(";")
		                        .append(E.getName()).append(";")
		                        .append(E.getPosition()).append(";")
		                        .append(E.getEmail()).append(";")
		                        .append(E.getPhone()).append(";")
		                        .append(E.getHireDate()).append(";")
		                        .append("\n");
		            }
		       System.out.print("wag wan2");
		            writer.write(sb.toString());

				 
			 } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		 }
		 
		 public void importer(ActionEvent e) {
			 importFromCSV("C:\\Users\\ayoub\\Desktop\\file.csv");
			 showEmployee();   
			 
		 }
		 public static void importFromCSV(String filePath) {
		        try (BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)))) {
		            String line;
		            reader.readLine(); // Skip header line

		            while ((line = reader.readLine()) != null) {
		                String[] data = line.split(";");
		                Employee employee = new Employee();
		                employee.setId(Integer.parseInt(data[0]));
		                employee.setName(data[1]);
		                employee.setPosition(data[2]);
		                employee.setEmail(data[3]);
		                employee.setPhone(data[4]);
		                employee.setHireDate(data[5]);
		               

		                insertEmployeeIntoDatabase(employee);
		            }

		            System.out.println("Data imported successfully.");

		        } catch (IOException | SQLException e) {
		            e.printStackTrace();
		        }
		    }
		 private static void insertEmployeeIntoDatabase(Employee employee) throws SQLException {
		        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","1213")) {
		            String sql = "INSERT INTO employee (employee_name, position,email,contact_number,hire_date) VALUES ( ?, ?, ?, ? ,?)";
		            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
		              
		                preparedStatement.setString(1, employee.getName());
		                preparedStatement.setString(2, employee.getPosition());
		                preparedStatement.setString(3, employee.getEmail());
		                preparedStatement.setString(4, employee.getPhone());
		                preparedStatement.setDate(5,  java.sql.Date.valueOf(employee.getHireDate()));

		                preparedStatement.executeUpdate();
		            }
		        }
		    }
		 
		 
		 
		 
		 
		    	
		  
		 
		 
		 

	

}
