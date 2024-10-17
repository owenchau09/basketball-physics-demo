import processing.core.PApplet;

public class PhysicsShape {

	private Shape s;
	
	public PhysicsShape(Shape s) {
		this.s = s;
	}
	
	
	
	public void draw(PApplet surface) {
		s.draw(surface);
	}
	
}
