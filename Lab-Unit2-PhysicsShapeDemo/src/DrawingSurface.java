
import java.awt.Color;

import agandhi523.sheeps.Line;
import agandhi523.sheeps.Rectangle;
import agandhi523.sheeps.Shape;
import processing.core.PApplet;


public class DrawingSurface extends PApplet {

	private PhysicsShape shape, holding;
	private Rectangle backboard;
	private Line connector1, connector2, connector3;
	
	
	public DrawingSurface() {
		shape = new PhysicsShape(new Rectangle(100, 100, 50, 50));
		shape.color(Color.WHITE);
		shape.stroker(Color.BLACK);
		shape.strokePower(5);
		holding = null;
		

		backboard = new Rectangle(800-15-6, 300-90, 15, 90);
		backboard.color(Color.WHITE);
		backboard.stroker(Color.BLACK);
		backboard.strokePower(3);
		
		connector1 = new Line(800-15-6-30, 3.0/4*90+300-90, 800-15-6, 3.0/4*90+300-90);
		connector1.color(Color.WHITE);
		connector1.stroker(Color.BLACK);
		connector1.strokePower(1);
		
		connector2 = new Line(800-15-6-15, 3.0/4*90+300-90+10, 800-15-6, 3.0/4*90+300-90+10);
		connector2.color(Color.WHITE);
		connector2.stroker(Color.BLACK);
		connector2.strokePower(1);
		
		connector3 = new Line(800-15-6-15, 3.0/4*90+300-90+10, 800-15-6-30, 3.0/4*90+300-90+5);
		connector3.color(Color.WHITE);
		connector3.stroker(Color.BLACK);
		connector3.strokePower(1);
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
		
		backboard.draw(this);
		connector1.draw(this);
		connector2.draw(this);
		connector3.draw(this);
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


