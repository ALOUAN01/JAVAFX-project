package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;
import application.Reservation;
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

public class reservationController implements Initializable{
	
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
	private TextField guid;
    @FXML
    private TextField rmid;
    @FXML
    private TextField indate;
    @FXML
    private TextField outdate;
    
    
    @FXML
    private Button add;

    @FXML
    private Button update;

    @FXML
    private Button delete;

    
    @FXML
    private TableView<Reservation> tableView;
    @FXML
    private TableColumn<Reservation, Integer> GuestID;
    @FXML
    private TableColumn<Reservation, String> LasteName;
    @FXML
    private TableColumn<Reservation, String> FirstName;
    @FXML
    private TableColumn<Reservation, String> RoomID;
    @FXML
    private TableColumn<Reservation, String> RoomNumber;
    @FXML
    private TableColumn<Reservation, String> ReservationID;
	@FXML
    private TableColumn<Reservation, String> CheckInDate;
    @FXML
    private TableColumn<Reservation, String> CheckOutDate;
    @FXML
    private TableColumn<Reservation, String> PaymentID;
    @FXML
    private TableColumn<Reservation, String> Amount;
    @FXML
    private TableColumn<Reservation, String> PaymentDate;
	
	
	
	
	
	
	@FXML
    private void handleButtonHome(ActionEvent event){openHomepage();}
	@FXML
    private void handleButtonEmployee(ActionEvent event){openEmployee();}
	@FXML
    private void handleButtonGuests(ActionEvent event){openGuest();}
	@FXML
    private void handleButtonRoom(ActionEvent event){openRoom();}
	@FXML
    private void handleButtonReservation(ActionEvent event) { openReservation(); }
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
	    	 String query = "INSERT INTO reservations (GuestID, RoomID,CheckInDate,CheckOutDate) VALUES (?, ?, ?, ?)";
	    	 Connection conn = getConnection();
	    	    try (PreparedStatement prst = conn.prepareStatement(query)) {
	    	        
	    	        prst.setString(1, guid.getText());
	    	        prst.setString(2, rmid.getText());
	    	        prst.setDate(3, java.sql.Date.valueOf(indate.getText()));
	    	        prst.setDate(4, java.sql.Date.valueOf(outdate.getText()));
	    	        

	    	        // Execute the statement
	    	        prst.executeUpdate();

	    	        System.out.println("Record inserted successfully");
	    	    } catch (SQLException | NumberFormatException e) {
	    	        e.printStackTrace();
	    	        
	    	    }
	    	    
