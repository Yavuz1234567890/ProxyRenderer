package shader;

import static org.lwjgl.opengl.GL20.*;

import core.RenderObject;

public class ShaderProgram extends RenderObject {
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
	
	@Override
	public void Bind() {
		if(id != GL_FALSE)glUseProgram(id);
	}
	
	@Override
	public void Unbind() {
		glUseProgram(0);
	}
}
