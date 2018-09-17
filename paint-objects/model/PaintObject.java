package model;

import java.awt.Point;
import java.io.Serializable;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * PaintObject
 * 
 * <p>
 * A PaintObject is an abstract class defining a shape that can be drawn with
 * two points
 * <p>
 * 
 * @author Pratyush Singh
 *
 */
public abstract class PaintObject implements Serializable {

	protected Color color;
	protected Point from, to;

	public PaintObject(Point from, Point to) {
		this.from = from;
		this.to = to;
	}

	public PaintObject(Color color, Point from, Point to) {
		this.color = color;
		this.from = from;
		this.to = to;
	}

	public void setTo(Point to) {
		this.to = to;
	}

	public String toString() {
		return this.getClass().toString();
	}

	// Each ImageObject will be drawn differently using Java's Graphics or
	// Graphics2D object
	// with their draw messages and Shape objects
	public abstract void draw(GraphicsContext g);
}