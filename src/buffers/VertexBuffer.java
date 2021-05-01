package buffers;

import static org.lwjgl.opengl.GL15.*;

import java.nio.FloatBuffer;

public class VertexBuffer {
	private int id;
	
	public VertexBuffer() {
		id = glGenBuffers();
		if(id == GL_FALSE)return;
	}
	
	public void Data(FloatBuffer data) {
		Bind();
		if(id != GL_FALSE)glBufferData(id, data, GL_ARRAY_BUFFER);
	}
	
	public void Bind() {
		if(id != GL_FALSE)glBindBuffer(id, GL_ARRAY_BUFFER);
	}
	
	public void Unbind() {
		glBindBuffer(0, GL_ARRAY_BUFFER);
	}
	
	public int ID() {
		return id;
	}
}
