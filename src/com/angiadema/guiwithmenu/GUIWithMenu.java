package com.angiadema.guiwithmenu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GUIWithMenu extends Application {
	
	// Set variables for BorderPane, TextArea and Color
	private BorderPane borderPane;
	private TextArea textArea;
	private Color greenHue;
	
	@Override
	public void start(Stage stage) {
		
		// Set the BorderPane
		borderPane = new BorderPane();
		
		// Set TextArea
		textArea = new TextArea();
		textArea.setEditable(false);
		
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
		
		// MenuItem 1: Print Date and Time to TextArea
		opt1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				LocalDateTime now = LocalDateTime.now();
				DateTimeFormatter formatter = 
						DateTimeFormatter.ofPattern("MM-dd-yy HH:mm:ss");
				textArea.setText("Current date and time: " + now.format(formatter));
			}
		});
		
		// MenuItem 2: Write TextArea content to log.txt
		
		// MenuItem 3: Change background color to a hue of green
		
		// MenuItem 4: Exit the program
		
		// Add all the menu items to the menu and add the menu to the menu bar
		
		
		
		
		
	}

	public static void main(String[] args) {
		launch(args);

	}

}
