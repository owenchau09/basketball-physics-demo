import java.awt.Color;

import agandhi523.sheeps.Circle;
import agandhi523.sheeps.Line;
import agandhi523.sheeps.Rectangle;
import agandhi523.sheeps.Shape;
import processing.core.PApplet;

public class PhysicsShape {

	private Shape s, tempHitbox;
	public static int score = 0;
	private double vx, vy;
	private final double gravity = 0.07;
	
	public PhysicsShape(Shape s) {
		this.s = s;
		vx = 0;
		vy = 0;
	}
	
	
	public void draw(PApplet surface) {
		s.draw(surface);
//		temp.draw(surface);
	}
	
	public void act(Rectangle top, Rectangle bottom, Rectangle left, Rectangle right, Rectangle c1, Rectangle c2, Rectangle backboard, double cx, double cy, Rectangle hoop, Rectangle leftedge) {
		accelerate(0, 0);
		s.setPositionX(s.getX() + vx);
		s.setPositionY(s.getY() + vy);
		
		
		if(s instanceof Circle) {
			Circle c = (Circle) s;
			double radius = c.getPerimeter()/(2*Math.PI);
			Rectangle hitbox = new Rectangle(c.getX()-radius, c.getY()-radius, 2*radius, 2*radius);
			tempHitbox = hitbox;
			tempHitbox.color(Color.WHITE);
			tempHitbox.stroker(Color.BLACK);
			tempHitbox.strokePower(1);
//			System.out.println((hitbox.isTouching(top) || hitbox.isTouching(bottom) || hitbox.isTouching(left) || hitbox.isTouching(right)));
			
			if(hitbox.isTouching(top) || hitbox.isTouching(c2)) {
				s.setPositionY(s.getY() + 5);
			    vy *= -0.7;
			}
			if(hitbox.isTouching(bottom) || hitbox.isTouching(c1)) {
				s.setPositionY(s.getY() - 5);
			    vy *= -0.7;
			    if(vx == 0 && hitbox.isTouching(c1)) {
			    	vx = -1;
			    }
			}
			if(hitbox.isTouching(left)) {
				s.setPositionX(s.getX() + 5);
			    vx *= -0.7; 
			}
			if(hitbox.isTouching(right) || hitbox.isTouching(backboard) || leftedge.isTouching(hitbox)) {
				if(leftedge.isTouching(hitbox)) {
					if(c.getX() >= leftedge.getX()) {
						vx += 2;
						s.setPositionX(s.getX() + 15);
					}
					else if(c.getX() < leftedge.getX()) {
						vx -= 2;
					}
				}
				s.setPositionX(s.getX() - 5);
			    vx *= -0.7; 
			}
			
			if(hoop.isPointInside(c.getX(), c.getY())) {
				score += 1;
			}
		}
		
		else if(s instanceof Rectangle) {
//				System.out.println((hitbox.isTouching(top) || hitbox.isTouching(bottom) || hitbox.isTouching(left) || hitbox.isTouching(right)));
			
			if(s.isTouching(top) || s.isTouching(c2)) {
				s.setPositionY(s.getY() + 5);
			    vy *= -0.7;
			}
			if(s.isTouching(bottom) || s.isTouching(c1)) {
			    vy *= -0.7;
			    if(vx == 0 && s.isTouching(c1)) {
			    	vx = -1;
			    }
			    s.setPositionY(s.getY() - 5);
			}
			if(s.isTouching(left)) {
				s.setPositionX(s.getX() + 5);
			    vx *= -0.7; 
			}
			if(s.isTouching(right) || s.isTouching(backboard) || leftedge.isTouching(s)) {
				if(leftedge.isTouching(s)) {
					if(s.getX() >= leftedge.getX()) {
						vx += 2;
						s.setPositionX(s.getX() + 15);
					}
					else if(s.getX() < leftedge.getX()) {
						vx -= 2;
					}
				}
				s.setPositionX(s.getX() - 5);
			    vx *= -0.7; 
			}
			
			if(hoop.isPointInside(s.getX(), s.getY())) {
				score += 1;
			}
		}
		
		
	}
	
	public void accelerate(double cvelx, double cvely) {
		vx += cvelx*0.08;
		vy += gravity;
		vy += cvely*0.08;
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
