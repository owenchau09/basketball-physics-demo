import processing.core.PApplet;

public class PhysicsShapeDemo {

	public static void main(String args[]) {
		DrawingSurfaces drawing = new DrawingSurfaces();
		PApplet.runSketch(new String[]{""}, drawing);
		drawing.windowResizable(true);
	}
	
}
