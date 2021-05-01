package core;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

import display.Window;

public class Context {
	private long handle;
	
	public Context(Window handle) {
		this.handle = handle.ID();
	}
	
	public void CreateContext() {
		GLFW.glfwMakeContextCurrent(handle);
		GL.createCapabilities();
		
		System.out.println("Your graphic device info: ");
		System.out.println(GL11.glGetString(GL11.GL_RENDERER));
		System.out.println(GL11.glGetString(GL11.GL_VENDOR));
		System.out.println(GL11.glGetString(GL11.GL_VERSION));
	}
	
	public void SwapBuffers() {
		GLFW.glfwSwapBuffers(handle);
	}
}
