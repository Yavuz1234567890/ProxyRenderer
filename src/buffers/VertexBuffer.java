package buffers;

import static org.lwjgl.opengl.GL15.*;

import java.nio.FloatBuffer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

import core.RenderObject;

public class VertexBuffer extends RenderObject {
	public VertexBuffer() {
		id = glGenBuffers();
		if(id == GL_FALSE)return;
	}
	
	public void Data(FloatBuffer data) {
		Bind();
		glBufferData(GL_ARRAY_BUFFER, data, GL_STATIC_DRAW);
	}
	
	@Override
	public void Bind() {
		if(id != GL_FALSE)glBindBuffer(GL_ARRAY_BUFFER, id);
	}
	
	@Override
	public void Unbind() {
		glBindBuffer(GL_ARRAY_BUFFER, id);
	}
	
	public static void VertexAttribPointer(int index, int size) {
		GL20.glVertexAttribPointer(index, size, GL11.GL_FLOAT, false, 0, 0);
	}
}
