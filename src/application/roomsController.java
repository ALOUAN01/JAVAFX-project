package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import application.Rooms;
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

public class roomsController implements Initializable{
	
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
    private TextField rnf;
    
    @FXML
    private TextField rtf;

    @FXML
    private TextField bnf;

    @FXML
    private TextField avf;

    @FXML
    private TextField raf;

    @FXML
    private Button add;

    @FXML
    private Button update;

    @FXML
    private Button delete;

    @FXML
    private TableView<Rooms> tableView;
    
    @FXML
    private TableColumn<Rooms, Integer> RoomID;
    
    @FXML
    private TableColumn<Rooms, String> RoomNumber;
    
    @FXML
    private TableColumn<Rooms, String> RoomType;
    
    @FXML
    private TableColumn<Rooms, String> BedNumbers;

    @FXML
    private TableColumn<Rooms, String> Availability;
    
    @FXML
    private TableColumn<Rooms, String> Rate;
	
	@FXML
    private void handleButtonHome(ActionEvent event) {openHomepage();}
	@FXML
    private void handleButtonEmployee(ActionEvent event) {openEmployee();}
	@FXML
    private void handleButtonGuests(ActionEvent event) {openGuest();}
	
	@FXML
    private void handleButtonRoom(ActionEvent event) { openRoom();}
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
    	 String query = "INSERT INTO rooms(RoomNumber,RoomType,BedNumbers,Availability,Rate) VALUES (?, ?, ?, ?, ?)";
    	 Connection conn = getConnection();
    	    try (PreparedStatement prst = conn.prepareStatement(query)) {
    	        
    	        prst.setString(1, rnf.getText());
    	        prst.setString(2, rtf.getText());
    	        prst.setString(3, bnf.getText());
    	        prst.setString(4, avf.getText());
    	        prst.setString(5, raf.getText());	    	        	        	    	    
    	        prst.executeUpdate();
    	        System.out.println("Record inserted successfully");
    	    } catch (SQLException | NumberFormatException e) {
    	        e.printStackTrace();	    	        
    	    }	    	    
    	    showRooms();
    	}

 @FXML 
    private void update() {
    	 String query = "UPDATE employee SET employee_name=?, position=?, contact_number=?, email=? WHERE empid=?";
    	    Connection conn = getConnection();
    	    try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
    	       // preparedStatement.setString(1, fname.getText());
    	     //   preparedStatement.setString(2, lname.getText());
    	       // preparedStatement.setString(3, phone.getText());
    	        //preparedStatement.setString(4, Email.getText());
    	        //preparedStatement.setInt(5, Integer.parseInt(id.getText()));

    	        preparedStatement.executeUpdate();

    	        System.out.println("Record updated successfully");
    	    } catch (SQLException | NumberFormatException e) {
    	        e.printStackTrace();
    	        // Handle the exception appropriately
    	    }

    	    showRooms();
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
    
    public ObservableList<Rooms> getRoomsList(){
    	ObservableList<Rooms> RoomsList = FXCollections.observableArrayList();
    	Connection connection = getConnection();
    	String query = "SELECT * FROM rooms ";
    	Statement st;
    	ResultSet rs;
    	
    	try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			Rooms Rooms;
			while(rs.next()) {
				Rooms = new Rooms(rs.getInt("RoomID"),rs.getString("RoomNumber"),rs.getString("RoomType"),rs.getString("BedNumbers"),rs.getString("Availability"),rs.getString("Rate"));
				RoomsList.add(Rooms);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return RoomsList;
    }
    
    // I had to change ArrayList to ObservableList I didn't find another option to do this but this works :)
    public void showRooms() {
    	ObservableList<Rooms> list = getRoomsList();
    	RoomID.setCellValueFactory(new PropertyValueFactory<Rooms,Integer>("RoomID"));
    	RoomNumber.setCellValueFactory(new PropertyValueFactory<Rooms,String>("RoomNumber"));
    	RoomType.setCellValueFactory(new PropertyValueFactory<Rooms,String>("RoomType"));
    	BedNumbers.setCellValueFactory(new PropertyValueFactory<Rooms,String>("BedNumbers"));
    	Availability.setCellValueFactory(new PropertyValueFactory<Rooms,String>("Availability"));
    	Rate.setCellValueFactory(new PropertyValueFactory<Rooms,String>("Rate"));
    	tableView.setItems(list);
    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		showRooms();		
     
		}
	
	
	
	
	 @FXML
	    private void delete() {
	           Rooms selectedRoom = tableView.getSelectionModel().getSelectedItem();

	        if (selectedRoom != null) {
	            
	            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	            alert.setTitle("Confirmation de suppression");
	            alert.setHeaderText("Voulez-vous vraiment supprimer cet employé?");
	            alert.setContentText("Nom: " + selectedRoom.getRoomNumber() + "\nID: " + selectedRoom.getRoomID());

	           
	            alert.showAndWait().ifPresent(response -> {
	                if (response == ButtonType.OK) {
	                	String query = "DELETE FROM rooms WHERE RoomID="+ selectedRoom.getRoomID()+"";
	        	    	executeQuery(query);
	                    tableView.getItems().remove(selectedRoom);
	                    showRooms();
	                    

	                   
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
	          Rooms selectedRoom = tableView.getSelectionModel().getSelectedItem();

	        if (selectedRoom!= null) {
	            
	          
	        } else {
	            
	            Alert alert = new Alert(Alert.AlertType.WARNING);
	            alert.setTitle("Aucune sélection");
	            alert.setHeaderText("Aucun employé sélectionné");
	            alert.setContentText("Veuillez sélectionner un employé à supprimer.");
	            alert.showAndWait();
	        }
	    }
	
	
	
	
	

}
