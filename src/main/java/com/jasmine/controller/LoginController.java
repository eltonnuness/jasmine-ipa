package com.jasmine.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jasmine.conf.JasmineFactory;
import com.jasmine.conf.SpringFxmlLoader;
import com.jasmine.model.User;
import com.jasmine.service.UserService;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Controller of the main login window
 * @author enunes
 * @since 29/09/2016
 *
 */
public class LoginController {

	@Autowired private UserService userService;
	@FXML private TextField txtLogin;
	@FXML private PasswordField txtPassword;
	
	private Stage primaryStage;
	
	@FXML
	private void login(){
		User user = userService.login(txtLogin.getText(), txtPassword.getText());
		if (user != null){
			openHome();
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Error");
			alert.setContentText("User not found.");
			alert.show();
		}
	}

	/**
	 * Open the home.
	 */
	private void openHome(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JasmineFactory.class);
		SpringFxmlLoader loader = new SpringFxmlLoader(context);
		
		try{
			Stage newStage = new Stage();		//Create a new Window(Stage)
			StackPane root = (StackPane) loader.loadHome("/fxml/home.fxml",newStage);
			Scene stackScene = new Scene(root);
			newStage.setScene(stackScene);
			newStage.setTitle("Jasmine IPA - Core");
			newStage.show();
			primaryStage.close();	//Close the previous window
			this.primaryStage = newStage; 	//Set the new stage on primaryStage variable.
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	@FXML
	private void exit(){
		System.exit(1);
	}
	
	/**
	 * Method helper to set the primary stage.
	 * @param stage new stage.
	 */
	public void setPrimaryStage(Stage stage){
		this.primaryStage = stage;
	}
	
}
