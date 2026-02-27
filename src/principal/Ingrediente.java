package principal;

public abstract class Ingrediente {
	//Definimos los atributos, que serán heredados por las clases hijas
	protected String nombre;
	protected boolean preparado;
	protected int calidad;
	
	//Inicializamos el constructor
	public Ingrediente(String nombre, boolean preparado, int calidad) {
		this.nombre = nombre;
		this.preparado = preparado;
		this.calidad = calidad;
	}

	//Metodo Preparar
	
	public boolean isPreparado() {
		return preparado;
	}
	
	//Getters y Setters
	public void setPreparado(boolean preparado) {
		this.preparado = preparado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//Método para preparar el ingrediente
	public abstract void preparar();
	
}
