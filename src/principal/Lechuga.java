package principal;

public class Lechuga extends Ingrediente{

	public Lechuga(String nombre, boolean preparado, int calidad) {
		super(nombre, preparado, calidad);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	//Metodo de lavar
	public boolean lavar(boolean preparado) {
		
		preparado = true;
		return preparado;
	}
	

}
