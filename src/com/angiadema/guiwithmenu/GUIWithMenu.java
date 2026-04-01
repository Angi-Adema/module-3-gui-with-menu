package com.angiadema.guiwithmenu;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;

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
		
		// Save a single green hue for whole program
		greenHue = randomGreenHue();
		
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
		opt2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				writeTextToFile();
			}
		});
		
		// MenuItem 3: Change background color to a hue of green
		opt3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				setBackgroundColor(greenHue);
			}
		});
		
		// MenuItem 4: Exit the program
		opt4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.close();
			}
		});
		
		// Add the menu items to the menu and the menu to the menu bar
		menu.getItems().add(opt1);
		menu.getItems().add(opt2);
		menu.getItems().add(opt3);
		menu.getItems().add(opt4);
		
		menuBar.getMenus().add(menu);
		
		// Add the MenuBar and TextArea to the BorderPane
		borderPane.setTop(menuBar);
		borderPane.setCenter(textArea);
		
		// Initialize a new Scene object, set the size, and show the scene
		Scene scene = new Scene(borderPane, 500, 300);
		stage.setScene(scene);
		stage.show();
		
	}
		
		// Method to write text to a file
		private void writeTextToFile() {
			try (FileWriter writer = new FileWriter("log.txt")) {
				writer.write(textArea.getText());
				textArea.appendText("\n\nText successfully saved in log.txt.");
			} catch (IOException e) {
				textArea.appendText("\n\nError writing the text to file.");
			}
			
		}
		
		// Method to randomly select a hue of green
		private Color randomGreenHue() {
			// Use Random class to select a random number
			Random random = new Random();
			
			// Color falls between 0 - 360 with green around 120
			// Set a range to select from of 100 - 140
			double hue = 100 + random.nextDouble() * 40;
			
			// Set saturation to be between 0.7 - 1.0
			double saturation = 0.7 + random.nextDouble() * 0.3;
			
			// Set brightness to be between 0.7 - 1.0
			double brightness = 0.7 + random.nextDouble() * 0.3;
			
			// Return the color
			return Color.hsb(hue, saturation, brightness);
		}
		
		// Method to set the background color
		private void setBackgroundColor(Color color) {
			borderPane.setBackground(new Background(new BackgroundFill(color, null, null)));
		}

	public static void main(String[] args) {
		launch(args);

	}

}
