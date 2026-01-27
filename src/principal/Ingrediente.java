package principal;

public class Ingrediente {
	
	protected String nombre;
	protected boolean preparado;
	protected int calidad;
	
	
	//Constructor
	public Ingrediente(String nombre, boolean preparado, int calidad) {
		super();
		this.nombre = nombre;
		this.preparado = preparado;
		this.calidad = calidad;
	}
	
	
	
	//Metodo Preparar
	
	protected boolean preparar() {
		
		return true;
	}
	

}
