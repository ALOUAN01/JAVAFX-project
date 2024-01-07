package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class homePageController {
	
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
    private void handleButtonHome(ActionEvent event) {
		
		 openHomepage();
		 
	}
	
	@FXML
    private void handleButtonEmployee(ActionEvent event) {
		
		openEmployee();
		 
	}
	
	@FXML
    private void handleButtonGuests(ActionEvent event) {
		
		 openGuest();
		 
	}
	
	@FXML
    private void handleButtonRoom(ActionEvent event) {
		
		 openRoom();
		 
	}
	@FXML
    private void handleButtonReservation(ActionEvent event) {
		
		 openReservation();
		 
	}
	@FXML
    private void handleButtonPayment(ActionEvent event) {
		
		 openPayment();
		 
	}
	
	
	
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
	

}
