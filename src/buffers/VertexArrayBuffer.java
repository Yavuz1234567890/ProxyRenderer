package buffers;

import static org.lwjgl.opengl.GL30.*;

import org.lwjgl.opengl.GL11;

import core.RenderObject;

public class VertexArrayBuffer extends RenderObject {
	public VertexArrayBuffer() {
		id = glGenVertexArrays();
		if(id == GL_FALSE)return;
	}
	
	public void RenderElements(int count) {
		GL11.glDrawElements(GL11.GL_TRIANGLES, count, GL11.GL_UNSIGNED_INT, 0);
	}
	
	public void RenderArray(int count) {
		GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, count);
	}
	
	public void StartDraw() {
		Bind();
		if(id != GL_FALSE) {
			glEnableVertexAttribArray(0);
			glEnableVertexAttribArray(1);
		}
	}
	
	public void EndDraw() {
		if(id != GL_FALSE) {
			glDisableVertexAttribArray(0);
			glDisableVertexAttribArray(1);
		}
		Unbind();
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
