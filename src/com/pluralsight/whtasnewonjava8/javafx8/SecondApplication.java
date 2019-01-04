package com.pluralsight.whtasnewonjava8.javafx8;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

//
// usando Layout pra quando tenho mais de um componente
//
public class SecondApplication extends Application {

	/*
	 Um stage tem que ter uma scene e uma scene tem que estar em um stage
	 A scene possui todos os componentes graficos
	 */
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		Label message1 = new Label("Hello World!");
		message1.setFont(new Font(100));
		
		Label message2 = new Label("Hello World");
		message2.setFont(new Font(100));
		
		VBox vbox = new VBox(message1, message2);
		
		primaryStage.setScene(new Scene(vbox));
		primaryStage.setTitle("Hello");
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch();
	}
	
}
