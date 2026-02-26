package principal;
//Subclase de ingredientes
public class Carne extends Ingrediente{
	//Constructor con atributos heredados
	public Carne(String nombre, boolean preparado, int calidad) {
		super(nombre, preparado, calidad);
		
	}
	//Método cocinar para preparar la carne
	public boolean cocinar(boolean preparado) {
		
		preparado = true;
		
		return preparado;
		
	}
}