	    	    showReservation();
	    	}
	
	
	 @FXML 
	    private void update() {
			String query = "UPDATE reservations SET GuestID=?, RoomID=?, CheckInDate=?, CheckOutDate=? WHERE ReservationID=?";
	 	    Connection conn = getConnection();
	 	    try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
	 	        preparedStatement.setInt(1, Integer.parseInt(guid.getText()));
	 	        preparedStatement.setInt(2, Integer.parseInt(rmid.getText()));
	 	        preparedStatement.setDate(3,java.sql.Date.valueOf(indate.getText()));
	 	        preparedStatement.setDate(4, java.sql.Date.valueOf(outdate.getText()));
		    	//preparedStatement.setInt(5, Integer.parseInt(id.getText()));

	    	        preparedStatement.executeUpdate();

	    	        System.out.println("Record updated successfully");
	    	    } catch (SQLException | NumberFormatException e) {
	    	        e.printStackTrace();
	    	        // Handle the exception appropriately
	    	    }

	    	    showReservation();
	    }
	    
	    @FXML
	    private void delete() {
	    	//String query = "DELETE FROM employee WHERE ID="";
	    	//executeQuery(query);
	    	showReservation();
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
	    
	    public ObservableList<Reservation> getReservationList(){
	    	ObservableList<Reservation> ReservationList = FXCollections.observableArrayList();
	    	Connection connection = getConnection();
	    	String query = "SELECT * FROM reservations ";
	    	Statement st;
	    	ResultSet rs;
	    	String fn=null;
	    	String ln=null;
	    	String rn=null;
	    	int pid=0;
	    	double moun=0;
	    	Date pd = null;
	    
	    	
	    	try {
				st = connection.createStatement();
				rs = st.executeQuery(query);
				Reservation reservation;
				while(rs.next()) {
					
					
					    String query1 = "select * from guests where GuestID = ?";
			            try (PreparedStatement preparedStatement = connection.prepareStatement(query1)) {
			                preparedStatement.setInt(1, rs.getInt("GuestID"));			              
			                ResultSet resultSet = preparedStatement.executeQuery();
			                if (resultSet.next()) {
			                	ln=resultSet.getString("LastName");
			                	fn=resultSet.getString("FirstName");			                		              		                   
			                } 
			            }
			            String query2 = "select * from rooms where RoomID = ?";
			            try (PreparedStatement preparedStatement1 = connection.prepareStatement(query2)) {
			                preparedStatement1.setInt(1, rs.getInt("RoomID"));			              
			                ResultSet resultSet1 = preparedStatement1.executeQuery();
			                if (resultSet1.next()) {
			                	rn=resultSet1.getString("RoomNumber");
			                				                		              		                   
			                } 
			            }
			            String query3 = "select * from payments where ReservationID = ?";
			            try (PreparedStatement preparedStatement2 = connection.prepareStatement(query3)) {
			                preparedStatement2.setInt(1, rs.getInt("ReservationID"));			              
			                ResultSet resultSet2 = preparedStatement2.executeQuery();
			                if (resultSet2.next()) {
			                	pid=resultSet2.getInt("PaymentID");
			                	moun=resultSet2.getDouble("Amount");
			                	pd=resultSet2.getDate("PaymentDate");
			                				                		              		                   
			                } 
			            }		
					reservation = new Reservation(rs.getInt("ReservationID"),rs.getInt("GuestID"),rs.getInt("RoomID"),pid,rs.getDate("CheckInDate"),rs.getDate("CheckOutDate"),rn,ln,fn,moun,pd);
					ReservationList.add(reservation);
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	return ReservationList;
	    }
	    
	    // I had to change ArrayList to ObservableList I didn't find another option to do this but this works :)
	    public void showReservation() {
	    	ObservableList<Reservation> list = getReservationList();
	    	
	    	GuestID.setCellValueFactory(new PropertyValueFactory<Reservation,Integer>("GuestID"));
	    	LasteName.setCellValueFactory(new PropertyValueFactory<Reservation,String>("LastName"));
	    	FirstName.setCellValueFactory(new PropertyValueFactory<Reservation,String>("FirstName"));
	    	RoomID.setCellValueFactory(new PropertyValueFactory<Reservation,String>("RoomID"));
	    	RoomNumber.setCellValueFactory(new PropertyValueFactory<Reservation,String>("RoomNumber"));
	    	ReservationID.setCellValueFactory(new PropertyValueFactory<Reservation,String>("ReservationID"));
	    	CheckInDate.setCellValueFactory(new PropertyValueFactory<Reservation,String>("CheckInDate"));
	    	CheckOutDate.setCellValueFactory(new PropertyValueFactory<Reservation,String>("CheckOutDate"));
	    	PaymentID.setCellValueFactory(new PropertyValueFactory<Reservation,String>("PaymentID"));
	    	Amount.setCellValueFactory(new PropertyValueFactory<Reservation,String>("Amount"));
	    	PaymentDate.setCellValueFactory(new PropertyValueFactory<Reservation,String>("PaymentDate"));
	    	
	    	tableView.setItems(list);
	    }


		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			showReservation();
			Reservation selectedEmployee = tableView.getSelectionModel().getSelectedItem();

	        if (selectedEmployee != null) {
	            
	        	
	        } 
			
		}
		
		
		
		
		 @FXML
		    private void supprimerEmploye() {
		          Reservation selectedReservation = tableView.getSelectionModel().getSelectedItem();

		        if (selectedReservation != null) {
		            
		            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		            alert.setTitle("Confirmation de suppression");
		            alert.setHeaderText("Voulez-vous vraiment supprimer cet employé?");
		            alert.setContentText("Nom: " + selectedReservation.getLastName() + "\nID: " + selectedReservation.getReservationID());

		           
		            alert.showAndWait().ifPresent(response -> {
		                if (response == ButtonType.OK) {
		                	String query = "DELETE FROM reservations WHERE ReservationID="+ selectedReservation.getReservationID()+"";
		        	    	executeQuery(query);
		        	    	String query1 = "DELETE FROM payments WHERE PaymentID="+ selectedReservation.getPaymentID()+"";
		        	    	executeQuery(query1);
		        	    	
		                    tableView.getItems().remove(selectedReservation);
		                    showReservation();
		                    

		                   
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
		           Reservation selectedReservation = tableView.getSelectionModel().getSelectedItem();

		        if (selectedReservation != null) {
		            
		          
		        } else {
		            
		            Alert alert = new Alert(Alert.AlertType.WARNING);
		            alert.setTitle("Aucune sélection");
		            alert.setHeaderText("Aucun employé sélectionné");
		            alert.setContentText("Veuillez sélectionner un employé à supprimer.");
		            alert.showAndWait();
		        }
		    }

	

}
