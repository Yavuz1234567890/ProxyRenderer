package shader;

import static org.lwjgl.opengl.GL20.*;

public class ShaderProgram {
	private int id;
	
	public ShaderProgram() {
		id = glCreateProgram();
		if(id == GL_FALSE)return;
	}
	
	public void AddShader(Shader... shaders) {
		for(int shader = 0; shader < shaders.length; shader++) {
			if(id != GL_FALSE)glAttachShader(id, shaders[shader].ID());
		}
	}
	
	public void AddShader(Shader shader) {
		if(id != GL_FALSE)glAttachShader(id, shader.ID());
	}
	
	public void Link() {
		if(id != GL_FALSE) {
			glLinkProgram(id);
			glValidateProgram(id);
		}
	}
	
	public void Bind() {
		if(id != GL_FALSE)glUseProgram(id);
	}
	
	public void Unbind() {
		glUseProgram(0);
	}
	
	public int ID() {
		return id;
	}
}
