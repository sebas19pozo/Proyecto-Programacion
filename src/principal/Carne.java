package principal;

public class Carne extends Ingrediente{

	public Carne(String nombre, boolean preparado, int calidad) {
		super(nombre, preparado, calidad);
		// TODO Auto-generated constructor stub
	}

	
	public boolean cocinar(boolean preparado) {
		
		preparado = true;
		
		return preparado;
		
	}
}
