package com.angiadema.guiwithmenu;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;

public class GUIWithMenu extends Application {
	
	// Set variables for BorderPane, TextArea and Color
	private BorderPane borderPane;
	private TextArea textArea;
	private Color greenHue;
	private double greenHueValue;
	
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
		MenuItem option1 = new MenuItem("Display Date & Time");
		MenuItem option2 = new MenuItem("Save Text to log.txt");
		MenuItem option3 = new MenuItem("Change Background to Green");
		MenuItem option4 = new MenuItem("Exit");
		
		// MenuItem 1: Print Date and Time to TextArea
		option1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				LocalDateTime now = LocalDateTime.now();
				DateTimeFormatter formatter = 
						DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
				textArea.setText("Current date and time: " + now.format(formatter));
			}
		});
		
		// MenuItem 2: Write TextArea content to log.txt
		option2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				writeTextToFile();
			}
		});
		
		// MenuItem 3: Change background color to a hue of green
		option3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				setBackgroundColor(greenHue);
				
				// Display the initial random hue value each time selected
				textArea.appendText("\nBackground hue value: " + greenHueValue);
			}
		});
		
		// MenuItem 4: Exit the program
		option4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.close();
			}
		});
		
		// Add the menu items to the menu and the menu to the menu bar
		menu.getItems().add(option1);
		menu.getItems().add(option2);
		menu.getItems().add(option3);
		menu.getItems().add(option4);
		
		menuBar.getMenus().add(menu);
		
		// Add the MenuBar and TextArea to the BorderPane
		borderPane.setTop(menuBar);
		
		VBox box = new VBox();
		box.setAlignment(Pos.CENTER);
		
		// Set a smaller size for TextArea
		textArea.setMaxWidth(300);
		textArea.setMaxHeight(150);
		
		box.getChildren().add(textArea);
		
		borderPane.setCenter(box);
		
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
			// Save hue number in the TextArea
			greenHueValue = 100 + random.nextDouble() * 40;
			
			// Set saturation to be between 0.7 - 1.0
			double saturation = 0.7 + random.nextDouble() * 0.3;
			
			// Set brightness to be between 0.7 - 1.0
			double brightness = 0.7 + random.nextDouble() * 0.3;
			
			// Return the color
			return Color.hsb(greenHueValue, saturation, brightness);
		}
		
		// Method to set the background color
		private void setBackgroundColor(Color color) {
			borderPane.setBackground(new Background(new BackgroundFill(color, null, null)));
		}

	public static void main(String[] args) {
		launch(args);

	}

}
