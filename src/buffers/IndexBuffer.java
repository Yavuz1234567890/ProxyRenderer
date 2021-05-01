package buffers;

import static org.lwjgl.opengl.GL15.*;

import java.nio.IntBuffer;

import core.RenderObject;

public class IndexBuffer extends RenderObject {
	public IndexBuffer() {
		id = glGenBuffers();
		if(id == GL_FALSE)return;
	}
	
	public void Data(IntBuffer data) {
		Bind();
		if(id != GL_FALSE)glBufferData(id, data, GL_ELEMENT_ARRAY_BUFFER);
	}
	
	@Override
	public void Bind() {
		if(id != GL_FALSE)glBindBuffer(id, GL_ELEMENT_ARRAY_BUFFER);
	}
	
	@Override
	public void Unbind() {
		glBindBuffer(0, GL_ELEMENT_ARRAY_BUFFER);
	}
}
