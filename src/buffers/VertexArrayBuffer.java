package buffers;

import static org.lwjgl.opengl.GL30.*;

import core.RenderObject;

public class VertexArrayBuffer extends RenderObject {
	public VertexArrayBuffer() {
		id = glGenVertexArrays();
		if(id == GL_FALSE)return;
	}
	
	@Override
	public void Bind() {
		if(id != GL_FALSE)glBindVertexArray(id);
	}
	
	@Override
	public void Unbind() {
		glBindVertexArray(0);
	}
}
