package application;
import application.Guests;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

public class guestsController implements Initializable {
	
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
    private TextField fname;
    
    @FXML
    private TextField lname;

    @FXML
    private TextField emailf;

    @FXML
    private TextField phonef;

    @FXML
    private TextField passwordf;

    @FXML
    private Button add;

    @FXML
    private Button update;

    @FXML
    private Button delete;

    @FXML
    private TableView<Guests> tableView;
    
    @FXML
    private TableColumn<Guests, Integer> id;
    
    @FXML
    private TableColumn<Guests, String> firstname;
    
    @FXML
    private TableColumn<Guests, String> lastname;
    
    @FXML
    private TableColumn<Guests, String> Email;

    @FXML
    private TableColumn<Guests, String> phone;
    
    @FXML
    private TableColumn<Guests, String> password;
	
    
	@FXML
    private void handleButtonHome(ActionEvent event) {openHomepage();}
	@FXML
    private void handleButtonEmployee(ActionEvent event) {openEmployee();}
	@FXML
    private void handleButtonGuests(ActionEvent event) {openGuest();}
	@FXML
    private void handleButtonRoom(ActionEvent event) {openRoom();}
	@FXML
    private void handleButtonReservation(ActionEvent event) {openReservation();}
	@FXML
    private void handleButtonPayment(ActionEvent event) {openPayment();}
	
	
	
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
	    	 String query = "INSERT INTO guests(FirstName,LastName,email,password,PhoneNumber) VALUES (?, ?, ?, ?, ?)";
	    	 Connection conn = getConnection();
	    	    try (PreparedStatement prst = conn.prepareStatement(query)) {
	    	        
	    	        prst.setString(1, fname.getText());
	    	        prst.setString(2, lname.getText());
	    	        prst.setString(3, emailf.getText());
	    	        prst.setString(4, passwordf.getText());
	    	        prst.setString(5, phonef.getText());	    	        	        	    	    
	    	        prst.executeUpdate();
	    	        System.out.println("Record inserted successfully");
	    	    } catch (SQLException | NumberFormatException e) {
	    	        e.printStackTrace();	    	        
	    	    }	    	    
	    	    showGuests();
	    	}
	
	 @FXML 
	    private void update() {
	    	 String query = "UPDATE employee SET employee_name=?, position=?, contact_number=?, email=? WHERE empid=?";
	    	    Connection conn = getConnection();
	    	    try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
	    	        preparedStatement.setString(1, fname.getText());
	    	        preparedStatement.setString(2, lname.getText());
	    	        preparedStatement.setString(3, phone.getText());
	    	        preparedStatement.setString(4, Email.getText());
	    	        preparedStatement.setInt(5, Integer.parseInt(id.getText()));

	    	        preparedStatement.executeUpdate();

	    	        System.out.println("Record updated successfully");
	    	    } catch (SQLException | NumberFormatException e) {
	    	        e.printStackTrace();
	    	        // Handle the exception appropriately
	    	    }

	    	    showGuests();
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
	    
	    public ObservableList<Guests> getGuestsList(){
	    	ObservableList<Guests> GuestsList = FXCollections.observableArrayList();
	    	Connection connection = getConnection();
	    	String query = "SELECT * FROM guests ";
	    	Statement st;
	    	ResultSet rs;
	    	
	    	try {
				st = connection.createStatement();
				rs = st.executeQuery(query);
				Guests Guests;
				while(rs.next()) {
					Guests = new Guests(rs.getInt("GuestID"),rs.getString("FirstName"),rs.getString("LastName"),rs.getString("email"),rs.getString("password"),rs.getString("PhoneNumber"));
					GuestsList.add(Guests);
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	return GuestsList;
	    }
	    
	    // I had to change ArrayList to ObservableList I didn't find another option to do this but this works :)
	    public void showGuests() {
	    	ObservableList<Guests> list = getGuestsList();
	    	id.setCellValueFactory(new PropertyValueFactory<Guests,Integer>("id"));
	    	firstname.setCellValueFactory(new PropertyValueFactory<Guests,String>("firstname"));
	    	lastname.setCellValueFactory(new PropertyValueFactory<Guests,String>("lastname"));
	    	Email.setCellValueFactory(new PropertyValueFactory<Guests,String>("Email"));
	    	phone.setCellValueFactory(new PropertyValueFactory<Guests,String>("phone"));
	    	password.setCellValueFactory(new PropertyValueFactory<Guests,String>("password"));
	    	tableView.setItems(list);
	    }


		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			showGuests();
			

	       
			
		}
		
		
		
		
		 @FXML
		    private void delete() {
		           Guests selectedGuest = tableView.getSelectionModel().getSelectedItem();

		        if (selectedGuest != null) {
		            
		            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		            alert.setTitle("Confirmation de suppression");
		            alert.setHeaderText("Voulez-vous vraiment supprimer cet employé?");
		            alert.setContentText("Nom: " + selectedGuest.getLastname() + "\nID: " + selectedGuest.getId());

		           
		            alert.showAndWait().ifPresent(response -> {
		                if (response == ButtonType.OK) {
		                	String query = "DELETE FROM guests WHERE GuestID="+selectedGuest.getId()+"";
		        	    	executeQuery(query);
		                    tableView.getItems().remove(selectedGuest);
		                    showGuests();
		                    

		                   
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
		          Guests selectedEmployee = tableView.getSelectionModel().getSelectedItem();

		        if (selectedEmployee != null) {
		            
		          
		        } else {
		            
		            Alert alert = new Alert(Alert.AlertType.WARNING);
		            alert.setTitle("Aucune sélection");
		            alert.setHeaderText("Aucun employé sélectionné");
		            alert.setContentText("Veuillez sélectionner un employé à supprimer.");
		            alert.showAndWait();
		        }
		    }
	

}
