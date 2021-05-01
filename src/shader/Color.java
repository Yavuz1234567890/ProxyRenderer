package shader;

public class Color {
	private int r, g, b, a;
	
	public Color() {}
	
	public Color(int r, int g, int b, int a) {
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
	
	public void Set(int r, int g, int b, int a) {
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
	
	public int R() {
		return r;
	}
	
	public int G() {
		return g;
	}
	
	public int B() {
		return b;
	}
	
	public int A() {
		return a;
	}
}
