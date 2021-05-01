package display;

import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.glfw.Callbacks;
import org.lwjgl.glfw.GLFWVidMode;

import core.Context;

public class Window {
	private static final int NULL = 0, TRUE = 1;
	private long id;
	private Context context;
	
	public Window(String title, int width, int height) {
		glfwInit();
		id = glfwCreateWindow(width, height, title, NULL, NULL);
		if(id == NULL)System.err.println("Window creation failed!");
		GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(id, (vidmode.width() - width) / 2, (vidmode.height() - height) / 2);
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
