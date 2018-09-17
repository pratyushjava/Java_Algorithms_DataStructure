//@author: Pratyush Singh
package view_controller;

import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

// This is a event driven program with a graphical user interface 
// to play the game of Boggle. This code begins as the boilerplate
// code that is needed to start any JavaFX application.  It also
// has a recommended GridPane as the backing pane to store the
// DiceTray on the left and a GridPane with three elements on the right.
//
// @author Rick Mercer and Shivansh Singh Chauhan
//
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.BoggleGame;
import model.DiceTray;

public class BoggleMain extends Application {

	private static DiceTray tray;
	private char diceTrayLocal[][];
	private Button newGame;
	private Button endGame;
	private TextArea textField;
	private Label labelTray;
	private static BoggleGame game;

	public static void main(String[] args) {
		tray = new DiceTray();
		game = new BoggleGame(tray);
		launch(args);

	}

	private GridPane window = new GridPane();
	private GridPane windowTextArea = new GridPane();
	private GridPane windowButton = new GridPane();

	public void start(Stage stage) {
		stage.setTitle("BOGGLE GAME");
		setUpWindow();
		BorderPane window1 = new BorderPane();
		window1.setLeft(window);
		window1.setRight(windowTextArea);
		Scene scene = new Scene(window1, 300, 150);
		stage.setScene(scene);
		stage.show();

		EventHandler<ActionEvent> buttonNewGameHandler = new ButtonHandlerNewGame();
		newGame.setOnAction(buttonNewGameHandler);

		EventHandler<ActionEvent> buttonEndGameHandler = new ButtonHandlerEndGame();
		endGame.setOnAction(buttonEndGameHandler);
	}

	private void startNewGame() {
		tray = new DiceTray();
		game = new BoggleGame(tray);
	}

	private void setUpWindow() {
		window = new GridPane();
		window.setHgap(10);
		window.setVgap(10);
		// Add a label to column 0, row 0
		labelTray = new Label(getDiceTray());
		window.add(labelTray, 0, 0);
		// Add a label to column 1, row 0
		/*
		 * window.add(new Label("             middle            "), 1, 0); // Add a
		 * label to column 2, row 0 window.add(new Label("               right side"),
		 * 2, 0);
		 */

		windowTextArea = new GridPane();
		windowTextArea.setHgap(10);
		windowTextArea.setVgap(10);
		newGame = new Button("New Game");
		endGame = new Button("End Game");
		textField = new TextArea();
		textField.setMaxSize(200, 100);
		windowTextArea.add(new Label("Enter Your Words Below:"), 0, 0);

		windowTextArea.add(textField, 0, 1);

		windowButton = new GridPane();
		windowButton.setHgap(10);
		windowButton.setVgap(10);

		windowButton.add(newGame, 0, 0);
		windowButton.add(endGame, 1, 0);

		windowTextArea.add(windowButton, 0, 2);

	}

	private String getDiceTray() {
		diceTrayLocal = tray.getDiceTray();
		String tray = "  ";
		for (int i = 0; i < diceTrayLocal.length; i++) {
			for (int j = 0; j < diceTrayLocal[i].length; j++) {
				tray += diceTrayLocal[i][j] + "    ";
			}
			tray += "\n  ";
		}

		return tray;
	}

	private String getContentText(Set<String> words) {
		StringBuilder contentText = new StringBuilder();
		contentText.append("Your score: " + game.computeScore(words));
		contentText.append("\n");
		contentText.append("Words you found: \n \n");
		Set<String> correctWords = game.getCorrectWord();
		LinkedList<String> possibleWord = game.getPossibleWords();
		for (String word : correctWords) {
			contentText.append(word + " ");
			possibleWord.remove(new String(word));
		}
		contentText.append("\n");
		contentText.append("\n");
		contentText.append("Incorrect words: \n \n");
		Set<String> wrongWords = game.getWrongWord();
		for (String word : wrongWords) {
			contentText.append(word + " ");
		}
		contentText.append("\n");
		contentText.append("\n");

		contentText.append("You could have found " + possibleWord.size() + " more words: \n \n");

		for (String str : possibleWord) {
			contentText.append(str + " ");
		}

		return contentText.toString();
	}

	private class ButtonHandlerNewGame implements EventHandler<ActionEvent> {

		public void handle(ActionEvent ae) {

			startNewGame();
			labelTray.setText(getDiceTray());
			textField.setText("");

		}
	}

	private class ButtonHandlerEndGame implements EventHandler<ActionEvent> {

		public void handle(ActionEvent ae) {

			Set<String> words = new TreeSet<String>();

			String enteredWords = textField.getText();

			String delimeter = " \n\r\t,.;";
			StringTokenizer st = new StringTokenizer(enteredWords, delimeter);
			while (st.hasMoreTokens()) {
				words.add(st.nextToken());
			}

			String contentText = getContentText(words);

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Results");
			alert.setHeaderText("Here is your score");
			alert.setContentText(contentText);

			alert.showAndWait();

		}
	}
}