import java.awt.Color;

import agandhi523.sheeps.Circle;
import agandhi523.sheeps.Line;
import agandhi523.sheeps.Rectangle;
import agandhi523.sheeps.Shape;
import processing.core.PApplet;

public class PhysicsShape {

	private Shape s, temp;
	
	private double vx, vy;
	private final double gravity = 1.5;
	
	public PhysicsShape(Shape s) {
		this.s = s;
		vx = 0;
		vy = 0;
	}
	
	
	public void draw(PApplet surface) {
		s.draw(surface);
		temp.draw(surface);
	}
	
	public void act(Rectangle top, Rectangle bottom, Rectangle left, Rectangle right, Rectangle c1) {
		s.setPositionX(s.getX() + vx);
		s.setPositionY(s.getY() + vy);
		
		if(s instanceof Circle) {
			Circle c = (Circle) s;
			double radius = c.getPerimeter()/(2*Math.PI);
//			System.out.println(radius);
			Rectangle hitbox = new Rectangle(c.getX()-radius, c.getY()-radius, 2*radius, 2*radius);
			temp = hitbox;
			temp.color(Color.WHITE);
			temp.stroker(Color.BLACK);
			temp.strokePower(1);
			System.out.println((hitbox.isTouching(top) || hitbox.isTouching(bottom) || hitbox.isTouching(left) || hitbox.isTouching(right)));
			if(hitbox.isTouching(top)) {
				s.setPositionY(s.getY() + 5);
			    vy *= -0.8;
			}
			else if(hitbox.isTouching(bottom) || hitbox.isTouching(c1)) {
				s.setPositionY(s.getY() - 5);
			    vy *= -0.8;
			}
			else if(hitbox.isTouching(left)) {
				s.setPositionX(s.getX() + 5);
			    vx *= -0.8; 
			}
			else if(hitbox.isTouching(right)) {
				s.setPositionX(s.getX() - 5);
			    vx *= -0.8; 
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
