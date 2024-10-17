
import java.awt.Color;

import agandhi523.sheeps.Rectangle;
import processing.core.PApplet;


public class DrawingSurface extends PApplet {

	private PhysicsShape shape, holding;
	
	
	public DrawingSurface() {
		shape = new PhysicsShape(new Rectangle(100, 100, 50, 50));
		shape.color(Color.WHITE);
		shape.stroker(Color.BLACK);
		shape.strokePower(5);
		holding = null;
	}
	
	public void settings() {
		setSize(800,600);
	}
	
	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {

	}
	
	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() {
		
		shape.act();
		
		background(255);
		shape.draw(this);
	}
	
	public void mousePressed() {
		if(shape.isPointInside(mouseX, mouseY)) {
//			shape.accelerate(0.5, 0);
			holding = shape;
		}
	}
	
	public void mouseReleased() {
		if(holding != null) {
			holding.accelerate(mouseX-pmouseX, mouseY-pmouseY);
			holding = null;
		}
	}
	
	
}


