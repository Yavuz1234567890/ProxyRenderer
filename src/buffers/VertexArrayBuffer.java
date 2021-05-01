package buffers;

import static org.lwjgl.opengl.GL30.*;

public class VertexArrayBuffer {
	private int id;
	
	public VertexArrayBuffer() {
		id = glGenVertexArrays();
		if(id == GL_FALSE)return;
	}
	
	public void Bind() {
		if(id != GL_FALSE)glBindVertexArray(id);
	}
	
	public void Unbind() {
		glBindVertexArray(0);
	}
	
	public int ID() {
		return id;
	}
}
