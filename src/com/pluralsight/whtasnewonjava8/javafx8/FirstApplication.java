package com.pluralsight.whtasnewonjava8.javafx8;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FirstApplication extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		Label message = new Label("Hello World");
		message.setFont(new Font(50));
		
		stage.setScene(new Scene(message));
		stage.setTitle("Hello");
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch();
	}
	
}