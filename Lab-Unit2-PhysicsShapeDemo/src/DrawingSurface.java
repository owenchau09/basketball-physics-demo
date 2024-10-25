import java.awt.Color;
import java.util.ArrayList;
import agandhi523.sheeps.Circle;
import agandhi523.sheeps.Line;
import agandhi523.sheeps.Rectangle;
import processing.core.PApplet;


public class DrawingSurface extends PApplet {
	
	private PhysicsShape holding, basketball, holdingb;
	private Rectangle backboard, hoop, top, left, right, bottom, c1, c2, c3, leftedge;
	private Line connector3, net1, net2, net3, net4, neth1, neth2, neth3, neth4;
	private ArrayList<PhysicsShape> balls = new ArrayList<PhysicsShape>();
	private ArrayList<PhysicsShape> boxes = new ArrayList<PhysicsShape>();
	private ArrayList<Double> cx = new ArrayList<Double>();
	private ArrayList<Double> cy = new ArrayList<Double>();
	private ArrayList<Boolean> hold = new ArrayList<Boolean>();
	private ArrayList<Double> pMouseX = new ArrayList<Double>();
	private ArrayList<Double> pMouseY = new ArrayList<Double>();
	private ArrayList<Double> cxb = new ArrayList<Double>();
	private ArrayList<Double> cyb = new ArrayList<Double>();
	private ArrayList<Boolean> holdb = new ArrayList<Boolean>();
	private ArrayList<Double> pMouseXb = new ArrayList<Double>();
	private ArrayList<Double> pMouseYb = new ArrayList<Double>();
	private int mode = 0;
	
	
	public DrawingSurface() {
		basketball = new PhysicsShape(new Circle(100, 100, 20));
		basketball.color(new Color(250,131,32));
		basketball.stroker(Color.BLACK);
		basketball.strokePower(5);
		balls.add(basketball);
		hold.add(false);
		cx.add(0.0);
		cy.add(0.0);
		pMouseX.add(null);
		pMouseY.add(null);
		holding = null;

		double s = 2.0;

		backboard = new Rectangle(800-15*s, 300-90*s, 15*s-2*s, 90*s);
		backboard.color(Color.WHITE);
		backboard.stroker(Color.BLACK);
		backboard.strokePower(3);
		
		c1 = new Rectangle(800-15*s-30*s, 2.0/3*90*s+300-90*s, 30*s, 0);
		c1.color(Color.RED);
		c1.stroker(Color.RED);
		c1.strokePower(1);
		
		c2 = new Rectangle(800-15*s-15*s, 2.0/3*90*s+300-90*s+15*s, 15*s, 0);
		c2.color(Color.RED);
		c2.stroker(Color.RED);
		c2.strokePower(1);
		
		c3 = new Rectangle(800-15*s-15*s, 2.0/3*90*s+300-90*s+15*s, 15*s, 0);
		c3.color(Color.RED);
		c3.stroker(Color.RED);
		c3.strokePower(1);
		
		connector3 = new Line(800-15*s-15*s, 2.0/3*90*s+300-90*s+15*s, 800-15*s-30*s, 2.0/3*90*s+300-90*s+5*s);
		connector3.color(Color.RED);
		connector3.stroker(Color.RED);
		connector3.strokePower(1);
		
		hoop = new Rectangle(800-15*s-30*s-50*s, 2.0/3*90*s+300-90*s, 50*s, 5*s);
		hoop.color(Color.RED);
		hoop.stroker(Color.BLACK);
		hoop.strokePower(1);
		
		leftedge = new Rectangle(800-15*s-30*s-50*s, 2.0/3*90*s+300-90*s, 0, 5*s);
		leftedge.color(Color.BLUE);
		leftedge.stroker(Color.BLACK);
		leftedge.strokePower(1);
		
		
		net1 = new Line(800-15*s-30*s-50*s+2*s, 2.0/3*90*s+300-90*s+5, 800-15*s-30*s+7*s-50*s, 2.0/3*90*s+300-90*s+40*s+5);
		net1.color(Color.WHITE);
		net1.stroker(Color.BLACK);
		net1.strokePower(1);
		
		net2 = new Line(800-15*s-30*s+50*s-50*s-2*s, 2.0/3*90*s+300-90*s+5, 800-15*s-50*s-30*s+50*s-7*s, 2.0/3*90*s+300-90*s+40*s+5);
		net2.color(Color.WHITE);
		net2.stroker(Color.BLACK);
		net2.strokePower(1);
		
		net3 = new Line(800-15*s-50*s-30*s+50*3.5/12*s, 2.0/3*90*s+300-90*s+5, 800-15*s-50*s-30*s+50*3.5/12*s+3*s, 2.0/3*90*s+300-90*s+40*s+5);
		net3.color(Color.WHITE);
		net3.stroker(Color.BLACK);
		net3.strokePower(1);
		
		net4 = new Line(800-15*s-30*s-50*s+50*s-50*3.5/12*s, 2.0/3*90*s+300-90*s+5, 800-15*s-30*s-50*s+50*s-50*3.5/12*s-3*s, 2.0/3*90*s+300-90*s+40*s+5);
		net4.color(Color.WHITE);
		net4.stroker(Color.BLACK);
		net4.strokePower(1);
//		y = 8x - 4667 for 1st diag
//		y = -8x + 5,893 for 2nd diag
		neth1 = new Line(800-15*s-30*s-50*s+2*s+2, 8*(800-15*s-30*s-50*s+2*s+2)-4667, 704, 8*(800-15*s-30*s-50*s+2*s+2)-4667);
		neth1.color(Color.WHITE);
		neth1.stroker(Color.BLACK);
		neth1.strokePower(1);
		
		neth2 = new Line(800-15*s-30*s-50*s+2*s+4, 8*(800-15*s-30*s-50*s+2*s+4)-4667, 702, 8*(800-15*s-30*s-50*s+2*s+4)-4667);
		neth2.color(Color.WHITE);
		neth2.stroker(Color.BLACK);
		neth2.strokePower(1);
		
		neth3 = new Line(800-15*s-30*s-50*s+2*s+6, 8*(800-15*s-30*s-50*s+2*s+6)-4667, 700, 8*(800-15*s-30*s-50*s+2*s+6)-4667);
		neth3.color(Color.WHITE);
		neth3.stroker(Color.BLACK);
		neth3.strokePower(1);
		
		neth4 = new Line(800-15*s-30*s-50*s+2*s+8, 8*(800-15*s-30*s-50*s+2*s+8)-4667, 698, 8*(800-15*s-30*s-50*s+2*s+8)-4667);
		neth4.color(Color.WHITE);
		neth4.stroker(Color.BLACK);
		neth4.strokePower(1);



		
		top = new Rectangle(0, 0, 800, 0);
		bottom = new Rectangle(0, 600, 800, -5);
		left = new Rectangle(0, 0, 0, 600);
		right = new Rectangle(800, 0, 0, 600);
		top.color(Color.WHITE);
		top.stroker(Color.BLACK);
		top.strokePower(1);
		bottom.color(new Color(153, 0, 2));
		bottom.stroker(new Color(153, 0, 2));
		bottom.strokePower(5);
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
			balls.get(i).act(top, bottom, left, right, c1, c2, backboard, cx.get(i), cy.get(i), hoop, leftedge);
			balls.get(i).draw(this);
		}
		
