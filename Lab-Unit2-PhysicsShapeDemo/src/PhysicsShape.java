import java.awt.Color;

import agandhi523.sheeps.Shape;
import processing.core.PApplet;

public class PhysicsShape {

	private Shape s;
	
	private double vx, vy;
	private final double gravity = 5;
	
	public PhysicsShape(Shape s) {
		this.s = s;
		vx = 0;
		vy = 0;
	}
	
	
	
	public void draw(PApplet surface) {
		s.draw(surface);
	}
	
	public void act() {
		s.setPositionX(s.getX() + vx);
		s.setPositionY(s.getY() + vy);
		
	}
	
	public void accelerate(double cvelx, double cvely) {
		vx += cvelx;
		vy = (vy + cvely + gravity);
	}
	
	public void color(Color color) {
		s.color(color);
	}
	
	public void stroker(Color color) {
		s.stroker(color);
	}
	
	public void strokePower(int power) {
		s.strokePower(power);
	}
	
	public boolean isPointInside(double x, double y) {
		return s.isPointInside(x, y);
	}
}
