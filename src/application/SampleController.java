package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.Stage;

public class SampleController {
	
	
	 	@FXML
	    private TextField usernameField;

	    @FXML
	    private PasswordField passwordField;

	    @FXML
	    private Button signInButton;		
	@FXML
    private void handleButtonAction(ActionEvent event) throws ClassNotFoundException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        System.out.println(username);
 try {     
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hotel","root","1213");
            String query = "select * from admin where username = ? and password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {                    
                    System.out.println("Login successful");
                    openAnotherPage();
               } else {              
                    System.out.println("Login failed");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }		
    }
	private void openAnotherPage() {
	    try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("employee.fxml"));
	        Parent root = loader.load();
	        Stage stage = new Stage();
	        stage.setScene(new Scene(root));
	        stage.setTitle("Another Page");
	        stage.show();
	        Stage currentStage = (Stage) signInButton.getScene().getWindow();
	        currentStage.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	 

	

	
	
	
}