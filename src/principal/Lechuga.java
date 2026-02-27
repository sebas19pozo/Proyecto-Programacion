package principal;
//Subclase de ingredientes
public class Lechuga extends Ingrediente implements Preparados{
	//Constructor con atributos heredados
	public Lechuga(String nombre, boolean preparado, int calidad) {
		super(nombre, preparado, calidad);
	}

	//Constructor sobrecargado
	public Lechuga(String nombre) {
        super(nombre, false, 1);
    }
	
	//Sobreescribimos y preparamos cada ingrediente de forma diferente
	@Override
    public void preparar() {
        System.out.println("Lavando lechuga...");
        this.preparado = true;
    }
}
