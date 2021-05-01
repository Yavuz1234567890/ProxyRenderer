package core;

public abstract class RenderObject {
	protected int id;
	
	public void Bind() {}
	public void Unbind() {}
	
	public int ID() {
		return id;
	}
}
