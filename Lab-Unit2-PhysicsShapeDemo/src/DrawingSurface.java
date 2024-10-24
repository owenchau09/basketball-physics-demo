
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

import agandhi523.sheeps.Circle;
import agandhi523.sheeps.Line;
import agandhi523.sheeps.Rectangle;
import agandhi523.sheeps.Shape;
import processing.core.PApplet;


public class DrawingSurface extends PApplet {
	
	private PhysicsShape holding, basketball;
	private Rectangle backboard, hoop, top, left, right, bottom, c1, c2, c3;
	private Line connector3, net1, net2, net3, net4, neth1, neth2, neth3, neth4;
	private ArrayList<PhysicsShape> balls = new ArrayList<PhysicsShape>();
	private ArrayList<Double> cx = new ArrayList<Double>(Collections.nCopies(100, 0.0));
	private ArrayList<Double> cy = new ArrayList<Double>(Collections.nCopies(100, 0.0));
	private ArrayList<Boolean> hold = new ArrayList<Boolean>();
	
	public DrawingSurface() {
		basketball = new PhysicsShape(new Circle(100, 100, 20));
		basketball.color(Color.ORANGE);
		basketball.stroker(Color.BLACK);
		basketball.strokePower(5);
		balls.add(basketball);
		holding = null;

		backboard = new Rectangle(800-15-6, 300-90, 15, 90);
		backboard.color(Color.WHITE);
		backboard.stroker(Color.BLACK);
		backboard.strokePower(3);
		
		c1 = new Rectangle(800-15-6-30, 2.0/3*90+300-90, 30, 0);
		c1.color(Color.WHITE);
		c1.stroker(Color.BLACK);
		c1.strokePower(1);
		
		c2 = new Rectangle(800-15-6-15, 2.0/3*90+300-90+15, 15, 0);
		c2.color(Color.WHITE);
		c2.stroker(Color.BLACK);
		c2.strokePower(1);
		
		c3 = new Rectangle(800-15-6-15, 2.0/3*90+300-90+15, 15, 0);
		c3.color(Color.WHITE);
		c3.stroker(Color.BLACK);
		c3.strokePower(1);
		
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
		
		top = new Rectangle(0, 0, 800, 0);
		bottom = new Rectangle(0, 600, 800, 0);
		left = new Rectangle(0, 0, 0, 600);
		right = new Rectangle(800, 0, 0, 600);
		top.color(Color.WHITE);
		top.stroker(Color.BLACK);
		top.strokePower(1);
		bottom.color(Color.WHITE);
		bottom.stroker(Color.BLACK);
		bottom.strokePower(1);
		left.color(Color.WHITE);
		left.stroker(Color.BLACK);
		left.strokePower(1);
		right.color(Color.WHITE);
		right.stroker(Color.BLACK);
		right.strokePower(1);
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
		
		background(255);

		
		for(int i = 0; i < balls.size(); i++) {
			balls.get(i).act(top, bottom, left, right, c1, c2, backboard, cx.get(i), cy.get(i));
			balls.get(i).draw(this);
		}
		
		
		backboard.draw(this);
		connector3.draw(this);
		c1.draw(this);
		c2.draw(this);
		c3.draw(this);
		
		hoop.draw(this);
		net1.draw(this);
		net2.draw(this);
		net3.draw(this);
		net4.draw(this);
		neth1.draw(this);
		neth2.draw(this);
		neth3.draw(this);
		neth4.draw(this);
		
//		top.draw(this);
//		bottom.draw(this);
//		left.draw(this);
//		right.draw(this);
	}
	
	public void mousePressed() {
		for(int i = 0; i < balls.size(); i++) {
			if(balls.get(i).isPointInside(mouseX, mouseY)) {
				holding = balls.get(i);
				return;
			}
		}
		PhysicsShape ball = new PhysicsShape(new Circle(mouseX, mouseY, 20));
		ball.color(Color.ORANGE);
		ball.stroker(Color.BLACK);
		ball.strokePower(3);
		balls.add(ball);
	}
	
	public void mouseReleased() {
		for(int i = 0; i < balls.size(); i++) {
			if(hold.get(i) == true) {
				cx.set(i, (double) (mouseX-pmouseX));
				cy.set(i, (double) (mouseY-pmouseY));
				holding = null;
			}
			
		}
	}
	
	
}


