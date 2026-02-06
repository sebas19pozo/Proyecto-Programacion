package principal;

public class Carne extends Ingrediente{

	public Carne(String nombre, boolean preparado, int calidad) {
		super(nombre, preparado, calidad);
		
	}

	
	public boolean cocinar(boolean preparado) {
		
		preparado = true;
		
		return preparado;
		
	}
}
