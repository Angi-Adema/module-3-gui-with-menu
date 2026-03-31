package com.angiadema.guiwithmenu;

import java.awt.Color;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GUIWithMenu extends Application {
	
	// Set variables for BorderPane, TextArea and Color
	private BorderPane borderPane;
	private TextArea textArea;
	private Color greenHue;
	
	@Override
	public void start(Stage stage) {
		
		// Add a title to the GUI
		stage.setTitle("GUI Menu App");
		
		// Create a menu bar with menu of options
		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("Menu");
		
		// Create menu items
		MenuItem opt1 = new MenuItem("Display Date & Time");
		MenuItem opt2 = new MenuItem("Save Text to log.txt");
		MenuItem opt3 = new MenuItem("Change Background to Green");
		MenuItem opt4 = new MenuItem("Exit");
	}

	public static void main(String[] args) {
		launch(args);

	}

}
