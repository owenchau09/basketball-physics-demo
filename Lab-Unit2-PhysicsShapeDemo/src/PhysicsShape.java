import java.awt.Color;

import agandhi523.sheeps.Circle;
import agandhi523.sheeps.Line;
import agandhi523.sheeps.Rectangle;
import agandhi523.sheeps.Shape;
import processing.core.PApplet;

public class PhysicsShape {

	private Shape s;
	
	private double vx, vy;
	private final double gravity = 1.5;
	
	public PhysicsShape(Shape s) {
		this.s = s;
		vx = 0;
		vy = 0;
	}
	
	
	public void draw(PApplet surface) {
		s.draw(surface);
	}
	
	public void act(Rectangle top, Rectangle bottom, Rectangle left, Rectangle right) {
		s.setPositionX(s.getX() + vx);
		s.setPositionY(s.getY() + vy);
		
		if(s instanceof Circle) {
			Circle c = (Circle) s;
			Rectangle hitbox = new Rectangle(c.getX()-c.getPerimeter()/(2*Math.PI), c.getY()-c.getPerimeter()/(2*Math.PI), 2*c.getPerimeter()/(2*Math.PI), 2*c.getPerimeter()/(2*Math.PI));
			if(hitbox.isTouching(top) || hitbox.isTouching(bottom) || hitbox.isTouching(left) || hitbox.isTouching(right)) {
				vx *= -1;
				vy *= -1;
			}
		}
		
		
	}
	
	public void accelerate(double cvelx, double cvely) {
		vx = (vx + cvelx*1.3);
		vy = (-vy + cvely*1.3 + gravity);
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
	
//	public boolean isCircleTouchingLine(Shape s) {
//		if(s instanceof Circle) {
//			
//		}
//		else if(s instanceof Line) {
//			
//		}	
//	}
}
