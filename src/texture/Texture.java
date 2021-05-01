package texture;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;

import java.nio.ByteBuffer;

import core.RenderObject;

public class Texture extends RenderObject {
	private int width, height;
	
	public Texture(int width, int height) {
		id = glGenTextures();
		if(id == GL_FALSE)return;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void Bind() {
		if(id != GL_FALSE)glBindTexture(id, GL_TEXTURE_2D);
	}
	
	@Override
	public void Unbind() {
		glBindTexture(0, GL_TEXTURE_2D);
	}
	
	public void Create(ByteBuffer data) {
		Bind();
		if(id != GL_FALSE) {
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
			glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, this.width, this.height, 0, 
				GL_RGBA, GL_UNSIGNED_BYTE, data);
		}
		Unbind();
	}
	
	public static void Enable() {
		glEnable(GL_TEXTURE0);
	}
	
	public static void Disable() {
		glDisable(GL_TEXTURE0);
	}

	public int GetWidth() {
		return width;
	}
	
	public int GetHeight() {
		return height;
	}
}
