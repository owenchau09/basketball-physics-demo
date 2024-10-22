
import java.awt.Color;

import agandhi523.sheeps.Circle;
import agandhi523.sheeps.Line;
import agandhi523.sheeps.Rectangle;
import agandhi523.sheeps.Shape;
import processing.core.PApplet;


public class DrawingSurface extends PApplet {

	private PhysicsShape holding, basketball;
	private Rectangle backboard, hoop;
	private Line connector1, connector2, connector3, net1, net2, net3, net4, neth1, neth2, neth3, neth4;
	
	
	public DrawingSurface() {
//		shape = new PhysicsShape(new Rectangle(100, 100, 50, 50));
//		shape.color(Color.WHITE);
//		shape.stroker(Color.BLACK);
//		shape.strokePower(5);
		
		basketball = new PhysicsShape(new Rectangle(100, 100, 50, 50));
		basketball.color(Color.ORANGE);
		basketball.stroker(Color.BLACK);
		basketball.strokePower(5);
		holding = null;
		

		backboard = new Rectangle(800-15-6, 300-90, 15, 90);
		backboard.color(Color.WHITE);
		backboard.stroker(Color.BLACK);
		backboard.strokePower(3);
		
		connector1 = new Line(800-15-6-30, 2.0/3*90+300-90, 800-15-6, 2.0/3*90+300-90);
		connector1.color(Color.WHITE);
		connector1.stroker(Color.BLACK);
		connector1.strokePower(1);
		
		connector2 = new Line(800-15-6-15, 2.0/3*90+300-90+15, 800-15-6, 2.0/3*90+300-90+15);
		connector2.color(Color.WHITE);
		connector2.stroker(Color.BLACK);
		connector2.strokePower(1);
		
		connector3 = new Line(800-15-6-15, 2.0/3*90+300-90+15, 800-15-6-30, 2.0/3*90+300-90+5);
		connector3.color(Color.WHITE);
		connector3.stroker(Color.BLACK);
		connector3.strokePower(1);
		
		hoop = new Rectangle(800-15-6-30-50, 2.0/3*90+300-90, 50, 5);
		hoop.color(Color.WHITE);
		hoop.stroker(Color.BLACK);
		hoop.strokePower(1);
		
		net1 = new Line(800-15-6-30-50+2, 2.0/3*90+300-90+5, 800-15-6-30-50+7, 2.0/3*90+300-90+40+5);
		net1.color(Color.WHITE);
		net1.stroker(Color.BLACK);
		net1.strokePower(1);
				
		net2 = new Line(800-15-6-30-50+50-2, 2.0/3*90+300-90+5, 800-15-6-30-50+50-7, 2.0/3*90+300-90+40+5);
		net2.color(Color.WHITE);
		net2.stroker(Color.BLACK);
		net2.strokePower(1);
		
		net3 = new Line(800-15-6-30-50+50*3.5/12, 2.0/3*90+300-90+5, 800-15-6-30-50+50*3.5/12+3, 2.0/3*90+300-90+40+5);
		net3.color(Color.WHITE);
		net3.stroker(Color.BLACK);
		net3.strokePower(1);
		
		net4 = new Line(800-15-6-30-50+50-50*3.5/12, 2.0/3*90+300-90+5, 800-15-6-30-50+50-50*3.5/12-3, 2.0/3*90+300-90+40+5);
		net4.color(Color.WHITE);
		net4.stroker(Color.BLACK);
		net4.strokePower(1);
		
		//	y = 8x - 5333
		neth1 = new Line(800-15-6-30-50+2+1, 8*(800-15-6-30-50+2+1)-5333, 746, 8*(800-15-6-30-50+2+1)-5333);
		neth1.color(Color.WHITE);
		neth1.stroker(Color.BLACK);
		neth1.strokePower(1);
		
		neth2 = new Line(800-15-6-30-50+2+2, 8*(800-15-6-30-50+2+2)-5333, 745, 8*(800-15-6-30-50+2+2)-5333);
		neth2.color(Color.WHITE);
		neth2.stroker(Color.BLACK);
		neth2.strokePower(1);
		
		neth3 = new Line(800-15-6-30-50+2+3, 8*(800-15-6-30-50+2+3)-5333, 744, 8*(800-15-6-30-50+2+3)-5333);
		neth3.color(Color.WHITE);
		neth3.stroker(Color.BLACK);
		neth3.strokePower(1);
		
		neth4 = new Line(800-15-6-30-50+2+4, 8*(800-15-6-30-50+2+4)-5333, 743, 8*(800-15-6-30-50+2+4)-5333);
		neth4.color(Color.WHITE);
		neth4.stroker(Color.BLACK);
		neth4.strokePower(1);
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
		
		basketball.act();
		
		background(255);
		basketball.draw(this);
		
		backboard.draw(this);
		connector1.draw(this);
		connector2.draw(this);
		connector3.draw(this);
		
		hoop.draw(this);
		net1.draw(this);
		net2.draw(this);
		net3.draw(this);
		net4.draw(this);
		neth1.draw(this);
		neth2.draw(this);
		neth3.draw(this);
		neth4.draw(this);
	}
	
	public void mousePressed() {
		if(basketball.isPointInside(mouseX, mouseY)) {
//			shape.accelerate(0.5, 0);
			holding = basketball;
		}
	}
	
	public void mouseReleased() {
		if(holding != null) {
			holding.accelerate(mouseX-pmouseX, mouseY-pmouseY);
			holding = null;
		}
	}
	
	
}


