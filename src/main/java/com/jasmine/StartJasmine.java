package com.jasmine;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jasmine.conf.JasmineFactory;
import com.jasmine.conf.SpringFxmlLoader;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StartJasmine extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JasmineFactory.class);

		SpringFxmlLoader loader = new SpringFxmlLoader(context);

		Pane root = (Pane) loader.loadLogin("/fxml/login.fxml", primaryStage);
		Scene stackScene = new Scene(root);
		primaryStage.setScene(stackScene);
		primaryStage.setTitle("Jasmine IPA - Login");
		primaryStage.show();

	}

}
