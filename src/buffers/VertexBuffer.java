package buffers;

import static org.lwjgl.opengl.GL15.*;

import java.nio.FloatBuffer;

import core.RenderObject;

public class VertexBuffer extends RenderObject {
	public VertexBuffer() {
		id = glGenBuffers();
		if(id == GL_FALSE)return;
	}
	
	public void Data(FloatBuffer data) {
		Bind();
		if(id != GL_FALSE)glBufferData(id, data, GL_ARRAY_BUFFER);
	}
	
	@Override
	public void Bind() {
		if(id != GL_FALSE)glBindBuffer(id, GL_ARRAY_BUFFER);
	}
	
	@Override
	public void Unbind() {
		glBindBuffer(0, GL_ARRAY_BUFFER);
	}
}
