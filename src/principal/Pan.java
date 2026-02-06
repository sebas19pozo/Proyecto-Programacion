package principal;

public class Pan extends Ingrediente{

	public Pan(String nombre, boolean preparado, int calidad) {
		super(nombre, preparado, calidad);
		
	}
	

	public boolean tostar(boolean preparado) {
		
		preparado = true;
		
		return preparado;
		
	}
	

}
