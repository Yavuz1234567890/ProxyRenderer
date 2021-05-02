package core;

public class Color {
	private float r, g, b, a;
	
	public Color() {}
	
	public Color(float r, float g, float b, float a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}
	
	public Color(Color color) {
		this.r = color.r;
		this.g = color.g;
		this.b = color.b;
		this.a = color.a;
	}
	
	public void Set(float r, float g, float b, float a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}
	
	public void Set(Color color) {
		this.r = color.r;
		this.g = color.g;
		this.b = color.b;
		this.a = color.a;
	}
	
	public float R() {
		return r;
	}
	
	public float G() {
		return g;
	}
	
	public float B() {
		return b;
	}
	
	public float A() {
		return a;
	}
}
