package shader;

import static org.lwjgl.opengl.GL20.*;

public class Shader {
	private int id;
	
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
	
	public int ID() {
		return id;
	}
}
