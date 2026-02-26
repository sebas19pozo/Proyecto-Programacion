package principal;
//Subclase de ingredientes
public class Pan extends Ingrediente{
	//Constructor con atributos heredados
	public Pan(String nombre, boolean preparado, int calidad) {
		super(nombre, preparado, calidad);
	}
	
	//Metodo tostar para preparar el pan
	public boolean tostar(boolean preparado) {
		preparado = true;
		return preparado;
		
	}
	

}
