package display;

import static org.lwjgl.glfw.GLFW.*;

import java.awt.Dimension;
import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.Callbacks;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL11;

import core.Context;
import core.Renderer;

public class Window {
	private long id;
	private Context context;
	
	private int width, height;
	
	public Window(String title, int startwidth, int startheight) {
		glfwInit();
		id = glfwCreateWindow(startwidth, startheight, title, GLFW_FALSE, GLFW_FALSE);
		if(id == GLFW_FALSE)System.err.println("Window creation failed!");
		GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(id, (vidmode.width() - startwidth) / 2, 
				(vidmode.height() - startheight) / 2);
		context = new Context(this);
		context.CreateContext();
		
		glfwSetWindowSizeCallback(id, this::windowSizeCallback);
	}
	
	private void windowSizeCallback(long id, int width, int height) {
		this.width = width;
		this.height = height;
		Renderer.Viewport(0, 0, width, height);
	}
	
	public boolean Running() {
		return glfwWindowShouldClose(id) == false;
	}
	
	public void Update() {
		glfwPollEvents();
		context.SwapBuffers();
	}
	
	public void Destroy() {
		Callbacks.glfwFreeCallbacks(id);
		glfwDestroyWindow(id);
	}
	
	public void Close() {
		glfwTerminate();
	}
	
	public int GetWidth() {
		return width;
	}
	
	public int GetHeight() {
		return height;
	}
	
	public long ID() {
		return id;
	}
}
