package principal;
//Subclase de ingredientes
public class Carne extends Ingrediente implements Preparados{
	//Constructor con atributos heredados
	public Carne(String nombre, boolean preparado, int calidad) {
		super(nombre, preparado, calidad);
		
	}
	//Constructor sobrecargado
	public Carne(String nombre) {
        super(nombre, false, 1);
    }
	
	//Sobreescribimos y preparamos cada ingrediente de forma diferente
	 @Override
	    public void preparar() {
	        System.out.println("Cocinando la carne ...");
	        this.preparado = true;
	    }
}
