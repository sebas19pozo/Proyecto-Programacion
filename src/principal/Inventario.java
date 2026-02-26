package principal;

import java.util.ArrayList;

public class Inventario {
	//Definimos los atributos
    ArrayList<Ingrediente> inventario = new ArrayList<>();
    double dinero;

    //Inicializamos el constructor
    public Inventario(ArrayList<Ingrediente> inventario, double dinero) {
        this.inventario = inventario;
        this.dinero = dinero;
    }
    //Método para añadir ingredientes al inventario
    public void agregarIngrediente(Ingrediente ingrediente, int cantidad) {
        for(int i = 0; i < cantidad; i++) {
        	if (ingrediente instanceof Lechuga) {
                inventario.add(new Lechuga(ingrediente.getNombre(), false, 1));
            } else if (ingrediente instanceof Carne) {
                inventario.add(new Carne(ingrediente.getNombre(), false, 1));
            } else if (ingrediente instanceof Pan) {
                inventario.add(new Pan(ingrediente.getNombre(), false, 1));
            }
        }
    }
    //Método para eliminar ingredientes del inventario
    public boolean consumirIngrediente(Ingrediente cualquiera) {
        for(int i = 0; i < inventario.size(); i++) {
            if(inventario.get(i).getClass() == cualquiera.getClass()) {
                inventario.remove(i);
                System.out.println("Usaste 1x " + cualquiera.getNombre());
                return true;
            }
        }
        return false;
    }

    // Método para comprar ingredientes con el dinero disponible
    public void comprarIngrediente(String tipo, int cantidad) {
        double precioUnitario = 0;
        Ingrediente nuevoIngrediente = null;

        switch(tipo.toLowerCase()) {
            case "lechuga":
                precioUnitario = 5;
                nuevoIngrediente = new Lechuga("Lechuga", false, 1);
                break;
            case "carne":
                precioUnitario = 7;
                nuevoIngrediente = new Carne("Carne", false, 1);
                break;
            case "pan":
                precioUnitario = 3;
                nuevoIngrediente = new Pan("Pan", false, 1);
                break;
            default:
                System.out.println("Ingrediente inválido.");
                return;
        }

        double costeTotal = precioUnitario * cantidad;
        if(dinero >= costeTotal) {
            agregarIngrediente(nuevoIngrediente, cantidad);
            dinero -= costeTotal;
            System.out.println("Compraste " + cantidad + " " + tipo + "(s) por " + costeTotal + " euros");
        } else {
            System.out.println("No tienes suficiente dinero para comprar " + cantidad + " " + tipo + "(s).");
        }
    }
}
