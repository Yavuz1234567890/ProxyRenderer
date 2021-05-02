package core;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.GL;

public class Renderer {
	public static void Clear() {
		glClear(GL_COLOR_BUFFER_BIT);
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
	}
	
	public static void ClearColor(Color color) {
		glClear(GL_COLOR_BUFFER_BIT);
		glClearColor(color.R(), color.G(), color.B(), color.A());
	}
	
	public static void Blend() {
		Enable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	}
	
	public static void Enable(int enable) {
		glEnable(enable);
	}
	
	public static void Disable(int disable) {
		glDisable(disable);
	}
	
	public static void Viewport(int x, int y, int width, int height) {
		glViewport(x, y, width, height);
	}
}