		if(boxes.size() > 0) {
			for(int i = 0; i < boxes.size(); i++) {
				boxes.get(i).act(top, bottom, left, right, c1, c2, backboard, cxb.get(i), cyb.get(i), hoop, leftedge);
				boxes.get(i).draw(this);
			}
		}
		
		
		backboard.draw(this);
		connector3.draw(this);
		c1.draw(this);
		c2.draw(this);
		c3.draw(this);
		
		net1.draw(this);
		net2.draw(this);
		net3.draw(this);
		net4.draw(this);
		neth1.draw(this);
		neth2.draw(this);
		neth3.draw(this);
		neth4.draw(this);
		hoop.draw(this);
		
//		top.draw(this);
		bottom.draw(this);
//		left.draw(this);
//		right.draw(this);
		
//		leftedge.draw(this);
		textSize(16);
		fill(0);
		text("Press c for ball mode and r for box mode!\nHold mouse on a ball/box to move it around. The further you drag it, the faster it'll go (gravity affected). \nClick outside of the object to spawn a new ball/box. Try to score on the hoop!" + "\nCurrent Score: " + PhysicsShape.score, 30, 40);
	}
	
	public void mousePressed() {
		if(mode == 0) {
			for(int i = 0; i < balls.size(); i++) {
				if(balls.get(i).isPointInside(mouseX, mouseY)) {
					holding = balls.get(i);
					hold.set(i, true);
					pMouseX.set(i, (double) mouseX);
					pMouseY.set(i, (double) mouseY);
					return;
				}
			}
			PhysicsShape ball = new PhysicsShape(new Circle(mouseX, mouseY, 20));
			ball.color(new Color(250,131,32));
			ball.stroker(Color.BLACK);
			ball.strokePower(5);
			balls.add(ball);
			hold.add(false);
			cx.add(0.0);
			cy.add(0.0);
			pMouseX.add((double) mouseX);
			pMouseY.add((double) mouseY);
		}
		else if(mode == 1) {
			for(int i = 0; i < boxes.size(); i++) {
				if(boxes.get(i).isPointInside(mouseX, mouseY)) {
					holdingb = boxes.get(i);
					holdb.set(i, true);
					pMouseXb.set(i, (double) mouseX);
					pMouseYb.set(i, (double) mouseY);
					return;
				}
			}
			PhysicsShape box = new PhysicsShape(new Rectangle(mouseX, mouseY, 50, 50));
			box.color(Color.CYAN);
			box.stroker(Color.BLACK);
			box.strokePower(5);
			boxes.add(box);
			holdb.add(false);
			cxb.add(0.0);
			cyb.add(0.0);
			pMouseXb.add((double) mouseX);
			pMouseYb.add((double) mouseY);
		}
	}
	
	public void keyPressed() {
		if(key == 'c') {
			mode = 0;
		}
		if(key == 'r') {
			mode = 1;
		}
	}
	
	public void mouseReleased() {
		if(mode == 0) {
			for(int i = 0; i < balls.size(); i++) {
				if(hold.get(i) == true) {
					cx.set(i, (double) (mouseX-pMouseX.get(i)));
					cy.set(i, (double) (mouseY-pMouseY.get(i)));
					hold.set(i, false);
					balls.get(i).accelerate(cx.get(i), cy.get(i));
					holding = null;
				}
				
			}
		}
		else if(mode == 1) {
			for(int i = 0; i < boxes.size(); i++) {
				if(holdb.get(i) == true) {
					cxb.set(i, (double) (mouseX-pMouseXb.get(i)));
					cyb.set(i, (double) (mouseY-pMouseYb.get(i)));
					holdb.set(i, false);
					boxes.get(i).accelerate(cxb.get(i), cyb.get(i));
					holdingb = null;
				}
				
			}
		}
	}
	
	
}


