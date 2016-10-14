
package com.jasmine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller da tela principal da Jasmine
 * 
 * @author Élton Nunes - <elton_12_nunes@hotmail.com>
 * @since 14/10/2016
 */
@Component
public class HomeController {

	@FXML
	private TextArea txtAreaJasmineMinds;
	@FXML
	private TextField txtUserMinds;
	@FXML
	private Button btnSay;
	@Autowired
	private Stage primaryStage;

	@FXML
	private void initialize() {
	}

	public void setPrimaryStage(Stage stage) {
		this.primaryStage = stage;
	}

	public Stage getPrimaryStage() {
		return this.primaryStage;
	}

}
