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
	
	public boolean isPreparado() {
		return preparado;
	}




	public void setPreparado(boolean preparado) {
		this.preparado = preparado;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	protected boolean preparar() {
		
		return true;
	}
	

}
