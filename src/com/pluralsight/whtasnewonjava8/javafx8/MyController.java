package com.pluralsight.whtasnewonjava8.javafx8;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MyController implements Initializable {

	// essas anotacoes sao a injecao de dependecia do JavaFX
	@FXML
	private TextField username;
	
	@FXML
	private PasswordField password;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void okAction(ActionEvent event) {
		
		System.out.println("Click ok button. Username: " + username.getText());
		
	}

	public void cancelAction(ActionEvent event) {

		System.out.println("Click cancel button. Password: " + password.getText());
		
	}

}
