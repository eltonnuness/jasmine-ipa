
package com.jasmine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jasmine.core.JasmineBrain;
import com.jasmine.core.JasmineMindsHandler;
import com.jasmine.model.User;
import com.jasmine.service.collector.CollectorServiceHandler;

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
	@Autowired
	private CollectorServiceHandler collectorServiceHandler;
	@FXML
	private TextField txtUserMinds;
	@FXML
	private Button btnSay;
	@FXML
	private Stage primaryStage;
	@Autowired
	private JasmineMindsHandler jasmineMinds;
	@Autowired
	private JasmineBrain jasmineBrain;
	private User user;

	@FXML
	private void initialize() {
		this.jasmineMinds.setTextArea(this.txtAreaJasmineMinds);
		this.collectorServiceHandler.startAllCollectors(this.user);
		this.jasmineBrain.start(this.user);
	}

	public void setPrimaryStage(Stage stage) {
		this.primaryStage = stage;
	}

	public Stage getPrimaryStage() {
		return this.primaryStage;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
