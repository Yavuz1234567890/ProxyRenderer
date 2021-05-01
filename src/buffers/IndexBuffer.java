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
		glBufferData(GL_ELEMENT_ARRAY_BUFFER, data, GL_STATIC_DRAW);
	}
	
	@Override
	public void Bind() {
		if(id != GL_FALSE)glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, id);
	}
	
	@Override
	public void Unbind() {
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
	}
}
