//@Author: Pratyush Singh
package model;

import java.awt.Point;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Oval extends PaintObject {

	public Oval(Color color, Point from, Point to) {
		super(color, from, to);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(color);
		int minX = (int) Math.min(from.getX(), to.getX());
		int maxX = (int) Math.max(from.getX(), to.getX());

		int minY = (int) Math.min(from.getY(), to.getY());
		int maxY = (int) Math.max(from.getY(), to.getY());

		gc.fillOval(minX, minY, Math.abs(super.to.getX() - super.from.getX()) + 1,
				Math.abs(super.to.getY() - super.from.getY()) + 1);

	}

}
