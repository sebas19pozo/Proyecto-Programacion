package principal;
//Subclase de ingredientes
public class Lechuga extends Ingrediente{
	//Constructor con atributos heredados
	public Lechuga(String nombre, boolean preparado, int calidad) {
		super(nombre, preparado, calidad);
	}

	//Metodo de lavar para preparar la lechuga
	public boolean lavar(boolean preparado) {
		
		preparado = true;
		return preparado;
	}
	

}
