

import java.awt.geom.Point2D;

import java.awt.Color;
import java.util.ArrayList;

import agandhi523.sheeps.Circle;
import agandhi523.sheeps.Line;
import agandhi523.sheeps.Rectangle;
import agandhi523.sheeps.Shape;
import processing.core.PApplet;


public class DrawingSurfaces extends PApplet {

	private Rectangle rA;
	private Rectangle rB;
	private Circle cA;
	private Circle cB;
	private int mode, pointX, pointY, pointX2, pointY2;
	
	public DrawingSurfaces() {
		rA = null;
		rB = null;
		cA = null;
		cB = null;
		mode = 4;
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
		background(255);   // Clear the screen with a white background
		fill(255);
		textAlign(CENTER);
		
		if (rA != null) {
			stroke(255,0,0);
			fill(255);
			rA.draw(this);
//			Point2D.Double center = rA.getCenter();
			fill(0);
//			System.out.println(("Perimeter A : " + rA.getPerimeter()+"\nArea A: "+rA.getArea()));
//			System.out.println("is point inside rectangle A (red): " + rA.isPointInside(pointX, pointY));
		}
		if (rB != null) {
			stroke(0,255,0);
			fill(255);
			rB.draw(this);
//			Point2D.Double center = rB.getCenter();
			fill(0);
//			System.out.println(("Perimeter B : " + rB.getPerimeter()+"\nArea B: "+rB.getArea()));
//			System.out.println("is point inside rectangle B (green): " + rB.isPointInside(pointX, pointY)); 
		}
		if(rA != null && rB != null) {
			
//			System.out.println("distance between centers: " + rA.distanceBetweenCenters(rB));
			System.out.println("rectangles are touching: " + rA.isTouching(rB));
//			System.out.println("rectangle is contained in: " + rA.isInside(rB));
		}
		
		if (cA != null) {
			stroke(255,0,0);
			fill(255);
			cA.draw(this);
			fill(0);
			System.out.println(("Perimeter A : " + cA.getPerimeter()+"\nArea A: "+cA.getArea()));
			System.out.println("is point inside circle A (red): " + cA.isPointInside(pointX, pointY));
		}
		if (cB != null) {
			stroke(0,255,0);
			fill(255);
			cB.draw(this);
			fill(0);
//			System.out.println(("Perimeter B : " + cB.getPerimeter()+"\nArea B: "+cB.getArea()));
//			System.out.println("is point inside circle B (green): " + cB.isPointInside(pointX, pointY)); 
		}
		if(cA != null && cB != null) {
			
//			System.out.println("distance between centers: " + cA.distanceBetweenCenters(cB));
			System.out.println("circles are touching: " + cA.isTouching(cB));
//			System.out.println("circle is contained in: " + cA.isInside(cB));
		}

		
		
	}
	
	
	public void mousePressed() {
		if (mouseButton == LEFT && mode == 0) {
			pointX = mouseX;
			pointY = mouseY;
		} else if (mouseButton == RIGHT && mode == 0)
			pointX2 = mouseX;
			pointY2 = mouseY;
		if (mouseButton == LEFT && mode == 1) {
			cA = new Circle(mouseX,mouseY,0);
		} else if (mouseButton == RIGHT && mode == 1)
			cB = new Circle(mouseX,mouseY,0);
	}
	
	
	public void mouseDragged() {
		if (mouseButton == LEFT && mode == 0) {
			rA = new Rectangle(pointX,pointY, mouseX-pointX, mouseY-pointY);
			rA.color(Color.WHITE);
			rA.stroker(Color.BLACK);
			rA.strokePower(1);
		} else if (mouseButton == RIGHT && mode == 0) {
			rB = new Rectangle(pointX2,pointY2, mouseX-pointX2, mouseY-pointY2);
			rB.color(Color.WHITE);
			rB.stroker(Color.BLACK);
			rB.strokePower(1);
		}
		else if (mouseButton == LEFT && mode == 1) {
//			cA.setRadius(mouseX,mouseY);
		} else if (mouseButton == RIGHT && mode == 1) {
//			cB.setRadius(mouseX,mouseY);
		}
		else if (mouseButton == LEFT && mode == 2) {
//			rA.setPoint(mouseX,mouseY);
//			rB.setPoint(mouseX, mouseY);
//			pointX = mouseX;
//			pointY = mouseY;
		}
		else if (mouseButton == LEFT && mode == 3) {
//			cA.setPoint(mouseX,mouseY);
//			rB.setPoint(mouseX, mouseY);
//			pointX = mouseX;
//			pointY = mouseY;
		}
	}
	
	public void keyPressed() {
		if(key == 'r') {
			mode = 0;
		}
		else if(key == 'c') {
			mode = 1;
		}
		else if(key == 'p') {
			mode = 2;
		}
		else if(key == 'w') {
			mode = 3;
		}
	}
	
}










