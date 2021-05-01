package shader;

import static org.lwjgl.opengl.GL20.*;

import core.RenderObject;

public class Shader extends RenderObject {
	public Shader(int type) {
		id = glCreateShader(type);
		if(id == GL_FALSE)return;
	}
	
	public void Load(String shadersrc) {
		if(id != GL_FALSE) {
			glShaderSource(id, shadersrc);
			glCompileShader(id);
		}
	}
	
	public void ShowErrors() {
		if(glGetShaderi(id, GL_COMPILE_STATUS) != 1)
			System.err.println(glGetShaderInfoLog(id));
	}
}
