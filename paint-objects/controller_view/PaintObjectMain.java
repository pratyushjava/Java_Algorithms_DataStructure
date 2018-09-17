//@Author: Pratyush Singh
package controller_view;

import java.awt.Point;
import java.util.ArrayList;

import com.sun.swing.internal.plaf.synth.resources.synth_pt_BR;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Line;
import model.Oval;
import model.PaintObject;
import model.Picture;
import model.Rectangle;

/**
 * A GUI for NetPaint that has all PaintObjects drawn on it. This file also
 * represents the controller as it controls how paint objects are drawn.
 * 
 * @author Rick Mercer and Your Name
 */
public class PaintObjectMain extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	// A few needed instance variables
	private ArrayList<PaintObject> allPaintObjects;
	private Canvas drawingPanel;
	private GraphicsContext gc;
	private ColorPicker colorPicker = new ColorPicker();
	private GridPane window = new GridPane();
	private Button bLine;
	private Button bRectangle;
	private Button bOval;
	private Button bPicture;
	private Color color;
	private CurrentPaintObject currentObject;
	private boolean drawingCompleted = true;
	private Point from;
	private Point to;

	// Use this to track the current shape that will
	// be drawn and added the the ArrayList<PaintObject>
	enum CurrentPaintObject {
		LINE, RECTANGLE, OVAL, PICTURE
	}

	private CurrentPaintObject currentShape = CurrentPaintObject.LINE;

	@Override
	public void start(Stage primaryStage) throws Exception {
		colorPicker.setValue(Color.RED);
		color = Color.RED;
		drawingPanel = new Canvas(560, 460);
		addHandlersTo(drawingPanel);
		BorderPane all = new BorderPane();
		all.setCenter(drawingPanel);
		all.setBottom(window);
		window.setHgap(20);
		window.setVgap(20);
		// Add a label to column 0, row 0

		bLine = new Button("Line");
		bRectangle = new Button("Rectangle");
		bOval = new Button("Oval");
		bPicture = new Button("Picture");
		window.add(bLine, 2, 0);
		window.add(bRectangle, 3, 0);
		window.add(bOval, 4, 0);
		window.add(bPicture, 5, 0);
		window.add(colorPicker, 6, 0);

		currentObject = CurrentPaintObject.LINE;

		bLine.setOnAction(event -> {
			currentObject = CurrentPaintObject.LINE;
			trace();
		});
		


		bRectangle.setOnAction(event -> {
			currentObject = CurrentPaintObject.RECTANGLE;
		});

		bOval.setOnAction(event -> {
			currentObject = CurrentPaintObject.OVAL;
		});

		bPicture.setOnAction(event -> {
			currentObject = CurrentPaintObject.PICTURE;
		});

		colorPicker.setOnAction(event -> {
			color = colorPicker.getValue();
		});

		gc = drawingPanel.getGraphicsContext2D();
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, drawingPanel.getWidth(), drawingPanel.getHeight());

		// You don't really need this here. Consider it as a review of JavaFX drawing.
		// drawAllFourTypesOfThings();

		allPaintObjects = new ArrayList<PaintObject>();
		colorPicker.setValue(javafx.scene.paint.Color.RED);

		Scene scene = new Scene(all, 560, 540);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
public void trace() {
	System.out.println("PaintObjectMain.trace()");
}
	private void addHandlersTo(Canvas canvas) {
		canvas.setOnMouseClicked(event -> {
			// Using java.awt.Point because we used it in NetPaint 1
			// Point aPoint = new Point((int) event.getX(), (int) event.getY());
			if (drawingCompleted) {
				from = new Point((int) event.getX(), (int) event.getY());
				drawingCompleted = false;
			} else {
				to = new Point((int) event.getX(), (int) event.getY());
				drawingCompleted = true;
				draw(to);
			}

		});

		canvas.setOnMouseMoved(event -> {
			if (!drawingCompleted) {
				Point aPoint = new Point((int) event.getX(), (int) event.getY());
				draw(aPoint);
			}
		});

	}

	// You Don't need this code. It is provided here as a review of how
	// to draw with JavaFX. Feel free to delete it.
	private void drawAllFourTypesOfThings() {
		// Draw a white background
		gc.setFill(javafx.scene.paint.Color.WHITE);
		gc.fillRect(0, 0, drawingPanel.getWidth(), drawingPanel.getHeight());
		// Draw some things on the canvas
		gc.setFill(javafx.scene.paint.Color.BLUE);
		gc.strokeLine(0, 0, 600, 600);
		gc.fillOval(20, 20, 100, 100);
		gc.fillRect(120, 120, 200, 50);
		String path = "file:images/doge.jpeg";
		Image image = new Image(path, false);
		gc.drawImage(image, 400, 20, 100, 100);
	}

	private void draw(Point aPoint) {
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, drawingPanel.getWidth(), drawingPanel.getHeight());
		for (PaintObject object : allPaintObjects) {
			object.draw(gc);
		}
		if (currentObject == CurrentPaintObject.LINE) {
			PaintObject line = new Line(colorPicker.getValue(), from, aPoint);
			line.draw(gc);
			if (drawingCompleted)
				allPaintObjects.add(line);
		} else if (currentObject == CurrentPaintObject.RECTANGLE) {
			PaintObject rect = new Rectangle(colorPicker.getValue(), from, aPoint);
			rect.draw(gc);
			if (drawingCompleted)
				allPaintObjects.add(rect);
		} else if (currentObject == CurrentPaintObject.OVAL) {
			PaintObject oval = new Oval(colorPicker.getValue(), from, aPoint);
			oval.draw(gc);
			if (drawingCompleted)
				allPaintObjects.add(oval);
		} else if (currentObject == CurrentPaintObject.PICTURE) {
			PaintObject picture = new Picture(from, aPoint, "doge.jpeg");
			picture.draw(gc);
			if (drawingCompleted)
				allPaintObjects.add(picture);
		}
	}
}