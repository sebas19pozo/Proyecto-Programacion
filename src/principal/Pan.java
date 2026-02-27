package principal;
//Subclase de ingredientes
public class Pan extends Ingrediente implements Preparados {
	//Constructor con atributos heredados
	public Pan(String nombre, boolean preparado, int calidad) {
		super(nombre, preparado, calidad);
	}
	
	 //Constructor sobrecargado 
    public Pan(String nombre) {
        super(nombre, false, 1);  // Suponemos que la calidad inicial es la más baja: 1
    }

	//Sobreescribimos y preparamos cada ingrediente de forma diferente
		 @Override
		    public void preparar() {
		        System.out.println("Tostando el pan...");
		        this.preparado = true;
		    }
}
