package principal;

public class Pan extends Ingrediente{

	public Pan(String nombre, boolean preparado, int calidad) {
		super(nombre, preparado, calidad);
		// TODO Auto-generated constructor stub
	}
	

	public boolean tostar(boolean preparado) {
		
		preparado = true;
		
		return preparado;
		
	}
	

}
