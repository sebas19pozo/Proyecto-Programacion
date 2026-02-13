package principal;

import java.util.ArrayList;

public class Inventario {

	ArrayList<Ingrediente> inventario = new ArrayList<>();
	
	public Inventario() {
	    this.inventario = new ArrayList<>();
	}
	
	
	
	public void agregarIngrediente(Ingrediente ingrediente, int cantidad) {
		
		for(int i = 0 ; i<cantidad ; i++) {
		inventario.add(ingrediente);
		
		}
	}
	
	public boolean consumirIngrediente(Ingrediente cualquiera) {
		
		for(int i = 0; i<inventario.size(); i++) {
			
			if(inventario.get(i).getClass() == cualquiera.getClass()) {
				inventario.remove(i);
				System.out.println("Usaste 1x "+cualquiera.getNombre());
				return true;
			}
		}
		
		return false;
		
	}



	public ArrayList<Ingrediente> getInventario() {
		return inventario;
	}



	public void setInventario(ArrayList<Ingrediente> inventario) {
		this.inventario = inventario;
	}
	
	
	
}
