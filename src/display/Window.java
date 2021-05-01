package display;

import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.glfw.Callbacks;

import core.Context;

public class Window {
	private static final int NULL = 0, TRUE = 1;
	private long id;
	private Context context;
	
	public Window(String title, int width, int height) {
		glfwInit();
		id = glfwCreateWindow(width, height, title, NULL, NULL);
		if(id != TRUE)System.err.println("Window creation failed!");
		context = new Context(this);
		context.CreateContext();
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
	
	public long ID() {
		return id;
	}
}
